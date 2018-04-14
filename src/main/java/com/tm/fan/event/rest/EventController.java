package com.tm.fan.event.rest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.tm.fan.event.bean.RequestBean;
import com.tm.fan.event.exception.EventException;
import com.tm.fan.event.service.EventService;
import com.tm.fan.event.util.Constants;

@Path("event")
public class EventController {
	EventService eventService;
	
	@GET 
	//@Produces(MediaType.TEXT_PLAIN)
	public Response getAvailSeats(@QueryParam("eventId") int eventId,@QueryParam("type") Character type,@QueryParam("isAisle") Character isAisle){
		eventService = new EventService();
		String cntResponse = "";
		try{
			RequestBean requestBean = new RequestBean(String.valueOf(eventId),String.valueOf(isAisle==null?'N':isAisle),String.valueOf(type==null?'N':type));			
			String validationResponse = eventService.validateInput(requestBean); 
			if(!validationResponse.equals(Constants.SUCCESS)){
				return Response.status(Status.NOT_FOUND).entity(new EventException(Constants.E001_MSG,Constants.E001,"Please send the correct format of input parameters")).build();
			}
			
			if(requestBean.getEventId() != null && !requestBean.getEventId().equals("0"))
				cntResponse= eventService.getCountbyEvent(Integer.parseInt(requestBean.getEventId()));
			else
				cntResponse = eventService.getCountbyTypeAisle(requestBean.getType().charAt(0),requestBean.getAisle().charAt(0));
			
			if(cntResponse == null || cntResponse.equals(""))
				throw new NullPointerException();

			return Response.ok(cntResponse, MediaType.APPLICATION_JSON).build();
		}catch(NullPointerException ne){
			//Log Exception
			System.out.println("Null Pointer Exception");
			return Response.status(Status.NOT_FOUND).entity(new EventException(Constants.E002_MSG,Constants.E002,"No Data Found for given Input")).build();
		}catch(NumberFormatException nfe){
			System.out.println("Invalid Number for EventId");
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(new EventException(Constants.E001_MSG,Constants.E001,"Invalid Input for Event Id.")).build();
		}
		catch(Exception e){
			System.out.println("Server Error");
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(new EventException(Constants.E005_MSG,Constants.E005,"Something went badly wrong. Please try again later")).build();
		}	
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
    public Response getAllEvents(@Context HttpHeaders httpHeaders) {
		try{
			int id=Integer.parseInt(httpHeaders.getHeaderString("eventId"));
			if(id < 1)
				return Response.status(Status.NOT_FOUND).entity(new EventException(Constants.E001_MSG,Constants.E001,"Please send the correct format of input parameters")).build();
			
			eventService = new EventService();
			String cntResponse = eventService.getCountbyEvent(id);
			
			if(cntResponse == null || cntResponse.equals(""))
				throw new NullPointerException();
			else
				return Response.ok(cntResponse, MediaType.APPLICATION_JSON).build();
		}catch(NullPointerException ne){
			System.out.println("Null Pointer Exception");
			return Response.status(Status.NOT_FOUND).entity(new EventException(Constants.E002_MSG,Constants.E002,"No Data Found for given Input")).build();
		}catch(NumberFormatException nfe){
			System.out.println("Invalid Number for EventId");
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(new EventException(Constants.E001_MSG,Constants.E001,"Invalid Input for Event Id.")).build();
		}
		catch(Exception e){
			System.out.println("Server Error");
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(new EventException(Constants.E005_MSG,Constants.E005,"Something went badly wrong. Please try again later")).build();
		}		
    }
}