package com.deepakchandwani.hcl.test.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.deepakchandwani.hcl.test.SQLConstants;
import com.deepakchandwani.hcl.test.entity.MeetingRoom;
import com.deepakchandwani.hcl.test.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer>{
	
	@Query(value = SQLConstants.FIND_RESERVATION_ROOM_BY_NAME, nativeQuery = true)
	List<Booking> findByName(String name);

}
