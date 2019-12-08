package com.deepakchandwani.hcl.test.Services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deepakchandwani.hcl.test.entity.MeetingRoom;
import com.deepakchandwani.hcl.test.exception.HCLTestGenericRunTimeException;
import com.deepakchandwani.hcl.test.interfaces.MeetingRoomService;
import com.deepakchandwani.hcl.test.repository.MeetingRoomRepository;

@Service
@Transactional
public class MeetingRoomServiceImp implements MeetingRoomService{

	@Autowired
	MeetingRoomRepository meetingRoomRepository;
	
	public MeetingRoomServiceImp(MeetingRoomRepository meetingRoomRepository) {
		super();
		this.meetingRoomRepository = meetingRoomRepository;
	}
	

	public MeetingRoomServiceImp() {
		super();
 	}


	@Override
	public void createMeetingRoom(MeetingRoom meetingroom) {
		meetingRoomRepository.save(meetingroom);
		
	}

	@Override
	public List<MeetingRoom> getMeetingRoom() {
		return (List<MeetingRoom>) meetingRoomRepository.findAll();
	}

	@Override
	public MeetingRoom findById(int id) {
		 Optional<MeetingRoom> optMeetingRoom = meetingRoomRepository.findById(id); // returns java8 optional
		    if (optMeetingRoom.isPresent()) {
		        return optMeetingRoom.get();
		    } else {
		       throw new HCLTestGenericRunTimeException("MeetingRoom", "Id", id);
		    }
	}

	@Override
	public MeetingRoom update(MeetingRoom meetingroom, int id) {
		Optional<MeetingRoom> optMeetingRoom = meetingRoomRepository.findById(id); // returns java8 optional
	    if (optMeetingRoom.isPresent()) {
	    	MeetingRoom newRoom = optMeetingRoom.get();
	    	newRoom.setDescription(meetingroom.getDescription());
	    	newRoom.setCapacity(meetingroom.getCapacity());
	    	newRoom.setLocation(meetingroom.getLocation());

	        MeetingRoom updatedroom = meetingRoomRepository.save(newRoom);
	        return updatedroom;
	    } else {
	    	throw new HCLTestGenericRunTimeException("MeetingRoom", "Id",id);
	    }
	}

	@Override
	public Boolean deleteMeetingRoomById(int id) {
		Optional<MeetingRoom> optMeetingRoom = meetingRoomRepository.findById(id); // returns java8 optional
	    if (optMeetingRoom.isPresent()) {
	    	meetingRoomRepository.delete(optMeetingRoom.get());
	        return true;
	    } else {
	       throw new HCLTestGenericRunTimeException("MeetingRoom", "Id",id);
	    }
	}

	@Override
	public List<MeetingRoom> findMeetingRoomAvailable(Date db, Date de) {
		return (List<MeetingRoom>) meetingRoomRepository.findMeetingRoomAvailable(
				new java.sql.Timestamp (db.getTime()), 
				new java.sql.Timestamp (de.getTime()));
	}


}
