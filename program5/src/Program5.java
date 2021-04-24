//***************************************************************
//
//Developer:         Azul Lanas
//
//Program #:         5
//
//File Name:         Program5.java
//
//Course:            ITSE 2321 Object-Oriented Programming - Java 
//
//Due Date:          March 12th 2021
//
//Instructor:        Prof. Fred Kumi 
//
//Chapter:           Chapter 5
//
//Description:
//   Calculate the discount available to the client depending on the units purchased
//
//***************************************************************

import java.util.Scanner;

public class Program5 {
	public static void main(String[] args) {
		
		double total = 0, discountApplied = 0.00;
		int discount = 0;
		
		developerInfo();
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the number of units sold: ");
		int units = input.nextInt();
		
		input.close();
		
		if (units > 0) {
			
			if (units >= 10 && units <= 39) {
				discount = 10;
			} else if (units >= 40 && units <= 65) {
				discount = 20;
			} else if (units >= 66 && units <= 90) {
				discount = 27;
			} else if (units >= 91 && units <= 120) {
				discount =  36;
			} else if (units >= 121 && units <= 199) {
				discount = 42;
			} else if (units >= 200) {
				discount= 48;
			}
			
			discountApplied = units * 109 * (discount / 100.0);
			total = units * 109 - discountApplied;
			
			System.out.printf("%nNumber of units purchased is:         %d%n", units);
			System.out.printf("Discount applied is:                  %d%%%n", discount);
			System.out.printf("Total saving due to discount is:      %.2f%n", discountApplied);
			System.out.printf("The total cost of the purchase is:    %.2f%n", total);
			
		} else {
			System.out.print("\nInvalid input. Negative numbers not allowed.");
		}
	}
	public static void developerInfo()
    {
       System.out.println("Name:    Azul Lanas");
       System.out.println("Course:  ITSE 2321 Object-Oriented Programming");
       System.out.println("Program: Five \n\n");

    }
}