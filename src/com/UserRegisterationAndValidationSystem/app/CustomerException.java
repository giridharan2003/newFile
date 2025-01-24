package com.UserRegisterationAndValidationSystem.app;
public class CustomerException {
	public static class RegisteredUserException extends Exception{
		public RegisteredUserException(String message) {
			super(message);
		}
	}
	public static class WeakPasswordException extends Exception{
		public WeakPasswordException(String message) {
			super(message);
		}
	}
	public static class InvalidEmailFormatException extends Exception{
		public InvalidEmailFormatException(String message) {
			super(message);
		}
	}
	public static class UserNotFoundException extends Exception{
		public UserNotFoundException(String message) {
			super(message);
		}
	}
	public static class IncorrectPasswordException extends Exception{
		public IncorrectPasswordException(String message) {
			super(message);
		}
	}
}


