package com.deepakchandwani.hcl.test.repository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.deepakchandwani.hcl.test.SQLConstants;
import com.deepakchandwani.hcl.test.entity.*;

@Repository
public interface MeetingRoomRepository extends JpaRepository<MeetingRoom, Integer>{
	
	@Query(value = SQLConstants.FIND_MEETING_ROOM_DATE_RANGE, nativeQuery = true)
	List<MeetingRoom> findMeetingRoomAvailable(Timestamp db, Timestamp de);
	
	@Query(value = SQLConstants.CHECK_MEETING_ROOM_DATE_RANGE, nativeQuery = true)
	MeetingRoom checkAvailability(Date date, Date date2, int id);

}
