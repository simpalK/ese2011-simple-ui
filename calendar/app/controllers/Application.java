package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;
import models.Calendar;

@With(Secure.class)
public class Application extends Controller {
	
    public static void index() {
    	List<User> users = Database.getUsers();
        render(users);
    }
    public static void showCalendars(String username){
    	User user = Database.getUserByName(username);
    	List<Calendar> calendars = user.getUserCalendars();
    	render(user, calendars);
    }
    
    public static void showEvents(String username, String calendarname, String message){
    	User user = Database.getUserByName(username);
    	List<Event> events=new LinkedList<Event>();
    	List<Calendar> calendar = user.getUserCalendars();
    	for(Calendar ea:calendar) {
    	events = ea.myEventsAfterDay(Database.getUserByName(username), new Date());
    	}
    	render(user, calendar, events, message);
    }
    

}