package studentmanagementapp.exception;

import java.util.Scanner;

public class StudentNotFoundException extends Exception{
	public StudentNotFoundException() {}
	public StudentNotFoundException(String message){
		super(message);
	}
}
