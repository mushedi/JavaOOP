//***************************************************************
//
//  Developer:         Azul Lanas
//
//  Program #:         3
//
//  File Name:         EmployeeTest.java
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
//     Created object using the Employee class to calculate yearly salary and a 20% raise
//
//***************************************************************

public class EmployeeTest{
	public static void main(String[] args) {
		
		developerInfo();
		
		Employee employee1 = new Employee("John", "Doe", 2875.00);
		Employee employee2 = new Employee("Jane", "Doe", 3150.75);

		double yearSalary1 = employee1.getSal() * 12;
		double yearSalary2 = employee2.getSal() * 12;
		
		String empName1 = employee1.getFirst() + " " + employee1.getLast();
		
		String empName2 = employee2.getFirst() + " " + employee2.getLast();
		
		
		System.out.printf("Employee 1: %s; Yearly Salary: %.2f%n", empName1, yearSalary1);
		System.out.printf("Employee 2: %s; Yearly Salary: %.2f%n%n%n", empName2, yearSalary2);
		
		
		System.out.println("Increasing employee salaries by 20%");
		System.out.printf("Employee 1: %s; Yearly Salary: %.2f%n", empName1, (yearSalary1 + yearSalary1 * .20));
		System.out.printf("Employee 2: %s; Yearly Salary: %.2f%n", empName2, (yearSalary2 + yearSalary2 * .20));
		
	}
	public static void developerInfo()
    {
       System.out.println("Name:    Azul Lanas");
       System.out.println("Course:  ITSE 2321 Object-Oriented Programming");
       System.out.println("Program: Three \n");

    }
}