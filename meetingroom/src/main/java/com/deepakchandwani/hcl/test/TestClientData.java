package com.deepakchandwani.hcl.test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.deepakchandwani.hcl.test.entity.Booking;
import com.deepakchandwani.hcl.test.entity.MeetingRoom;

import io.swagger.models.HttpMethod;

public class TestClientData {
	
	public static void main(String[] args) {
		RestTemplate restTemplate = new RestTemplate();
		
		
		/*
		 * ResponseEntity<List<MeetingRoom>> responseEntity =
		 * restTemplate.exchange("localhost:8083/connectors/", HttpMethod.GET, null, new
		 * ParameterizedTypeReference<List<MeetingRoom>>() { }); List<MeetingRoom>
		 * listOfString = responseEntity.getBody();
		 */
		
		
		/*
		 * ResponseEntity<Object[]> responseEntity =
		 * restTemplate.getForEntity("http://localhost:8080/booking/get",
		 * Object[].class); List<Object> responseList =
		 * Arrays.asList(responseEntity.getBody());
		 * 
		 * System.out.println();
		 */
		
		RestTemplate template = new RestTemplate();
		/*
		 * createAMeetingRoom(template , "New York , Building A", 40);
		 * createAMeetingRoom(template , "California , Building C", 30);
		 * createAMeetingRoom(template , "New Delhi , Building D", 60);
		 * createAMeetingRoom(template , "Chicago , Building B", 40);
		 */ 

		  createABooking(template);
		  getAllMeetingRooms(restTemplate);
		  getAllBookings(restTemplate);
		 		
	}
	
	private static void createAMeetingRoom(RestTemplate template , String location , int rooms ) {
		
		for (int i=1;   i< rooms+1 ; i++) {
		
		MeetingRoom payload = new MeetingRoom();
 		payload.setCapacity( 10 + i%17);
		payload.setDescription("Meeting Room " + i );
		payload.setFloor( ""+(i*3+10)%50 );
		payload.setLocation(location);


		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<MeetingRoom> requestEntity = 
		     new HttpEntity<>(payload, headers);
		      ResponseEntity<String> response =   template.postForEntity("http://localhost:8080/meetingroom/create/meetingRoom",  requestEntity, String.class);
		System.out.println();}
	}

	private static void createABooking(RestTemplate template) {
		
		Date dateNow = new Date();
		long dateLong = dateNow.getTime();
		long halfHour= 1000*60*30;
		for (int i=0; i<50; i++) {
		Booking payload = new Booking();
		payload.setPurpose("Programatic Created HCL Test Booking Request " + i);
		payload.setDateBegin(new Date(dateLong +(i+1)*halfHour+ 1000));
		payload.setDateEnd(new Date(dateLong +(i+2)*halfHour+ 1000));
		payload.setRoomId(i%150 + 2);


		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<Booking> requestEntity = 
		     new HttpEntity<>(payload, headers);
		      ResponseEntity<String> response =   template.postForEntity("http://localhost:8080/booking/book",  requestEntity, String.class);
		System.out.println();
		}
	}
	
	private static void getAllMeetingRooms(RestTemplate restTemplate) {
		ResponseEntity<MeetingRoom[]> response = restTemplate.getForEntity(
		  "http://localhost:8080/meetingroom/get/allMeetingRoom", MeetingRoom[].class); MeetingRoom[]
		  meetingRooms = response.getBody();
		  
		  Stream<MeetingRoom> stream2 = Stream.of(meetingRooms);
		  stream2.forEach(System.out::println);
	}

	private static void getAllBookings(RestTemplate restTemplate) {
		ResponseEntity<Booking[]> response = restTemplate.getForEntity(
		  "http://localhost:8080/booking/get", Booking[].class); Booking[]
		  bookings = response.getBody();
		  
		  Stream<Booking> stream2 = Stream.of(bookings);
		  stream2.forEach(System.out::println);
	}
	

}
