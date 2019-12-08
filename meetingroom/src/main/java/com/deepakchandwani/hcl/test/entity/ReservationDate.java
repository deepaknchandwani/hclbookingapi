package com.deepakchandwani.hcl.test.entity;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class ReservationDate {
	
	private Date fromDate;
	private Date toDate;
	
	public ReservationDate() {
		super();
 	}
	
	public ReservationDate(Date fromDate, Date toDate) {
		super();
		this.fromDate = fromDate;
		this.toDate = toDate;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	

}
