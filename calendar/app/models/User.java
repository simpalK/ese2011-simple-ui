package models;

import java.util.LinkedList;
import java.util.List;

public class User {
    public String userName;
    public String password;
    public List<Calendar> userCalendars;
    public User(String name, String pwd){
    	userName=name;
    	password=pwd;
    	userCalendars = new LinkedList<Calendar>();
    }
    public boolean equals(User calUser){
    	return (calUser.userName.equals(this.userName));
    }
    public void addCalendar(String calName){
    	userCalendars.add(new Calendar(calName,this));
    }
    public Calendar getCalendarByName(String name){
		for(Calendar calendar: userCalendars)
			if(calendar.getCalName().equals(name))
				return calendar;
		return null;
	}

    public String getUserName() {
		return userName;
	}
	public void setUserName(String name) {
		this.userName = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String pwd) {
		this.password = pwd;
	}
	public List<Calendar> getUserCalendars() {
		return userCalendars;
	}
}
