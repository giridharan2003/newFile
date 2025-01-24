package com.UserRegisterationAndValidationSystem.app;
import java.util.Scanner;
import com.UserRegisterationAndValidationSystem.app.CustomerException.*;
public class Main {
	public static void main(String[] args) {
		UserManagementSystem ums=new UserManagementSystem();
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("\n1.Register\n2.Login\n3.Exit");
			System.out.println("Choose an option: ");
			int choice =sc.nextInt();
			sc.nextLine();
			try {
				if(choice == 1) {
					System.out.println("Name: ");
					String name=sc.nextLine();
					System.out.println("Email: ");
					String email=sc.nextLine();
					System.out.println("Password: ");
					String password=sc.nextLine();
					System.out.println("Phone Number: ");
					String phoneNumber=sc.nextLine();
					System.out.println("Address");
					String address=sc.nextLine();
					System.out.println("date of birth: ");
					String dob=sc.nextLine();
					System.out.println("Gender: ");
					String gender=sc.nextLine();
					ums.registerUser(name, email, password, phoneNumber, address, dob, gender);
				}else if(choice==2) {
					System.out.println("Email: ");
					String email=sc.nextLine();
					System.out.println("Password: ");
					String password=sc.nextLine();
					ums.validateUser(email, password);
				}else if(choice==3) {
					System.out.println("Exiting...........");
					break;
				}else {
					System.out.println("Invalid Option");
				}
			}catch(Exception e) {
				System.err.println("Error: "+e.getMessage());
			}
		}
		sc.close();
	}
}
