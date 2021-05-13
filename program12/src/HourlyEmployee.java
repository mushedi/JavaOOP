import java.nio.file.Paths;
import java.util.Scanner;

//***************************************************************
//
//Developer:         Azul Lanas
//
//Program #:         Program 12
//
//File Name:         HourlyEmployee.java
//
//Course:            ITSE 2321 Object-Oriented Programming - Java 
//
//Due Date:          
//
//Instructor:        Fred Kumi 
//
//Chapter:           Chapter 
//
//Description:	   
//   
//		
//
//***************************************************************


public class HourlyEmployee extends Employee {
	private double totalHours, totalReg, totalOver;
	
	public HourlyEmployee() {}
	
	public HourlyEmployee(String firstName, String lastName, double payRate)
	   {
	      super(firstName, lastName, payRate);
	   }
	
	public static void main(String[] args) {
		HourlyEmployee myObj = new HourlyEmployee("John", "Doe", 50.10);
		Scanner input = new Scanner(System.in);
		double ans = 0.0;
		
		for(int c = 1; c <= 4; c++) {
			System.out.printf("Enter hours worked during week %d: ", c);
			ans = input.nextDouble();
			myObj.setHours(ans);
			}
		input.close();
		myObj.displayOutput();
	}
	
	public void setHours(double hours){
		totalHours += hours;
		
		if (hours > 40.0) {
			totalOver += hours - 40;
			totalReg += 40;
		} else {
			totalReg += hours;
		}
	}
	
	public double getRegHours(){
		return totalReg;
	}
	
	public double getOverHours() {
		return totalOver;
	}
	
	public double getRegPay() {
		return super.getPayRate() * totalReg;
	}
	
	public double getOverPay() {
		return (super.getPayRate() + super.getPayRate() / 2) * totalOver;
	}
	
	public double getTaxes(){
		
		double gross = getRegPay() + getOverPay(), tax;
		
		if(gross > 15000.00) {
			tax = 36 / gross * 100 * gross;
		} else if(gross > 10000.00) {
			tax = 31 / gross * 100;
		} else if (gross > 8000.00) {
			tax = 28 / gross * 100;
		} else if (gross > 4500.00) {
			tax = 22 / gross * 100 * gross;
		} else if ( gross > 2500.00) {
			tax = 15 / gross * 100;
		} else {
			tax = 10 / gross * 100;
		}
		return tax;
	}
	public void displayOutput() {
		super.toString();
		System.out.printf("Regular Hours: %.2f%nOvertime Hours: %.2f%nTotal Hours: %.2f%n%nPay Rate: %.2f%n%nRegular Pay: %.2f%nOvertime Pay: %.2f%nMonthly gross pay: %.2f%nTaxes: %.2f%nMonthly Net Pay: %.2f%n%n", totalReg, totalOver, totalHours, super.getPayRate(), getRegPay(), getOverPay(), (getRegPay() + getOverPay()), getTaxes(), (getRegPay() + getOverPay() + getTaxes()));
	}
	
}