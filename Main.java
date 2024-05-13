package com.comparator_interface;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

//Comparator implementation to sort students by ID in ascending order
class Demo1 implements Comparator<Student>{
	@Override
	public int compare(Student s1, Student s2) {
		Integer i1 = s1.getId();
		Integer i2 = s2.getId();
		
		// Compare IDs for sorting in ascending order
		return i1.compareTo(i2);
	}
}

//Comparator implementation to sort students by ID in descending order
class Demo2 implements Comparator<Student>{
	@Override
	public int compare(Student s1, Student s2) {
		Integer i1 = s1.getId();
		Integer i2 = s2.getId();
		
		// Compare IDs for sorting in descending order
		return -1 * (i1.compareTo(i2));
	}
}

//Comparator implementation to sort students by name
class Demo3 implements Comparator<Student>{
	@Override
	public int compare(Student s1, Student s2) {
		String i1 = s1.getName();
		String i2 = s2.getName();
		
        // Compare names for sorting alphabetically
		return i1.compareTo(i2);
	}
}

//Comparator implementation to sort students by height
class Demo4 implements Comparator<Student>{
	@Override
	public int compare(Student s1, Student s2) {
		Float i1 = s1.getHeight();
		Float i2 = s2.getHeight();
		
		// Compare heights for sorting in ascending order
		return i1.compareTo(i2);
	}
}

//Comparator implementation to sort students by address
class Demo5 implements Comparator<Student>{
	@Override
	public int compare(Student s1, Student s2) {
		String i1 = s1.getAddress();
		String i2 = s2.getAddress();
		
		// Compare addresses for sorting alphabetically
		return i1.compareTo(i2);
	}
}

//Student class with attributes id, name, height, and address
class Student{
	int id;
	String name;
	float height;
	String address;
	
	// Constructors, getters, setters, and toString method
	public Student() {
		
	}
	public Student(int id, String name, float height, String address) {
		super();
		this.id = id;
		this.name = name;
		this.height = height;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id + " " + name + " " + height + " " + address;
	}
}

public class Main {

	public static void main(String[] args) {
		
		// Create Scanner object for user input
		Scanner scan = new Scanner(System.in);
		
		// Create Comparator instances for different sorting options
		Demo1 d1 = new Demo1(); // ID (Low to High)
		Demo2 d2 = new Demo2(); // ID (High to Low)
		Demo3 d3 = new Demo3(); // Name
		Demo4 d4 = new Demo4(); // Height
		Demo5 d5 = new Demo5(); // Address
		
		// Initialize TreeSet to store sorted objects
		TreeSet<Student> set = null;
		
		 // Prompt user to select sorting option
		System.out.println("Select the option on which you want the objects to be sorted: \n "
				+ "1.Id(Low to High) \n 2.Id(High to Low) \n 3.Name \n 4.Heigth \n 5.Address");
		
		// Read user's sorting option
		int option = scan.nextInt();
		
		// Based on user's selection, create appropriate TreeSet with Comparator
		 switch (option) {
         case 1: set = new TreeSet<Student>(d1); // Sort by ID (Low to High)
                 break;
         case 2: set = new TreeSet<Student>(d2); // Sort by ID (High to Low)
                 break;
         case 3: set = new TreeSet<Student>(d3); // Sort by Name
                 break;
         case 4: set = new TreeSet<Student>(d4); // Sort by Height
                 break;
         case 5: set = new TreeSet<Student>(d5); // Sort by Address
                 break;
		 }
		
        // Prompt user to enter number of objects to create
		System.out.println("Enter the number of objects you want to create:");
		int n = scan.nextInt();
		
		// Prompt user to enter data for each object and add it to the TreeSet
		System.out.println("Enter the data for the objects:");
		  for (int i=0 ; i<n ; i++) {
			  Student s = new Student();
			  String str = scan.next();
			  String[] arr = str.split(",");
			  s.setId(Integer.parseInt(arr[0]));
			  s.setName(arr[1]);
			  s.setHeight(Float.parseFloat(arr[2]));
			  s.setAddress(arr[3]);
			  set.add(s);
		  }
		  System.out.println();
		  
		// Display sorted objects
		  System.out.println("Objects after sorting based on the option you selected:");
		  
		  for (Student s : set) {
			  System.out.println(s);
		  }
		  // Close Scanner object
		  scan.close();
	}
}






