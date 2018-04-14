package com.tm.fan.event.bean;

public class SeatBean {

	/*Sample DataFormat for SeatBean:
	 * id: 1, aisle: N, type: A 
	*/
	
	private int seatId;
	private char isAisle;
	private char seatType;
	private boolean available;
	
	public SeatBean(int i,char a, char s, boolean b){
		this.seatId = i;
		this.isAisle = a;
		this.seatType = s;
		this.available = b;
	}
	
	public int getSeatId() {
		return seatId;
	}
	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}
	public char getAisle() {
		return isAisle;
	}
	public void setAisle(char isAisle) {
		this.isAisle = isAisle;
	}
	public char getSeatType() {
		return seatType;
	}
	public void setSeatType(char seatType) {
		this.seatType = seatType;
	}
	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}
}
