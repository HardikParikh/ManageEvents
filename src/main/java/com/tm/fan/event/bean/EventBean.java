package com.tm.fan.event.bean;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonRootName;

import com.tm.fan.event.bean.LocationBean;

@JsonRootName(value = "EventBean")
public class EventBean {
	
	/*Sample DataFormat for EventBean:
	 * id: 1, name: 'Music Concert', start_date: '2015-07-24 1:30pm', , duration: 2
	*/
	
	private int eventId;
	private String eventName;
	private Date eventDate;
	private int eventDuration;
	private List<LocationBean> locationBean;
	
	public EventBean(){
	}
	
	public EventBean(int i,String s, Date d, int t, List l){
		this.eventId = i;
		this.eventName = s;
		this.eventDate = d;
		this.eventDuration = t;
		this.locationBean = l;
	}
	
	public String toJSON(ArrayList<EventBean> eventArray){
		String JSONStr = "{";
		
		/*event
		[ { id: 1, name: 'Music Concert', start_date: '2015-07-24 1:30pm', , duration: 2,
			location: [ {  id: 1, address: 'Staples Center, Los Angeles', 
				seat: [ {id: 1, aisle: N, type: C }, {id: 2, aisle: Y, type: A }, {id: 3, aisle: Y, type: A }, {id: 4, aisle: N, type: A }, {id: 5, aisle: N, type: A }, 
						{id: 6, aisle: N, type: A }, {id: 7, aisle: N, type: A }, {id: 8, aisle: Y, type: A }, {id: 9, aisle: Y, type: A },	{id: 10, aisle: N, type: C } ]
			} ]
		  }
	    ]*/ 
		
		for (EventBean eventBean : eventArray) {
			JSONStr += "Event [ "
					+  "\"eventId\":" + eventBean.getEventId() + ",\"eventName\":\"" + eventBean.getEventName() + ",\"eventDate\":" + eventBean.getEventDate() 
					+  ",\"eventDuration\":" + eventBean.getEventDuration();
			for (LocationBean locationBean : eventBean.getLocationBean()) {
				JSONStr += ",location[" 
						+  "\"locationId\":" + locationBean.getLocationId() + ",\"locationAddress\":\"" + locationBean.getLocationAddress();				
				for (SeatBean seatBean : locationBean.getSeatBean()) {
					JSONStr += ",Seat[" 
							+  "\"SeatId\":" + seatBean.getSeatId() + ",\"Aisle\":\"" + (seatBean.getAisle()=='T'?"Aisle":seatBean.getAisle()=='F'?"Not Aisle":"No idea")
							+  ",\"Type\":\"" + (seatBean.getSeatType()=='A'?"Adult":"Child")
							+  "\"]";
				}
				JSONStr +=  "\"]";
			}
			JSONStr +=  "\"]";
		}
		JSONStr += "}";
		return JSONStr;
	}
	
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public int getEventDuration() {
		return eventDuration;
	}

	public void setEventDuration(int eventDuration) {
		this.eventDuration = eventDuration;
	}

	public List<LocationBean> getLocationBean() {
		return locationBean;
	}

	public void setLocationBean(List<LocationBean> locationBean) {
		this.locationBean = locationBean;
	}
}
