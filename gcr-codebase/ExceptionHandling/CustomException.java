package ExceptionHandling;
import java.util.*;
class InvalidAgeException extends Exception{
	
	public InvalidAgeException(String message) {
		super(message);
	}
}

public class CustomException {
	public static void validateAge(int age) throws InvalidAgeException{
		if(age<18) {
			throw new InvalidAgeException("Age must be above 18");
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("Enter age: ");
			int age = sc.nextInt();
			validateAge(age);
			System.out.println("Access granted");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
