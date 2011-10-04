package models;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Calendar {
	 public String calName; 
     public User ownerCalendar;
     public List<Event> calEvents;
     public Calendar(String name,User username){
    	 calName=name;
    	 ownerCalendar = username;
    	 calEvents = new LinkedList<Event>();
     }
     public String getCalName(){
    	 return calName;
     }
     public User calOwner(){
    	 return ownerCalendar;
     }
     public void addEvent(String eveName, Date eveStartDate, Date eveEndDate){
    	 calEvents.add(new Event(eveName,eveStartDate,eveEndDate));
     }
     public List<Event> eventsOnDay(User userCal, Date day){
    	 List<Event> todayEvent = new LinkedList<Event>();
 		for(Event event: calEvents){
 			if(event.isAtDay(day))
 				todayEvent.add(event);
 		}
 		return todayEvent;
     }
     public List<Event> eventsOnDay(){
 		return calEvents;
     }
     public List<Event> myEventsOnDay(User userCal, Date day){
    	 List<Event> todayEvent = new LinkedList<Event>();
 		for(Event event: calEvents){
 			if(event.isAtDay(day)&& userCal.equals(ownerCalendar))
 				todayEvent.add(event);
 		}
 		return todayEvent;
     }
     public List<Event> myEventsAfterDay(User userCal, Date day){
    	 List<Event> todayEvent = new LinkedList<Event>();
 		for(Event event: calEvents){
 			if(event.startEventDate.after(day) && userCal.equals(ownerCalendar))
 				todayEvent.add(event);
 		}
 		return todayEvent;
     }
     public List<Event> allEventsAfterDay(Date day){
    	 List<Event> todayEvent = new LinkedList<Event>();
 		for(Event event: calEvents){
 			if(event.startEventDate.after(day))
 				todayEvent.add(event);
 		}
 		return todayEvent;
     }
     public List<Event> myEventsBeforeDay(User userCal, Date day){
    	 List<Event> todayEvent = new LinkedList<Event>();
 		for(Event event: calEvents){
 			if(event.startEventDate.before(day) && userCal.equals(ownerCalendar))
 				todayEvent.add(event);
 		}
 		return todayEvent;
     }
     public List<Event> allEventsBeforeDay(Date day){
    	 List<Event> todayEvent = new LinkedList<Event>();
 		for(Event event: calEvents){
 			if(event.startEventDate.before(day))
 				todayEvent.add(event);
 		}
 		return todayEvent;
     }
     public long totalEvents(){
    	 return calEvents.size();
     }
}
