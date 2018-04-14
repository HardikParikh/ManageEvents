package com.tm.fan.event.bean;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

public class ResponseCount {
	
	private int eventId;
	private int totalSeats;
	private int bookedSeats;
	
	
	@JsonCreator
	public ResponseCount(@JsonProperty("eventId") int e, 
	             @JsonProperty("totalSeats") int t,
	             @JsonProperty("bookedSeats") int b) {

		this.eventId = e;
		this.totalSeats = t;
		this.bookedSeats = b;
	}
	
	
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public int getTotalSeats() {
		return totalSeats;
	}
	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}
	public int getBookedSeats() {
		return bookedSeats;
	}
	public void setBookedSeats(int bookedSeats) {
		this.bookedSeats = bookedSeats;
	}

	@Override
	public String toString() {
		return "\"eventId\":" + eventId + ", \"totalSeats\":" + totalSeats + ", \"bookedSeats\":" + bookedSeats;
	}
}
