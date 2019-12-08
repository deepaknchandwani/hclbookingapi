/*
 * 
 */
package com.deepakchandwani.hcl.test.meetingroom;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.deepakchandwani.hcl.test.entity.Booking;
import com.deepakchandwani.hcl.test.interfaces.BookingService;

@RestController
@RequestMapping("/booking")
public class BookingController {  
	
	@Autowired
    private BookingService reservationServiceImp;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/get",  method = RequestMethod.GET, produces = "application/json")
	public List<Booking> getAllReservations() {
        List<Booking> rooms = reservationServiceImp.getReservations();
        return rooms;
	}
	
	@RequestMapping(value = "/get/{name}",  method = RequestMethod.GET, produces = "application/json")
	public List<Booking> getAllReservationsByName(@PathVariable("name") String name) {
        List<Booking> rooms = reservationServiceImp.findByName(name);
        return rooms;
	}
	
	
	@GetMapping(value = "/getBookingById/{id}", produces = "application/json")
    public ResponseEntity<Booking> getBookingById(@PathVariable("id") int id) {
        System.out.println("Fetching Reservation with id " + id);
        Booking reservation = reservationServiceImp.findById(id);
        if (reservation == null) {
            return new ResponseEntity<Booking>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Booking>(reservation, HttpStatus.OK);
    }
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping(value="/deleteBookingById/{id}", headers ="Accept=application/json")
    public ResponseEntity<String> deleteBookingById(@PathVariable("id") int id){
		Booking reservation = reservationServiceImp.findById(id);
        if (reservation == null) {
            return new ResponseEntity<String>("No such Reservation", HttpStatus.NOT_FOUND);
        }
        reservationServiceImp.deleteReservationsById(id);
        return new ResponseEntity<String>("Reservation Deleted", HttpStatus.NO_CONTENT);
    }

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value="/book",headers="Accept=application/json")
    public ResponseEntity<String> createReservation(@RequestBody Booking reservation){
        System.out.println("Creating Reservation "+ reservation);
        Booking r = reservationServiceImp.createBooking(reservation);
        if(r != null) {
        	return new ResponseEntity<String>("Booking Created Successfully", HttpStatus.CREATED);
        } else
        	return new ResponseEntity<String>("Failed to Book", HttpStatus.NO_CONTENT);
    }


}
