package com.StreamAPI.app;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Transaction {
    String transactionID;
    String accountNumber;
    String transactionType;
    int amount;
    LocalDate transactionDate;
    String merchant;

    // Constructor
    Transaction(String transactionID, String accountNumber, String transactionType, int amount, LocalDate transactionDate, String merchant) {
        this.transactionID = transactionID;
        this.accountNumber = accountNumber;
        this.transactionType = transactionType;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.merchant = merchant;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionID='" + transactionID + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", transactionType='" + transactionType + '\'' +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                ", merchant='" + merchant + '\'' +
                '}';
    }

    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
                new Transaction("T001", "A123", "Credit", 5000, LocalDate.of(2025, 1, 5), "Amazon"),
                new Transaction("T002", "A123", "Debit", 2000, LocalDate.of(2025, 1, 6), "Walmart"),
                new Transaction("T003", "A123", "Debit", 7000, LocalDate.of(2025, 1, 7), "BestBuy"),
                new Transaction("T004", "B456", "Credit", 10000, LocalDate.of(2025, 1, 5), "PayPal"),
                new Transaction("T005", "A123", "Debit", 15000, LocalDate.of(2025, 1, 8), "Target"),
                new Transaction("T006", "B456", "Debit", 8000, LocalDate.of(2025, 1, 9), "eBay")
        );

        // 1. Filter transactions greater than a threshold amount
        int threshold = 7000;
        System.out.println("Transactions greater than " + threshold + ":");
        transactions.stream()
                .filter(t -> t.amount > threshold)
                .forEach(System.out::println);

        // 2. Get total debit and credit amounts for account A123
        int totalCredit = transactions.stream()
                .filter(t -> t.accountNumber.equals("A123") && t.transactionType.equalsIgnoreCase("Credit"))
                .mapToInt(t -> t.amount)
                .sum();

        int totalDebit = transactions.stream()
                .filter(t -> t.accountNumber.equals("A123") && t.transactionType.equalsIgnoreCase("Debit"))
                .mapToInt(t -> t.amount)
                .sum();

        System.out.println("Total Credit for account A123: " + totalCredit);
        System.out.println("Total Debit for account A123: " + totalDebit);

        // 3. Count transactions for a specific merchant (e.g., Amazon)
        String merchantName = "Amazon";
        long merchantTransactionCount = transactions.stream()
                .filter(t -> t.merchant.equalsIgnoreCase(merchantName))
                .count();

        System.out.println("Total transactions for merchant " + merchantName + ": " + merchantTransactionCount);

        // 4. Sort transactions by amount in descending order
        System.out.println("Transactions sorted by amount in descending order:");
        transactions.stream()
                .sorted(Comparator.comparing(t -> t.amount, Comparator.reverseOrder()))
                .forEach(System.out::println);

        // 5. Group transactions by account number
        System.out.println("Transactions grouped by account number:");
        Map<String, List<Transaction>> groupedByAccount = transactions.stream()
                .collect(Collectors.groupingBy(t -> t.accountNumber));

        groupedByAccount.forEach((account, txnList) -> {
            System.out.println("Account: " + account);
            txnList.forEach(System.out::println);
        });
    }
}
