import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ListIterator;
import java.util.Locale;

import models.*;

import org.junit.Before;
import org.junit.Test;


public class MyCalendarTest {

	private User userOne, userTwo;
	private Calendar calOne, calTwo;
	private ArrayList<Event> events;
	private ListIterator<Event> itr;
	private DateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm");


	@Before
	public void setUp() throws ParseException{

		userOne = new User("simpal.kumar@gmail.com","secret");
		userTwo = new User("cherie.kumar@gmail.com","topsecret");

		calOne = new Calendar("CalOne", userOne);
		calTwo = new Calendar("CalTwo", userTwo);
		events = new ArrayList<Event>();
		calOne.addEvent("lecture", df.parse("17.10.2011 10:00"), df.parse("17.10.2011 13:00"));
		calOne.addEvent("seminar", df.parse("18.10.2011 13:00"), df.parse("18.10.2011 15:00"));
		calTwo.addEvent("lecture", df.parse("19.10.2011 10:00"), df.parse("18.10.2011 13:00"));
		calTwo.addEvent("lecture", df.parse("19.10.2011 13:00"), df.parse("19.10.2011 15:00"));
		
	}


	@Test
	public void testUser(){
		assertEquals(userOne.getUserName(), "simpal.kumar@gmail.com");
		assertEquals(userTwo.getUserName(), "cherie.kumar@gmail.com");
	}

	@Test
	public void testCalendar(){
		assertEquals(calOne.getCalName(), "CalOne");
		assertEquals(calTwo.getCalName(), "CalTwo");
		assertEquals(calOne.calOwner(), userOne);
		assertEquals(calTwo.calOwner(), userTwo);
		assertEquals(2, calOne.calEvents.size());
		assertEquals(2, calTwo.calEvents.size());
		
	}	


	@Test
	public void testEvent() throws ParseException{
		Event event1= new Event("lecture", df.parse("17.10.2011 10:00"), df.parse("17.10.2011 13:00"));
		assertEquals(1,calOne.eventsOnDay(userOne,df.parse("17.10.2011 10:00")).size());
	}

	@Test
	public void testEventsAfterDay() throws ParseException {
		ArrayList<Event> events= new ArrayList<Event>();
		events.add(new Event("seminar", df.parse("18.10.2011 13:00"), df.parse("18.10.2011 15:00")));
		Date day=df.parse("17.10.2011 10:00");
		assertEquals(1,calOne.myEventsAfterDay(userOne, day).size());
	}
	@Test
	public void testEventsBeforeDay() throws ParseException {
		ArrayList<Event> events= new ArrayList<Event>();
		events.add(new Event("lecture", df.parse("17.10.2011 10:00"), df.parse("17.10.2011 15:00")));
		Date day=df.parse("18.10.2011 10:00");
		assertEquals(1,calOne.myEventsBeforeDay(userOne, day).size());
	}
	
}


