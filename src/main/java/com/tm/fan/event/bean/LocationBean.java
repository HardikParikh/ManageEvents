package com.tm.fan.event.bean;

import java.util.List;

public class LocationBean {
	
	/*Sample DataFormat for SeatBean:
	 * id: 1, aisle: N, type: A 
	*/
	
	private int locationId;
	private String locationAddress;
	private List<SeatBean> seatBean;
	
	public LocationBean(int i,String a, List s){
		this.locationId = i;
		this.locationAddress = a;
		this.seatBean = s;
	}
	
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	public String getLocationAddress() {
		return locationAddress;
	}
	public void setLocationAddress(String locationAddress) {
		this.locationAddress = locationAddress;
	}
	public List<SeatBean> getSeatBean() {
		return seatBean;
	}
	public void setSeatBean(List<SeatBean> seatBean) {
		this.seatBean = seatBean;
	}
}
