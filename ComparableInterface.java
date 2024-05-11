package com.comparable_interface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// Student class implementing the Comparable interface
class Student implements Comparable<Student> {
    private int id;
    private String name;
    private String address;
    private float height;
    
    // Default constructor
    public Student() {
    }

    // Parameterized constructor to initialize student attributes
    public Student(int id, String name, String address, float height) {
        super();
        this.id = id;
        this.name = name;
        this.address = address;
        this.height = height;
    }

    // Getter and setter methods for student attributes
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    // Override toString method to print student information
    @Override
    public String toString() {
        return "id" + " = " + id + " " + name + " " + " " + address + " " + height;
    }
    
    // Implement compareTo method to compare students based on their ids
    @Override
    public int compareTo(Student s2) {
        // Compare the ids of two students
        Student s1 = this;
        Integer i1 = s1.id;
        Integer i2 = s2.id;
        if (i1 > i2) {
            return 1;
        } else if (i1 < i2) {
            return -1;
        } else {
            return 0;
        }  
    }
}

// Main class to test the Student class
public class Main {
    public static void main(String[] args) {
        // Create an ArrayList to store Student objects
        ArrayList<Student> al = new ArrayList<Student>();
        Scanner scan = new Scanner(System.in);
        
        // Prompt user to enter the number of student objects to create
        System.out.println("Enter the Number of Objects you want to create:");
        int n = scan.nextInt();
        
        // Iterate to get input for each student
        for (int i = 1; i <= n; i++) {
            Student s = new Student();
            System.out.println("Enter the information for Student: " + i);
            String str = scan.next();
            String[] arr = str.split(",");
            s.setId(Integer.parseInt(arr[0]));
            s.setName(arr[1]);
            s.setAddress(arr[2]);
            s.setHeight(Float.parseFloat(arr[3]));
            al.add(s); // Add student object to ArrayList
        }
        
        // Sort the ArrayList of Student objects based on id
        Collections.sort(al);
        
        // Display sorted student information
        System.out.println("Based on id the sorted information is: ");
        for (Student stu : al) {
            System.out.println(stu);
        }
        
        // Close Scanner object
        scan.close();
    }
}
