package com.DeepDrive.app;
import java.util.Scanner;

class InvalidUsernameException extends Exception {
    public InvalidUsernameException(String message) {
        super(message);
    }
}

class InvalidPasswordException extends Exception {
    public InvalidPasswordException(String message) {
        super(message);
    }
}

public class UserValidation {
     static String storedUsername = "Valid_User1";
     static String storedPassword = "Valid@123";

    public static void validateUsername(String username) throws InvalidUsernameException {
        if (username.length() < 6 || username.length() > 30) {
            throw new InvalidUsernameException("Username must be between 6 and 30 characters.");
        }
        if (!username.matches("[a-zA-Z][a-zA-Z0-9_]*")) {
            throw new InvalidUsernameException("Username can only contain alphanumeric characters and underscores and must start with an alphabet.");
        }
    }

    public static void validatePassword(String password) throws InvalidPasswordException {
        if (password.length() < 8) {
            throw new InvalidPasswordException("Password must be at least 8 characters long.");
        }
        if (!password.matches(".*[a-z].*")) {
            throw new InvalidPasswordException("Password must contain at least one lowercase letter.");
        }
        if (!password.matches(".*[A-Z].*")) {
            throw new InvalidPasswordException("Password must contain at least one uppercase letter.");
        } 
        if (!password.matches(".*\\d.*")) {
            throw new InvalidPasswordException("Password must contain at least one digit.");
        }
        if (!password.matches(".*[!@#$%^&*()\\-+].*")) {
            throw new InvalidPasswordException("Password must contain at least one special character");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            validateUsername(username);

            System.out.print("Enter password: ");
            String password = scanner.nextLine();
            validatePassword(password);

            if (username.equals(storedUsername) && password.equals(storedPassword)) {
                System.out.println("Welcome " + username);
            } else {
                System.out.println("Invalid username or password.");
            }
        } catch (InvalidUsernameException | InvalidPasswordException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
