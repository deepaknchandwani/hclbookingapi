package com.deepakchandwani.hcl.test.meetingroom;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.deepakchandwani.hcl.test.Services.MeetingRoomServiceImp;
import com.deepakchandwani.hcl.test.entity.MeetingRoom;
import com.deepakchandwani.hcl.test.entity.ReservationDate;
import com.deepakchandwani.hcl.test.interfaces.MeetingRoomService;

@RestController
@RequestMapping("/meetingroom")
public class MeetingRoomController {
	
	@Autowired
    private MeetingRoomService meetingRoomServiceImp;
	
	@RequestMapping(value = "/get/allMeetingRoom",  method = RequestMethod.GET, produces = "application/json")
	public List<MeetingRoom> getAllMeetingRoom() {
        List<MeetingRoom> rooms=meetingRoomServiceImp.getMeetingRoom();
        return rooms;
	}
	
	@GetMapping(value = "/get/meetingRoomById/{id}", produces = "application/json")
    public ResponseEntity<MeetingRoom> getMeetingRoomById(@PathVariable("id") int id) {
        System.out.println("Fetching Meeting Room with id " + id);
        MeetingRoom meetingroom = meetingRoomServiceImp.findById(id);
        if (meetingroom == null) {
            return new ResponseEntity<MeetingRoom>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<MeetingRoom>(meetingroom, HttpStatus.OK);
    }

	@PostMapping(value="/create/meetingRoom",headers="Accept=application/json")
    public ResponseEntity<String> createmeetingRoom(@RequestBody MeetingRoom meetingroom, UriComponentsBuilder ucBuilder){
        System.out.println("Creating Meeting Room "+ meetingroom.getDescription());
        meetingRoomServiceImp.createMeetingRoom(meetingroom);
        return new ResponseEntity<String>("Meeting Room Created Successfully", HttpStatus.CREATED);
    }
	
	@DeleteMapping(value="/delete/meetingRoomById/{id}", headers ="Accept=application/json")
    public ResponseEntity<String> deletemeetingRoomById(@PathVariable("id") int id){
        MeetingRoom room = meetingRoomServiceImp.findById(id);
        if (room == null) {
            return new ResponseEntity<String>("No such meeting room", HttpStatus.NOT_FOUND);
        }
        meetingRoomServiceImp.deleteMeetingRoomById(id);
        return new ResponseEntity<String>("Meeting Room Deleted", HttpStatus.NO_CONTENT);
    }

	@PutMapping(value="/update/meetingRoom", headers="Accept=application/json")
    public ResponseEntity<MeetingRoom> updateMeetingRoom(@RequestBody MeetingRoom room){
        MeetingRoom meetingroom = meetingRoomServiceImp.findById(room.getId());
        if(meetingroom ==null){
            return new ResponseEntity<MeetingRoom>(HttpStatus.NOT_FOUND);
        }
        MeetingRoom r1 = meetingRoomServiceImp.update(room, room.getId());
        return new ResponseEntity<MeetingRoom>(r1, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/date",  method = RequestMethod.POST, produces = "application/json")
	public List<MeetingRoom> getAllReservationsByDate(@RequestBody ReservationDate dates) {
		System.out.println("Dates to enquire from: " + dates.getFromDate() + " to: " + dates.getToDate());
        List<MeetingRoom> rooms = meetingRoomServiceImp.findMeetingRoomAvailable(dates.getFromDate(), dates.getToDate());
        return rooms;
	}
}
