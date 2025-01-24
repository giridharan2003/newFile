package com.API.app;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DeliveryDateValidator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the start date for delivery (yyyy-MM-dd): ");
        String startDateInput = sc.nextLine();
        System.out.print("Enter the end date for delivery (yyyy-MM-dd): ");
        String endDateInput = sc.nextLine();
        System.out.print("Enter your desired delivery date (yyyy-MM-dd): ");
        String selectedDateInput = sc.nextLine();
        try {
            //parse dates
            LocalDate startDate = LocalDate.parse(startDateInput, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            LocalDate endDate = LocalDate.parse(endDateInput, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            LocalDate selectedDate = LocalDate.parse(selectedDateInput, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            //validate range
            if (selectedDate.isBefore(startDate) || selectedDate.isAfter(endDate)) {
                System.out.println("Selected date is out of the delivery range.");
                return;
            }
            Set<LocalDate> holidays = getHolidays();
            //check if the date is a weekend or holiday
            if (isWeekend(selectedDate)) {
                System.out.println("Selected date falls on a weekend. Please select a weekday.");
            } else if (holidays.contains(selectedDate)) {
                System.out.println("Selected date is a holiday. Please choose another date.");
            } else {
                System.out.println("Your delivery date is valid: " + selectedDate);
            }

        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please enter the date in yyyy-MM-dd format.");
        }
        sc.close();
    }
    private static Set<LocalDate> getHolidays() {
        Set<LocalDate> holidays = new HashSet<>();
        holidays.add(LocalDate.of(2025, 1, 1)); // New Year
        holidays.add(LocalDate.of(2025, 1, 26)); // Republic Day (India)
        holidays.add(LocalDate.of(2025, 12, 25)); // Christmas
        // Add more holidays as needed
        return holidays;
    }

    private static boolean isWeekend(LocalDate date) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY;
        }
    }
