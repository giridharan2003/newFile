package com.DeepDrive.app;
import java.util.Scanner;
class MyCalculator {

    public long power(int n, int p) throws Exception {
        if (n < 0 || p < 0) {
            throw new Exception("n or p should not be negative.");
        } else if (n == 0 && p == 0) {
            throw new Exception("n and p should not be zero.");
        }

        return (long) Math.pow(n, p);
    }

    public static void main(String[] args) {
        MyCalculator calculator = new MyCalculator();
        Scanner sc=new Scanner(System.in);

        
            try {
            	System.out.println("Enter the value of n");
                int n = sc.nextInt();
                System.out.println("Enter the value of p");
                int p = sc.nextInt();
                long result = calculator.power(n, p);
                System.out.println(result);
            } catch (Exception e) {
                System.out.println(e);
            }
        sc.close();
    }
}
