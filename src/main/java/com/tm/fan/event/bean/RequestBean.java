package com.tm.fan.event.bean;

public class RequestBean {
	private String eventId;
	private String aisle;
	private String type;
	
	public RequestBean(String e,String a,String t){
		this.eventId = e;
		this.aisle = a;
		this.type = t;
	}
	
	public String getEventId() {
		return eventId;
	}
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
	public String getAisle() {
		return aisle;
	}
	public void setAisle(String aisle) {
		this.aisle = aisle;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
