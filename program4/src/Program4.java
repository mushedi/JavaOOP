//***************************************************************
//
//Developer:         Azul Lanas
//
//Program #:         4
//
//File Name:         Program4.java
//
//Course:            ITSE 2321 Object-Oriented Programming - Java 
//
//Due Date:          March 5th 2021
//
//Instructor:        Prof. Fred Kumi 
//
//Chapter:           Chapter 4/5
//
//Description:
//   Calculating an Employees yearly salary, overtime, regular hours, gross pay, net pay and deductions
//
//***************************************************************


import java.util.Scanner;


public class Program4 {
	public static void main(String[] args) {
		
		developerInfo();
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter Employee ID: ");
		int id = input.nextInt();
		
		System.out.print("Enter Employee Pay Rate: ");
		double payRate = input.nextDouble();
	
		System.out.print("Enter Employee hours: ");
		int hours = input.nextInt();
		
		input.close();
		
		int overtime;
		double grossPay, netPay, regPay, overtimePay, deductions, tax;
		
		
		if (hours > 40) {
			overtime = hours - 40;
		} else {
			overtime = 0;
		}
		
		hours = hours - overtime;
		overtimePay = overtime * (payRate * 1.5);
		regPay = hours * payRate;
		grossPay = regPay + overtimePay;
		
		
		if (grossPay > 600.00) {
			tax = grossPay * .125;
		} else {
			tax = 0.00;
		}
		
		deductions = tax + 30.00;
		
		netPay = grossPay - deductions;
		
		System.out.printf("%n%nID Number:          %d%n", id);
		System.out.printf("Pay Rate:           %.2f%n", payRate);
		System.out.printf("Regular Hours:      %d%n", hours);
		System.out.printf("Overtime Hours:     %d%n", overtime);
		System.out.printf("Total Hours:        %d%n",(hours + overtime));
		System.out.printf("Regular Pay:        %.2f%n",  regPay);
		System.out.printf("Overtime Pay:       %.2f%n", overtimePay);
		System.out.printf("Gross Pay:          %.2f%n", grossPay);
		System.out.printf("Tax:                %.2f%n", tax);
		System.out.printf("Deductions:         %.2f%n", deductions);
		System.out.printf("Net Pay:            %.2f%n", netPay);
		
		
	}
	public static void developerInfo()
    {
       System.out.println("Name:    Azul Lanas");
       System.out.println("Course:  ITSE 2321 Object-Oriented Programming");
       System.out.println("Program: Four \n\n");

    }
}
