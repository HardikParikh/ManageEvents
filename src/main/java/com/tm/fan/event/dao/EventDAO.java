package com.tm.fan.event.dao;

import java.util.ArrayList;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnore;
import com.tm.fan.event.bean.EventBean;
import com.tm.fan.event.bean.LocationBean;
import com.tm.fan.event.bean.SeatBean;

public class EventDAO {
	EventDAO eventDAO = null;
	
	@JsonIgnore
	public ArrayList<EventBean> getEventObj() {
		ArrayList<EventBean> eventArray = new ArrayList<EventBean>();
		
		/*try{
			ObjectMapper obj = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			String data ="	{ "
						+"		\"EventBean\":  "
						+"			[ { \"eventId\": 1,  "
						+"			    \"eventName\": \"Music Concert\",  "
						+"			    \"eventDate\": \"2015-07-24 1:30pm\", "
						+"			    \"eventDuration\": 120, "
						+"				\"locationBean\": [ {   "
						+"				              	  \"locationId\": 1, " 
						+"					              \"locationAddress\": \"Staples Center, Los Angeles\", " 
						+"						          \"seatBean\": [ { \"seatId\": 1, \"aisle\": \"N\", \"type\": \"C\" },  " 
						+"					                  { \"seatId\": 2, \"aisle\": \"Y\", \"type\": \"A\" },  "
						+"						              { \"seatId\": 3, \"aisle\": \"Y\", \"type\": \"A\" },  "
						+"					                  { \"seatId\": 4, \"aisle\": \"N\", \"type\": \"A\" },  "
						+"					                  { \"seatId\": 5, \"aisle\": \"N\", \"type\": \"A\" },  "
						+"					                  { \"seatId\": 6, \"aisle\": \"N\", \"type\": \"A\" },  "
						+"					                  { \"seatId\": 7, \"aisle\": \"N\", \"type\": \"A\" },  "
						+"					                  { \"seatId\": 8, \"aisle\": \"Y\", \"type\": \"A\" },  "
						+"					                  { \"seatId\": 9, \"aisle\": \"Y\", \"type\": \"A\" },	 "
						+"									  { \"seatId\": 10, \"aisle\": \"N\", \"type\": \"C\" }  "
						+"					                ] "
						+"				          }] "
						+"			  }, "
						+"			  { "
						+"				\"eventId\": 2, " 
						+"			    \"eventName\": \"Live Drama\", " 
						+"			    \"eventDate\": \"2015-07-24 7:30pm\", "
						+"				\"eventDuration\": 150, "
						+"				\"locationBean\": [ {   "
						+"					              \"locationId\": 2, " 
						+"					              \"locationAddress\": \"Honda Center, Anaheim\", " 
						+"						          \"seatBean\": [ { \"id\": 1, \"aisle\": \"Y\", \"type\": \"A\" },  " 
						+"						              { \"seatId\": 2, \"aisle\": \"N\", \"type\": \"C\" },  "
						+"					                  { \"seatId\": 3, \"aisle\": \"N\", \"type\": \"A\" },  "
						+"					                  { \"seatId\": 4, \"aisle\": \"N\", \"type\": \"A\" },  "
						+"						              { \"seatId\": 5, \"aisle\": \"N\", \"type\": \"A\" },  "
						+"									  { \"seatId\": 6, \"aisle\": \"N\", \"type\": \"A\" },  "
						+"					                  { \"seatId\": 7, \"aisle\": \"N\", \"type\": \"A\" },  "
						+"					                  { \"seatId\": 8, \"aisle\": \"Y\", \"type\": \"A\" },  "
						+"					                  { \"seatId\": 9, \"aisle\": \"N\", \"type\": \"C\" },	 "
						+"					                  { \"seatId\": 10, \"aisle\": \"Y\", \"type\": \"A\" }  "
						+"						                ] "
						+"				          }] "
						+"				  }, "
						+"		    ] "
						+"	}	 ";
			
			eventArray.add(obj.readValue(data, EventBean.class));
			return eventArray;
		}catch(Exception e){
			e.printStackTrace();
		}
		/*
		event
			[ { id: 1, name: 'Music Concert', start_date: '2015-07-24 1:30pm', , duration: 120,
				location: [ {  id: 1, address: 'Staples Center, Los Angeles', 
					seat: [ {id: 1, aisle: N, type: C }, {id: 2, aisle: Y, type: A }, {id: 3, aisle: Y, type: A }, {id: 4, aisle: N, type: A }, {id: 5, aisle: N, type: A }, 
							{id: 6, aisle: N, type: A }, {id: 7, aisle: N, type: A }, {id: 8, aisle: Y, type: A }, {id: 9, aisle: Y, type: A },	{id: 10, aisle: N, type: C } ]
				} ]
			  },
			  { id: 2, name: 'Live Drama', start_date: '2018-04-11 7:30pm', duration: 150,
				location: [ {  id: 1, address: 'Staples Center, Los Angeles', 
					seat: [ {id: 21, aisle: Y, type: A }, {id: 22, aisle: N, type: C }, {id: 23, aisle: Y, type: A }, {id: 24, aisle: N, type: A }, {id: 25, aisle: N, type: A }, 
							{id: 26, aisle: N, type: A }, {id: 27, aisle: N, type: A }, {id: 28, aisle: N, type: A }, {id: 29, aisle: N, type: C },	{id: 30, aisle: Y, type: A } ]
				} ]
			  }
		    ]
		*/
	
		
		ArrayList<LocationBean> locationArray = new ArrayList<LocationBean>();		
		ArrayList<SeatBean> seatArray = new ArrayList<SeatBean>();
			//Row 1:
			seatArray.add(new SeatBean(1,'F','A',false));
			seatArray.add(new SeatBean(2,'F','C',false));
			seatArray.add(new SeatBean(3,'T','A',true));			
			seatArray.add(new SeatBean(4,'T','A',true));
			seatArray.add(new SeatBean(5,'F','A',false));
			seatArray.add(new SeatBean(6,'F','A',false));
			seatArray.add(new SeatBean(7,'F','A',true));
			seatArray.add(new SeatBean(8,'F','A',true));
			seatArray.add(new SeatBean(9,'F','A',true));
			seatArray.add(new SeatBean(10,'T','A',false));			
			seatArray.add(new SeatBean(11,'T','A',true));
			seatArray.add(new SeatBean(12,'F','C',true));
			seatArray.add(new SeatBean(13,'F','A',false));			
			//Row 2:
			seatArray.add(new SeatBean(14,'F','A',false));
			seatArray.add(new SeatBean(15,'F','C',false));
			seatArray.add(new SeatBean(16,'T','A',true));			
			seatArray.add(new SeatBean(17,'T','A',true));
			seatArray.add(new SeatBean(18,'F','A',false));
			seatArray.add(new SeatBean(19,'F','A',false));
			seatArray.add(new SeatBean(20,'F','A',false));
			seatArray.add(new SeatBean(21,'F','A',true));
			seatArray.add(new SeatBean(22,'F','A',true));
			seatArray.add(new SeatBean(23,'T','A',false));			
			seatArray.add(new SeatBean(24,'T','A',true));
			seatArray.add(new SeatBean(25,'F','C',false));
			seatArray.add(new SeatBean(26,'F','A',false));
			//Row 3:
			seatArray.add(new SeatBean(14,'F','A',true));
			seatArray.add(new SeatBean(15,'F','A',true));
			seatArray.add(new SeatBean(16,'T','A',true));			
			seatArray.add(new SeatBean(17,'T','A',true));
			seatArray.add(new SeatBean(18,'F','A',true));
			seatArray.add(new SeatBean(19,'F','A',true));
			seatArray.add(new SeatBean(20,'F','A',true));
			seatArray.add(new SeatBean(21,'F','A',true));
			seatArray.add(new SeatBean(22,'F','A',true));
			seatArray.add(new SeatBean(23,'T','A',true));			
			seatArray.add(new SeatBean(24,'T','A',true));
			seatArray.add(new SeatBean(25,'F','A',true));
			seatArray.add(new SeatBean(26,'F','A',true));
			//Row 4:
			seatArray.add(new SeatBean(27,'F','A',true));
			seatArray.add(new SeatBean(28,'F','C',true));
			seatArray.add(new SeatBean(29,'T','A',true));			
			seatArray.add(new SeatBean(30,'T','A',true));
			seatArray.add(new SeatBean(31,'F','A',true));
			seatArray.add(new SeatBean(32,'F','A',true));
			seatArray.add(new SeatBean(33,'F','A',true));
			seatArray.add(new SeatBean(34,'F','A',true));
			seatArray.add(new SeatBean(35,'F','A',true));
			seatArray.add(new SeatBean(36,'T','A',true));			
			seatArray.add(new SeatBean(37,'T','A',true));
			seatArray.add(new SeatBean(38,'F','C',true));
			seatArray.add(new SeatBean(39,'F','A',true));			
			locationArray.add(new LocationBean(1,"Staples Center, Los Angeles",seatArray));
			eventArray.add(new EventBean(1,"Music Concert",new Date(),120,locationArray));
			
		seatArray=null;locationArray = null;		
		locationArray = new ArrayList<LocationBean>();
		seatArray = new ArrayList<SeatBean>();
			//Row 1
			seatArray.add(new SeatBean(1,'T','A',true));
			seatArray.add(new SeatBean(2,'F','C',true));
			seatArray.add(new SeatBean(3,'F','A',false));
			seatArray.add(new SeatBean(4,'F','A',false));
			seatArray.add(new SeatBean(5,'F','A',false));
			seatArray.add(new SeatBean(6,'F','A',false));
			seatArray.add(new SeatBean(7,'F','A',true));
			seatArray.add(new SeatBean(8,'F','A',true));
			seatArray.add(new SeatBean(9,'F','C',false));
			seatArray.add(new SeatBean(10,'T','A',false));	
			locationArray.add(new LocationBean(1,"Honda Center, Anaheim",seatArray));
			eventArray.add(new EventBean(2,"Live Drama",new Date(),150,locationArray));
	
			seatArray=null;locationArray = null;		
			locationArray = new ArrayList<LocationBean>();
			seatArray = new ArrayList<SeatBean>();
				//Row 1
				seatArray.add(new SeatBean(1,'T','A',true));
				seatArray.add(new SeatBean(2,'F','C',true));
				seatArray.add(new SeatBean(3,'F','A',false));
				seatArray.add(new SeatBean(4,'F','A',false));	
				//Row 2
				seatArray.add(new SeatBean(1,'T','A',false));
				seatArray.add(new SeatBean(2,'F','C',false));
				seatArray.add(new SeatBean(3,'F','A',false));
				seatArray.add(new SeatBean(4,'T','A',false));	
				//Row 3
				seatArray.add(new SeatBean(1,'T','A',false));
				seatArray.add(new SeatBean(2,'F','C',false));
				seatArray.add(new SeatBean(3,'F','A',false));
				seatArray.add(new SeatBean(4,'F','A',false));
				seatArray.add(new SeatBean(3,'F','A',false));
				seatArray.add(new SeatBean(4,'T','A',false));	
				//Row 4
				seatArray.add(new SeatBean(1,'T','A',false));
				seatArray.add(new SeatBean(2,'F','C',false));
				seatArray.add(new SeatBean(3,'F','A',true));
				seatArray.add(new SeatBean(4,'F','A',true));
				seatArray.add(new SeatBean(3,'F','A',false));
				seatArray.add(new SeatBean(4,'T','A',false));	
				//Row 5
				seatArray.add(new SeatBean(1,'T','A',true));
				seatArray.add(new SeatBean(2,'F','C',true));
				seatArray.add(new SeatBean(3,'F','A',true));
				seatArray.add(new SeatBean(4,'F','A',true));
				seatArray.add(new SeatBean(3,'F','C',true));
				seatArray.add(new SeatBean(4,'T','A',true));	
				//Row 6
				seatArray.add(new SeatBean(1,'T','A',true));
				seatArray.add(new SeatBean(2,'F','C',true));
				seatArray.add(new SeatBean(3,'F','A',false));
				seatArray.add(new SeatBean(4,'F','A',false));
				seatArray.add(new SeatBean(3,'F','A',true));
				seatArray.add(new SeatBean(4,'F','A',true));
				seatArray.add(new SeatBean(3,'F','C',true));
				seatArray.add(new SeatBean(4,'T','A',false));
				locationArray.add(new LocationBean(3,"Cinemark Theaters , Los Angeles",seatArray));
				eventArray.add(new EventBean(3,"Movie Theater",new Date(),95,locationArray));
		
			seatArray=null;locationArray = null;
		return eventArray;
	}

}
