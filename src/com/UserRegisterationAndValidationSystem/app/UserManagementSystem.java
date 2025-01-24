package com.UserRegisterationAndValidationSystem.app;
import com.UserRegisterationAndValidationSystem.app.CustomerException.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
public class UserManagementSystem {
	private static final String FILE_PATH ="user.dat";
	private List<User>users;
	public UserManagementSystem() {
		users=readUsersFromFile();
	}
	// Register new user
	public void registerUser(String name, String email,
			String password, String phoneNumber, String address,
			String dob, String gender) 
		throws RegisteredUserException, WeakPasswordException, InvalidEmailFormatException{
			if(!isValidEmail(email)) {
				throw new InvalidEmailFormatException("Invalid email format!");
			}
			if(!isStrongPassword(password)) {
				throw new WeakPasswordException("Password must be at least 8 characters, include uppercase, lowercase, digit , special character.");
			}
			for(User user : users) {
				if(user.getEmail().equals(email)) {
					throw new RegisteredUserException("This user is already exists");
				}
			}
			User newUser = new User(name,email, password, phoneNumber, address, dob, gender);
			users.add(newUser);
			writeUserToFile();
			System.out.println("Registred successfully");
		}
	
	public void validateUser(String email, String password) 
		throws UserNotFoundException,IncorrectPasswordException {
			for(User user:users) {
				if(user.getEmail().equals(email)) {
					if(user.getPassword().equals(password)) {
						System.out.println("Login successfully! welcome, "+user.toString());
						return;
					}else {
						throw new IncorrectPasswordException("Incorrect Password");
					}
				}
			}
			throw new UserNotFoundException("User not found");
		}
		private boolean isValidEmail(String email) {
			String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
			return Pattern.matches(emailRegex, email);
		}
		private boolean isStrongPassword(String password) {
			String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=]).{8,}$";
			return Pattern.matches(passwordRegex, password);
		}
		private List<User> readUsersFromFile(){
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))){
				return(List<User>)ois.readObject();
			}catch (IOException | ClassNotFoundException e) {
				return new ArrayList<>();
			}
		}
		private void writeUserToFile() {
			try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))){
				oos.writeObject(users);
			}catch(IOException e)
			{
		System.err.println("Error writing users to file: "+e.getMessage());
			}
		}
}
