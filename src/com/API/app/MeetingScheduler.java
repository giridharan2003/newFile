package com.API.app;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MeetingScheduler {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: Meeting date and time & timezone
        System.out.print("Enter the meeting date and time (yyyy-MM-dd HH:mm): ");
        String meetingDateTime = sc.nextLine();
        System.out.print("Enter the time zone of the meeting (e.g., Asia/Calcutta): ");
        String meetingTimeZone = sc.nextLine();

        ZonedDateTime originalMeetingTime = LocalDateTime
                .parse(meetingDateTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))
                .atZone(ZoneId.of(meetingTimeZone));

        // Display original meeting time
        System.out.println("\nOriginal Meeting Time:");
        System.out.println("In " + meetingTimeZone + ": " + originalMeetingTime);

        // Convert and display meeting times in other time zones
        System.out.println("\nMeeting Times in Other Time Zones:");
        displayMeetingTimeInZone(originalMeetingTime, "Europe/London");
        displayMeetingTimeInZone(originalMeetingTime, "Asia/Tokyo");
        displayMeetingTimeInZone(originalMeetingTime, "Australia/Sydney");
        displayMeetingTimeInZone(originalMeetingTime, "America/Los_Angeles");
        displayMeetingTimeInZone(originalMeetingTime, "UTC");

        sc.close();
    }

    private static void displayMeetingTimeInZone(ZonedDateTime originalTime, String targetZone) {
        ZonedDateTime convertedTime = originalTime.withZoneSameInstant(ZoneId.of(targetZone));
        System.out.println("In " + targetZone + ": " + convertedTime);
    }
}
