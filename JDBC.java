package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String url = "jdbc:mysql://localhost:3306/class"; // URL to connect to the MySQL database
        String user = "root"; // Database username
        String password = "root"; // Database password
        Connection connection = null; // Connection object
        Statement statement1 = null; // Statement object for executing simple SQL queries
        PreparedStatement statement2 = null; // PreparedStatement object for executing parameterized SQL queries
        ResultSet resultset = null; // ResultSet object to hold the results of a query
        String query1 = "SELECT * FROM `section_a`"; // SQL query to retrieve all records from section_a table
        String query2 = "INSERT INTO section_a (s_id , s_name , gender , marks , dob) VALUES (?,?,?,?,?)"; // SQL query to 
        																		//insert a new record into section_a table

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load and register the JDBC driver
            System.out.println("Driver is loaded\n");
            connection = DriverManager.getConnection(url, user, password); // Establish a connection to the database
            statement1 = connection.createStatement(); // Create a statement object

            System.out.println("The fetched data from the database :");
            print(resultset, statement1, query1); // Fetch and print the initial data from the database
            System.out.println();

            String str;
            statement2 = connection.prepareStatement(query2); // Prepare the SQL insert statement
            do {
                System.out.println("Do you want to insert the data ?");
                str = scan.nextLine().trim();
                if (str.equalsIgnoreCase("YES")) {
                    // Prompt user for data to insert
                    System.out.println("Enter the ID:");
                    int id = scan.nextInt();
                    System.out.println("Enter the S_NAME:");
                    String name = scan.next();
                    System.out.println("Enter the GENDER:");
                    String gender = scan.next();
                    System.out.println("Enter the MARKS:");
                    float marks = scan.nextFloat();
                    System.out.println("Enter the DOB:");
                    String dob = scan.next();
                    scan.nextLine();

                    // Set the values for the prepared statement
                    statement2.setInt(1, id);
                    statement2.setString(2, name);
                    statement2.setString(3, gender);
                    statement2.setFloat(4, marks);
                    statement2.setString(5, dob);

                    statement2.addBatch(); // Add the statement to the batch
                } else if (!str.equalsIgnoreCase("NO")) {
                    System.out.println("Invalid input, Please enter 'Yes' or 'No'.");
                }
            } while (!str.equalsIgnoreCase("NO"));

            // Execute the batch of insert statements
            int[] arr = statement2.executeBatch();
            System.out.println(Arrays.toString(arr)); // Print the array of update counts

        } catch (ClassNotFoundException e) {
            e.printStackTrace(); // Print stack trace if the JDBC driver class is not found
        } catch (SQLException e) {
            e.printStackTrace(); // Print stack trace if there is an SQL exception
        }

        System.out.println();
        System.out.println("After updating, the fetched data from the database:");
        print(resultset, statement1, query1); // Fetch and print the updated data from the database

        close(connection, statement1, statement2, resultset); // Close all resources
        scan.close(); // Close the scanner

    }

    // Method to print the results of a query
    public static void print(ResultSet resultset, Statement statement1, String query1) {

        System.out.println("----------------------------------------");
        System.out.println("| ID | Name  |Gender| Marks |   DOB    |");
        System.out.println("----------------------------------------");
        try {
            resultset = statement1.executeQuery(query1); // Execute the query and get the result set
            while (resultset.next()) {
                // Print each record in a formatted manner
                System.out.printf("| %-2d | %-5s |  %-4s| %-6.2f|%-10s|\n",
                        resultset.getInt("s_id"), resultset.getString("s_name"),
                        resultset.getString("gender"), resultset.getFloat("marks"),
                        resultset.getString("dob"));
            }
            System.out.println("----------------------------------------");

        } catch (SQLException e) {
            e.printStackTrace(); // Print stack trace if there is an SQL exception
        }
    }

    // Method to close all database resources
    public static void close(Connection connection, Statement statement1, Statement statement2, ResultSet resultset) {

        try {
            if (connection != null) {
                connection.close(); // Close the connection
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Print stack trace if there is an SQL exception
        }
        try {
            if (statement1 != null) {
                statement1.close(); // Close the statement
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Print stack trace if there is an SQL exception
        }
        try {
            if (statement2 != null) {
                statement2.close(); // Close the prepared statement
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Print stack trace if there is an SQL exception
        }
        try {
            if (resultset != null) {
                resultset.close(); // Close the result set
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Print stack trace if there is an SQL exception
        }
    }
}
