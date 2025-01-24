package com.DeepDrive.app;

import java.util.InputMismatchException;
import java.util.Scanner;

class Invoice {
    private int partNumber;
    private String partDescription;
    private int quantity;
    private double pricePerItem;

    public Invoice(int partNumber, String partDescription, int quantity, double pricePerItem) {
        this.partNumber = partNumber;
        this.partDescription = partDescription;
        this.quantity = quantity;
        this.pricePerItem = pricePerItem;
    }

    public int getPartNumber() {
        return partNumber;
    }

    public String getPartDescription() {
        return partDescription;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPricePerItem() {
        return pricePerItem;
    }

    public void displayInvoice() {
        System.out.println("Invoice Details:");
        System.out.println("Part Number: " + partNumber);
        System.out.println("Part Description: " + partDescription);
        System.out.println("Quantity: " + quantity);
        System.out.println("Price Per Item: " + pricePerItem);
        System.out.println("Total Price: " + (quantity * pricePerItem));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter Part Number: ");
            int partNumber = sc.nextInt();
            if (partNumber <= 0) {
                throw new IllegalArgumentException("Part number must be greater than 0.");
            }
            sc.nextLine(); 
            System.out.print("Enter Part Description: ");
            String partDescription = sc.nextLine();
            if (partDescription == null || partDescription.trim().isEmpty()) {
                throw new IllegalArgumentException("Part description cannot be null or empty.");
            }
            System.out.print("Enter Quantity: ");
            int quantity = sc.nextInt();
            if (quantity <= 0) {
                throw new IllegalArgumentException("Quantity must be greater than 0.");
            }
            System.out.print("Enter Price Per Item: ");
            double pricePerItem = sc.nextDouble();
            if (pricePerItem <= 0) {
                throw new IllegalArgumentException("Price per item must be greater than 0.");
            }
            Invoice invoice = new Invoice(partNumber, partDescription, quantity, pricePerItem);
            invoice.displayInvoice();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter the correct type of data.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            sc.close();
        }
    }
}
