package com.exceptionHandling;

import java.util.Scanner;

class UnderAgeException extends Exception{
	
}

class OverAgeException extends Exception{
	
}

class DrivingLiscence{
	int startingAge = 18;
	int tillAge = 65;
	int age;
	
	void acceptInput() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the Age");
		age = scan.nextInt();
		scan.close();
	}
	
	void verify() throws Exception {
		if(age >= startingAge && age <= tillAge) {
			System.out.println("Driving Liscence Permitted");
		}
		else if(age < startingAge  ) {
			System.out.println("Too Young for Driving Liscence");
			UnderAgeException ua = new UnderAgeException();
			throw ua;
			
		}
		else if(age > tillAge) {
			System.out.println("Too old for Driving Liscence");
			OverAgeException oa = new OverAgeException();
			throw oa;
		}
	}
}

class DrivingSchool{
	void permit() {
		DrivingLiscence dl = new DrivingLiscence();
		try {
			dl.acceptInput();
			dl.verify();
			
		}
		catch(Exception e){
			try {
				dl.acceptInput();
				dl.verify();
				
			}
			catch(Exception f) {
				try {
					dl.acceptInput();
					dl.verify();
					
				}
				catch(UnderAgeException g) {
					System.out.println("You are too young");
				}
				catch(OverAgeException h) {
					System.out.println("Take a chill");
				} 
				catch (Exception e1) {
					System.out.println("aaram se");
				}
			}
		}
	}
}

public class ExceptionHandling {
	public static void main(String[] args) {
		DrivingSchool ds = new DrivingSchool();
		ds.permit();
	}
}


 