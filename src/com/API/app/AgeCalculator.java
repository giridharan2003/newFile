package com.API.app;
import java.util.Scanner;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class AgeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the date of birth (yyyy-MM-dd): ");
        String dobInput = sc.nextLine();
        try {
            LocalDate birthDate = LocalDate.parse(dobInput, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            LocalDate currentDate = LocalDate.now();
            //validate the date of birth
            if (birthDate.isAfter(currentDate)) {
                System.out.println("Date of birth cannot be in the future.");
                return;
            }
            //calculate the age
            Period age = Period.between(birthDate, currentDate);
            System.out.println("Exact Age:");
            System.out.printf("%d years, %d months, and %d days\n",
                    age.getYears(), age.getMonths(), age.getDays());

        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please enter the date in yyyy-MM-dd format.");
        }
        sc.close();
        }
    }
