package com.deepakchandwani.hcl.test;

public class SQLConstants {

 
	
	public static void main(String[] args) {
		System.out.println("");
	}

	public static final String FIND_RESERVATION_ROOM_BY_NAME = 
	"SELECT * " + 
	"" + 
	"FROM   reservation_entity " + 
	"" + 
	"WHERE  room_id = (SELECT id " + 
	"                  FROM   MEETING_ROOM_ENTITY " + 
	"                  WHERE  DESCRIPTION = ?1) ";


	public static final String CHECK_MEETING_ROOM_DATE_RANGE = "select * from (select * from MEETING_ROOM_ENTITY  where id not in " 
	+ "(select room_id from RESERVATION_ENTITY  where (date_begin >= ?1 and date_begin < ?2) " 
	+ "or (date_end >= ?1 and date_end < ?2)))  where id = ?3";


	public static final String FIND_MEETING_ROOM_DATE_RANGE = "select * from MEETING_ROOM_ENTITY  " 
	+ "where id not in " 
	+ "("
	+ "select room_id "
	+ "from RESERVATION_ENTITY  " 
	+ "where (date_begin >= ?1 and date_begin < ?2) "
	+ "or (date_end >= ?1 and date_end < ?2) "
	+ ")";

}
