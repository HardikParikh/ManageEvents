package com.tm.fan.event.service;

import com.tm.fan.event.bean.EventBean;
import com.tm.fan.event.bean.LocationBean;
import com.tm.fan.event.bean.RequestBean;
import com.tm.fan.event.bean.ResponseCount;
import com.tm.fan.event.bean.SeatBean;
import com.tm.fan.event.dao.EventDAO;
import com.tm.fan.event.util.Constants;

import java.util.ArrayList;

public class EventService {
	
	EventDAO eventDAO;
	
	public String validateInput(RequestBean requestBean){
		
		if(requestBean.getEventId()!=null && !requestBean.getEventId().matches("[0-9]")) //Validating EventId is a number or not
			return Constants.FAILURE;
		if(requestBean.getType()!=null && !requestBean.getType().matches("[ACN]")) //Validating Type is Adult or Child
			return Constants.FAILURE;
		if(requestBean.getAisle()!=null && !requestBean.getAisle().matches("[TFN]")) //Validating Seat is Aisle or not
			return Constants.FAILURE;
		else
			return Constants.SUCCESS;
	}
	
	public ArrayList<EventBean> getAllEvents(){
		eventDAO = new EventDAO();
		ArrayList<EventBean> eventArray = null;	
		
		try{
			eventArray = eventDAO.getEventObj();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			eventDAO=null;
		}
    	return eventArray;	
	}
	
	public String getCountbyEvent(int eventId){
		boolean start=true;
		eventDAO = new EventDAO();
		String returnStr = "{";
		int totalCount = 0, bookedCount=0;
		ArrayList<EventBean> eventArray = null;	
		try{
			eventArray = eventDAO.getEventObj();
			for (EventBean eventBean : eventArray) {
				if(eventBean.getEventId() == eventId){
					for (LocationBean locationBean : eventBean.getLocationBean()) {
						for (SeatBean seatBean : locationBean.getSeatBean()) {
							totalCount++;
							if(seatBean.isAvailable() == true)
								bookedCount++;
						}					
					}
					ResponseCount responseCnt = new ResponseCount(eventBean.getEventId(),totalCount,bookedCount);
					if(start){
						returnStr += "{" + responseCnt.toString() + "}";
						start=false;
					}else {
						returnStr += ",{" + responseCnt.toString() + "}";
					}
					totalCount = 0;bookedCount=0;
				}
			}
			returnStr += "}";
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			eventArray=null;
		}
    	return returnStr;	
	}
	
	public String getCountbyTypeAisle(Character type, Character isAisle){
		eventDAO = new EventDAO();
		
		int totalCount=0;
		int bookedCount=0;
		boolean start=true;
		ArrayList<EventBean> eventArray = null;	
		String returnStr ="{";
		try{
			eventArray = eventDAO.getEventObj();
			for (EventBean eventBean : eventArray) {
				for (LocationBean locationBean : eventBean.getLocationBean()) {
					for (SeatBean seatBean : locationBean.getSeatBean()) {
						if((isAisle!='N' && (seatBean.getAisle()== isAisle)) && (type !='N' && seatBean.getSeatType() == type)){
							totalCount++;
							if(seatBean.isAvailable() == true)
								bookedCount++;
						}else if((isAisle!='N' && (seatBean.getAisle()== isAisle)) && type=='N'){
							totalCount++;
							if(seatBean.isAvailable() == true)
								bookedCount++;
						}else if(isAisle=='N' && (type !='N' && seatBean.getSeatType() == type)){
							totalCount++;
							if(seatBean.isAvailable() == true)
								bookedCount++;
						}else if(isAisle=='N' && type=='N'){
							totalCount++;
							if(seatBean.isAvailable() == true)
								bookedCount++;
						}
					}	
				}
				ResponseCount responseCnt = new ResponseCount(eventBean.getEventId(),totalCount,bookedCount);
				if(start){
					returnStr += "{" + responseCnt.toString() + "}";
					start=false;
				}else {
					returnStr += ",{" + responseCnt.toString() + "}";
				}
				totalCount = 0;bookedCount=0;
			}
			returnStr += "}";
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			eventArray=null;
		}
    	return returnStr;	
	}
}