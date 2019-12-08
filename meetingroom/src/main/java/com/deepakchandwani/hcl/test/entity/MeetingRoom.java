package com.deepakchandwani.hcl.test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MEETING_ROOM_ENTITY")
public class MeetingRoom {
	
	@Override
	public String toString() {
		return "MeetingRoom [id=" + id + ", description=" + description + ", capacity=" + capacity + ", location="
				+ location + ", floor=" + floor + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hclbookingapi")
	private int id;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="CAPACITY")
	private int capacity;
	
	@Column(name="LOCATION")
	private String location;
	
	@Column(name="FLOOR")
	private String floor;

	public MeetingRoom() {
		super();
 	}

	public MeetingRoom(int id, String description, int capacity, String location , String floor) {
		super();
		this.id = id;
		this.description = description;
		this.capacity = capacity;
		this.location = location;
		this.floor=floor;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public MeetingRoom( String description, int capacity, String location) {
		super();
		this.description = description;
		this.capacity = capacity;
		this.location = location;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String name) {
		this.description = name;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	

}
