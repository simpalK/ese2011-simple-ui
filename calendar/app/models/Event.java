package models;

import java.util.Date;

/*  this is an Event class with event name, event start and end date, along with id 
 * a constructor method will set a new event and getter functions are there to retrive the event attributes.
 * to check event at particular day defined a function which checkes if startEventDate is < date current time to be checked 
 * and same for end Date
 * author simpal kumar
 * */
public class Event {
	public String eventName;
	public Date startEventDate;
	public Date endEventDate;
	public static long eventCount=1;
	public long id;
	
	public Event(String name,Date startDate, Date endDate){
		super();
		eventName=name;
		startEventDate=startDate;
		endEventDate=endDate;
		id=eventCount;
		eventCount++;
	}
	
	public String getName(){
		return eventName;
	}
	public Date startEveDate(){
		return startEventDate;
	}
	public Date endEveDate(){
		return endEventDate;
	}
	public long getId() {
		return id;
	}
	public boolean isAtDay(Date day){
		int factor = 1000*60*60*24;
		return (this.startEventDate.getTime()/factor <= day.getTime()/factor && day.getTime()/factor <= this.endEventDate.getTime()/factor);
	}
	
}
