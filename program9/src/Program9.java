//***************************************************************
//
//  Developer:         Azul Lanas
//
//  Program #:         Program 9
//
//  File Name:         Program9.java
//
//  Course:            ITSE 2321 Object-Oriented Programming - Java 
//
//  Due Date:          April 23rd 2021
//
//  Instructor:        Fred Kumi 
//
//  Chapter:           Chapter 8
//
//  Description:	   this program keeps track of the bank account of two savers, the data is hardcoded
//     
//		
//
//***************************************************************

public class Program9 {
	
	private SavingsAccount saver1;
	private SavingsAccount saver2;
	
	public static void main(String[] args) {
		
		Program9 myObject = new Program9();
		myObject.saver1 = new SavingsAccount(2000.00);
		myObject.saver2 = new SavingsAccount(3000.00);
		
		SavingsAccount.modifyInterestRate(4);
		
		myObject.monthlyInterest(myObject.saver1, myObject.saver2);
		
		myObject.saver1.depositAmount(1500.00);
		myObject.saver2.withdrawAmount(550.00);
		
		SavingsAccount.modifyInterestRate(5);
		
		myObject.saver1.calculateMonthlyInterest();
		myObject.saver2.calculateMonthlyInterest();
		
		myObject.printOutput("January", myObject.saver1.toString(), myObject.saver2.toString(), 1);
	}
	   //***************************************************************
	   //
	   //  Method:       monthlyInterest
	   // 
	   //  Description:  calculates the monthly interest
	   //
	   //  Parameters:   SavingsAccount saver1 and saver2 objects
	   //
	   //  Returns:      void
	   //
	   //**************************************************************
	
	
	public void monthlyInterest(SavingsAccount saver1, SavingsAccount saver2) {
		String[] months = {"January","February","March","April","May","June","July","August","September","October","November","December"};
		String balanceS1, balanceS2;
		int count = 0;
		for (String item: months) {
			saver1.calculateMonthlyInterest();
			saver2.calculateMonthlyInterest();
			
			balanceS1 = saver1.toString();
			balanceS2 = saver2.toString();
			
			printOutput(item, balanceS1, balanceS2, count++);
		}
	}
	   //***************************************************************
	   //
	   //  Method:       printOut
	   // 
	   //  Description:  prints the output
	   //
	   //  Parameters:   String month, balanceS1, balanceS2 and int count
	   //
	   //  Returns:      void
	   //
	   //**************************************************************
	
	
	public void printOutput(String month, String balanceS1, String balanceS2, int count) {
		if (count == 0) {
			developerInfo();
			System.out.printf("%-20s %21s %20s%n%n","Month", "Saver One", "Saver Two");
		}
		
		System.out.printf("%-20s %20s %20s%n", month, balanceS1, balanceS2);
		
	}
	
	public void developerInfo(){
			System.out.printf("%nName:    Azul Lanas%nCourse:  ITSE 2321 Object-Oriented Programming%nProgram: Nine %n%n%n");
		} 
	
	
}