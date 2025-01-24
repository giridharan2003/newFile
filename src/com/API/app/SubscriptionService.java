package com.API.app;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class SubscriptionService {
	 private static LocalDate calculateExpiryDate(LocalDate startDate, String durationInput) {
        //take the duration unit and value
        char unit = durationInput.charAt(durationInput.length() - 1);
        int value = Integer.parseInt(durationInput.substring(0, durationInput.length() - 1));
        //add the duration to the start date
        switch (unit) {
            case 'D': // Days
                return startDate.plusDays(value);
            case 'M': // Months
                return startDate.plusMonths(value);
            case 'Y': // Years
                return startDate.plusYears(value);
            default:
                throw new IllegalArgumentException("Invalid duration unit. Use D, M, or Y.");
                }
       }
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        // Input: Start date & subscription
	        System.out.print("Enter the subscription start date (yyyy-MM-dd): ");
	        String startDateInput = sc.nextLine();
	        System.out.print("Enter the plan duration (e.g., 30D for 30 days, 6M for 6 months, 1Y for 1 year): ");
	        String durationInput = sc.nextLine();

	        try {
	            LocalDate startDate = LocalDate.parse(startDateInput, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	            LocalDate expiryDate = calculateExpiryDate(startDate, durationInput);
	            System.out.println("Subscription Start Date: " + startDate);
	            System.out.println("Subscription Expiry Date: " + expiryDate);
	            System.out.println("Total Subscription Period: " +
	                    ChronoUnit.DAYS.between(startDate, expiryDate) + " days");

	        } catch (Exception e) {
	            System.out.println("Invalid input. Please ensure the date and duration format is correct.");
	        }
	        sc.close();
	    }
}
