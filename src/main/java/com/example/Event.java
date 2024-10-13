package com.example;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Event implements Printable,Comparable<Event> {

     private static Logger log = LoggerFactory.getLogger(Event.class);

    int eventid;
    String Eventname;
    String description;
    LocalDate eventDate;
    String venue;
   
//create parameterized constructor for event class
    public Event(int eventid, String eventname, String description, LocalDate eventDate, String venue) {
        this.eventid = eventid;
        Eventname = eventname;
        this.description = description;
        this.eventDate = eventDate;
        this.venue = venue;
    }
   

    

    @Override
    public String toString() {
        return "Event [eventid=" + eventid + ", Eventname=" + Eventname + ", description=" + description
                + ", eventDate=" + eventDate + ", venue=" + venue + "]";
    }




    public int getEventid() {
        return eventid;
    }


    public void setEventid(int eventid) {
        this.eventid = eventid;
    }



    public String getEventname() {
        return Eventname;
    }



    public void setEventname(String eventname) {
        Eventname = eventname;
    }



    public String getDescription() {
        return description;
    }



    public void setDescription(String description) {
        this.description = description;
    }



    public LocalDate getEventDate() {
        return eventDate;
    }



    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }



    public String getVenue() {
        return venue;
    }



    public void setVenue(String venue) {
        this.venue = venue;
    }



    public void print() {
        log.info(toString());
    }



    @Override
    public int compareTo(Event o) {
        return this.getEventDate().compareTo(o.getEventDate());
    }

}