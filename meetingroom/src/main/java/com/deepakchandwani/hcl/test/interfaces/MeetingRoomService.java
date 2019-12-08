package com.deepakchandwani.hcl.test.interfaces;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deepakchandwani.hcl.test.entity.MeetingRoom;
import com.deepakchandwani.hcl.test.entity.Booking;

 // TODO: Auto-generated Javadoc
/**
 * The Interface MeetingRoomService.
 */
@Service
@Transactional
public interface MeetingRoomService {
	
	/**
	 * Creates the meeting room.
	 *
	 * @param meetingroom the meetingroom
	 */
	public void createMeetingRoom(MeetingRoom meetingroom);
    
    /**
     * Gets the meeting room.
     *
     * @return the meeting room
     */
    public List<MeetingRoom> getMeetingRoom();
    
    /**
     * Find by id.
     *
     * @param id the id
     * @return the meeting room
     */
    public MeetingRoom findById(int id);
    
    /**
     * Update.
     *
     * @param meetingroom the meetingroom
     * @param id the id
     * @return the meeting room
     */
    public MeetingRoom update(MeetingRoom meetingroom, int id);
    
    /**
     * Delete meeting room by id.
     *
     * @param id the id
     * @return the boolean
     */
    public Boolean deleteMeetingRoomById(int id);
    
     
     
    /**
     * Find meeting room available.
     *
     * @param start the start
     * @param end the end
     * @return the list
     */
    public List<MeetingRoom> findMeetingRoomAvailable(Date start, Date end);
}
