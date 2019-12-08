package com.deepakchandwani.hcl.test.Services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deepakchandwani.hcl.test.entity.MeetingRoom;
import com.deepakchandwani.hcl.test.entity.Booking;
import com.deepakchandwani.hcl.test.exception.HCLTestGenericRunTimeException;
import com.deepakchandwani.hcl.test.interfaces.BookingService;
import com.deepakchandwani.hcl.test.repository.MeetingRoomRepository;
import com.deepakchandwani.hcl.test.repository.BookingRepository;

@Service
@Transactional
public class BookingServiceImp  implements BookingService{

	@Autowired
	BookingRepository bookingRepository;
	
	@Autowired
	MeetingRoomRepository meetingRoomRepository;

	public BookingServiceImp() {
		super();
 	}

	public BookingServiceImp(com.deepakchandwani.hcl.test.repository.BookingRepository bookingRepository) {
		super();
		bookingRepository = bookingRepository;
	}

	@Override
	public List<Booking> getReservations() {
		return (List<Booking>) bookingRepository.findAll();
	}

	@Override
	public Booking findById(int id) {
		 Optional<Booking> optReservation = bookingRepository.findById(id); // returns java8 optional
		    if (optReservation.isPresent()) {
		        return optReservation.get();
		    } else {
		       throw new HCLTestGenericRunTimeException("Booking", "Id", id);
		    }
	}

	@Override
	public Boolean deleteReservationsById(int id) {
		 Optional<Booking> optReservation = bookingRepository.findById(id); // returns java8 optional
		 if (optReservation.isPresent()) {
			 bookingRepository.delete(optReservation.get());
			 return true;
		    } else {
		       throw new HCLTestGenericRunTimeException("Booking", "Id", id);
		    }
	}

	@Override
	public List<Booking> findByName(String name) {
		return (List<Booking>) bookingRepository.findByName(name);
	}

	@Override
	public Booking createBooking(Booking reservation) {
		System.out.println("Reservation to create: " + reservation);
		MeetingRoom room = meetingRoomRepository.checkAvailability(
				/*
				 * new java.sql.Timestamp (reservation.getDateBegin().getTime()), new
				 * java.sql.Timestamp (reservation.getDateEnd().getTime()),
				 */ 
				reservation.getDateBegin(),reservation.getDateEnd(),
				reservation.getRoomId());
		System.out.println("Room to book: " + room);
		if(room != null){
			Booking r = bookingRepository.save(reservation);
			return r;
		} else
			return null;
	}
	
	
}
