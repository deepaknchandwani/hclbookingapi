package com.deepakchandwani.hcl.test.interfaces;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deepakchandwani.hcl.test.entity.MeetingRoom;
import com.deepakchandwani.hcl.test.entity.Booking;

// TODO: Auto-generated Javadoc
/**
 * The Interface BookingService.
 */
@Service
@Transactional
public interface BookingService {
	
	/**
	 * Creates the reservation.
	 *
	 * @param reservation the reservation
	 * @return the reservations
	 */
	public Booking createBooking(Booking reservation);
    
    /**
     * Gets the reservations.
     *
     * @return the reservations
     */
    public List<Booking> getReservations();
    
    /**
     * Find by id.
     *
     * @param id the id
     * @return the reservations
     */
    public Booking findById(int id);
    
    /**
     * Delete reservations by id.
     *
     * @param id the id
     * @return the boolean
     */
    public Boolean deleteReservationsById(int id);
    
    /**
     * Find by name.
     *
     * @param name the name
     * @return the list
     */
    public List<Booking> findByName(String name);
}
