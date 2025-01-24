package com.DeepDrive.app;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

class InvalidEmpNumberException extends Exception {
    public InvalidEmpNumberException(String message) {
        super(message);
    }
}

class InvalidDateOfJoinException extends Exception {
    public InvalidDateOfJoinException(String message) {
        super(message);
    }
}

class Employee {
    private int empCode;
    private String name;
    private LocalDate dateOfBirth;
    private LocalDate dateOfAppointment;

    public Employee(int empCode, String name, LocalDate dateOfBirth, LocalDate dateOfAppointment) {
        this.empCode = empCode;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.dateOfAppointment = dateOfAppointment;
    }

    public void displayDetails() {
        System.out.println("Employee Details:");
        System.out.println("Code: " + empCode);
        System.out.println("Name: " + name);
        System.out.println("Date of Birth: " + dateOfBirth);
        System.out.println("Date of Appointment: " + dateOfAppointment);
        System.out.println("Years of Experience: " + calculateExperience());
    }

    private int calculateExperience() {
        return Period.between(dateOfAppointment, LocalDate.now()).getYears();
    }
}

public class EmployeeValidation {

    public static void validateEmpCode(int empCode) throws InvalidEmpNumberException {
        if (empCode <= 0) {
            throw new InvalidEmpNumberException("Employee code must be a positive integer.");
        }
    }

    public static void validateDates(LocalDate dateOfBirth, LocalDate dateOfAppointment) throws InvalidDateOfJoinException {
        if (!dateOfBirth.isBefore(dateOfAppointment)) {
            throw new InvalidDateOfJoinException("Date of Birth must be before the Date of Appointment.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try {
            System.out.print("Enter Employee Code: ");
            int empCode = sc.nextInt();
            sc.nextLine(); 
            validateEmpCode(empCode);
            System.out.print("Enter Employee Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Date of Birth (yyyy-MM-dd): ");
            LocalDate dateOfBirth = LocalDate.parse(sc.nextLine(), formatter);
            System.out.print("Enter Date of Appointment (yyyy-MM-dd): ");
            LocalDate dateOfAppointment = LocalDate.parse(sc.nextLine(), formatter);
            validateDates(dateOfBirth, dateOfAppointment);
            Employee employee = new Employee(empCode, name, dateOfBirth, dateOfAppointment);
            employee.displayDetails();
        } catch (InvalidEmpNumberException | InvalidDateOfJoinException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}

