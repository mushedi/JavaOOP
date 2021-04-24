//***************************************************************
//
//  Developer:         Azul Lanas
//
//  Program #:         3
//
//  File Name:         Employee.java
//
//  Course:            ITSE 2321 Object-Oriented Programming - Java 
//
//  Due Date:          Feb 16th 2021
//
//  Instructor:        Prof. Fred Kumi 
//
//  Chapter:           Chapter 3
//
//  Description:
//     Create and Employee class with get and set methods
//
//***************************************************************
public class Employee{
	private String lastName;
	private String firstName;
	private double salary;
	
	public Employee(String firstName, String lastName, double salary) {
		this.lastName = lastName;
		this.firstName = firstName;
		if(salary < 0) {
			this.salary = 0.00;
		} else {
			this.salary = salary;
		}
	}
	
	public void setLast(String lastName){
		this.lastName = lastName;
	}
	
	public String getLast() {
		return lastName;
	}
	
	public void setFirst(String firstName) {
		this.firstName = firstName;
	}
	
	public String getFirst() {
		return firstName;
	}
	
	public void setSal(double salary) {
		if(salary < 0) {
			this.salary = 0.00;
		} else {
			this.salary = salary;
		}
	}
	
	public double getSal() {
		return salary;
	}
}