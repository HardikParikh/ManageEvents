<html>
   <head>
      <title>Event Management</title>
      <script type = "text/javascript" 
         src = "https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js">
      </script>
		
      <script type = "text/javascript" >
      	var eventId;
      	var eventType;
        	$(document).ready(function() {
             $("#driver").click(function(event){
            	var url = "";
            	
            	if(document.getElementById("eventType").value == "")
            		url += "eventId=0";
            	else
            		url += "eventId="+document.getElementById("eventId").value;
            	if(document.getElementById("eventType").value != 0){
            		document.getElementById("eventId").value = "";
            	 	url += "&type="+document.getElementById("eventType").value;
            	}
           	 	if(document.getElementById("eventAisle").value != 2){
            		document.getElementById("eventId").value = "";
           	 		url += "&isAisle="+document.getElementById("eventAisle").value;
             	}
                $('#stage').load('http://localhost:8080/ManageEvents/rest/event?'+url);
             });
          });
      </script>
   </head>
	
   <body>
   	  Event Id:<input type="text" id="eventId" />
   	  <br /><br /> OR <br /><br /> 
   	  Seat Type:<select id="eventType">
		  <option value="0">Select</option>
		  <option value="C">Child</option>
		  <option value="A">Adult</option>
		</select>
	  Aisle Option:<select id="eventAisle">
		  <option value="2">Select</option>
		  <option value="1">Aisle</option>
		  <option value="0">No Aisle</option>
		</select>
	  <br /><br />
      <input type = "button" id="driver" value = "Load Data" />
      <br /> <br />
      <div id = "stage"></div>
   </body>
</html>