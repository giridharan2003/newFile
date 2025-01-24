package com.API.app;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class DateValidator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a date in any of the following formats:");
        System.out.println("yyyy-MM-dd, dd/MM/yyyy, MM-dd-yyyy, yyyy.MM.dd");
        System.out.print("Date: ");
        String inputDate = sc.nextLine();
        //possible date formats
        DateTimeFormatter[] formatters = {
            DateTimeFormatter.ofPattern("yyyy-MM-dd"),
            DateTimeFormatter.ofPattern("dd/MM/yyyy"),
            DateTimeFormatter.ofPattern("MM-dd-yyyy"),
            DateTimeFormatter.ofPattern("yyyy.MM.dd")
        };
        //parse the input using the defined formats
        LocalDate parsedDate = null;
        for (DateTimeFormatter formatter : formatters) {
            try {
                parsedDate = LocalDate.parse(inputDate, formatter);
                break; //exit loop if parsing is successful
            } catch (DateTimeParseException e) {
                //continue to the next format
            }
        }
        //output the result
        if (parsedDate != null) {
            String standardizedDate = parsedDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            System.out.println("Valid date. Standardized format: " + standardizedDate);
        } else {
            System.out.println("Invalid date format. Please try again.");
        }
        sc.close();
    }
}

