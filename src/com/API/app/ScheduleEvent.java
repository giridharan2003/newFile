package com.API.app;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

class ScheduleEvent {
    private static class Event {
        String name;
        ZonedDateTime startTime;
        Period recurrencePeriod;
        //event class constructor
        Event(String name, ZonedDateTime startTime, Period recurrencePeriod) {
            this.name = name;
            this.startTime = startTime;
            this.recurrencePeriod = recurrencePeriod;
        }
        public String toString() {
            return String.format(
                "Event(name=\"%s\", startTime=%s, recurrencePeriod=%s)",
                name,
                startTime,
                recurrencePeriod
            ); 
        }
    }
    private final List<Event> events = new ArrayList<>();

    public void addEvent(String name, String startTime, String timeZone, Period recurrencePeriod) {
        ZonedDateTime zonedDateTime = LocalDateTime
            .parse(startTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))
            .atZone(ZoneId.of(timeZone));
        events.add(new Event(name, zonedDateTime, recurrencePeriod));
    }
    //display all event
    public void listAllEvents() {
        System.out.println("All Events:");
        for (Event event : events) {
            System.out.println(event);
        }
    }
    //details about upcoming event
    public void notifyUpcomingEvents(String userTimeZone) {
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of(userTimeZone));
        System.out.println("Notifications for upcoming events:");
        for (Event event : events) {
            Duration duration = Duration.between(now, event.startTime);
            if (!duration.isNegative() && duration.toHours() <= 24) {
                System.out.printf(
                    "Event: %s is scheduled at %s (%s hours from now)\n",
                    event.name,
                    event.startTime,
                    duration.toHours()
                );
            }
        }
    }

//    public static void main(String[] args) {
//        ScheduleEvent scheduler = new ScheduleEvent();
//
//        scheduler.addEvent("Team Meeting", "2025-01-03 10:00", "America/New_York", Period.ofDays(7));
//        scheduler.addEvent("Code Review", "2025-01-04 14:00", "Europe/London", Period.ofMonths(1));
//        scheduler.addEvent("Project Deadline", "2025-01-02 23:59", "Asia/Kolkata", Period.ofDays(0));
//
////        scheduler.listAllEvents();
////        System.out.println();
//
////        scheduler.notifyUpcomingEvents("America/New_York");
//    }
}