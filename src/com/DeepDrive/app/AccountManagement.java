package com.DeepDrive.app;
import java.util.Scanner;
class PayOutOfBoundsException extends Exception {
    public PayOutOfBoundsException(String message) {
        super(message);
    }
}

class AccountManagement {
    private double currentBalance = 80000;
    private static final double MAX_TRANSACTION_LIMIT = 30000;

    public void checkForDebit(double amount) throws PayOutOfBoundsException {
        if (amount > MAX_TRANSACTION_LIMIT) {
            throw new PayOutOfBoundsException("Transaction amount exceeds the maximum limit of " + MAX_TRANSACTION_LIMIT);
        }
        if (amount > currentBalance) {
            throw new PayOutOfBoundsException("Insufficient funds. Current balance: " + currentBalance);
        }
    }

    public void withdrawAmount(double amount) {
        try {
            checkForDebit(amount);
            currentBalance -= amount;
            System.out.println("Transaction successful. Amount withdrawn: " + amount);
            System.out.println("Remaining balance: " + currentBalance);
        } catch (PayOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
    	Scanner sc=new Scanner(System.in);
        AccountManagement account = new AccountManagement();

        // Test cases
        System.out.println("Attempting to withdraw .");
        int amount =sc.nextInt();
        account.withdrawAmount(amount);
        sc.close();
    }
}

