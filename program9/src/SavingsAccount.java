//***************************************************************
//
//  Developer:         Azul Lanas
//
//  Program #:         Program 9
//
//  File Name:         SavingsAccount.java
//
//  Course:            ITSE 2321 Object-Oriented Programming - Java 
//
//  Due Date:          April 23rd 2021
//
//  Instructor:        Fred Kumi 
//
//  Chapter:           Chapter 8
//
//  Description:
//     
//		
//
//***************************************************************
import java.text.DecimalFormat;

public class SavingsAccount {
	private static double annualInterestRate;
	private double savingsBalance, monthlyInterest;
	
	
	   //***************************************************************
	   //
	   //  Constructor:  SavingsAccount
	   // 
	   //  Description:  initializes savingsBalance
	   //
	   //  Parameters:   double savingsBalance
	   //
	   //
	   //**************************************************************
	
	SavingsAccount(double savingsBalance) {
		this.savingsBalance = savingsBalance;
		
		if (this.savingsBalance < 0.0) {
			throw new IllegalArgumentException("No Negative Numbers.");
		}
	
	}
	   //***************************************************************
	   //
	   //  Method:       calculateMonthlyInterest
	   // 
	   //  Description:  calculates the monthly interest
	   //
	   //  Parameters:   none
	   //
	   //  Returns:      void
	   //
	   //**************************************************************
	
	public void calculateMonthlyInterest() {
		monthlyInterest = annualInterestRate / 100 / 12 * savingsBalance;
		depositAmount(monthlyInterest);
		
	}
	   //***************************************************************
	   //
	   //  Method:       depositAmount
	   // 
	   //  Description:  increments the savingsBalance when money is deposited
	   //
	   //  Parameters:   double amount
	   //
	   //  Returns:      void 
	   //
	   //**************************************************************
	
	public void depositAmount(double amount) {
		if(amount > 0.0) {
			savingsBalance += amount;
		} else {
			throw new IllegalArgumentException("No Negative Numbers.");
		}
	}
	
	//***************************************************************
	   //
	   //  Method:       withdrawAmount
	   // 
	   //  Description:  decrements the savingsBalance when money is withdrawn
	   //
	   //  Parameters:   double amount
	   //
	   //  Returns:      void 
	   //
	   //**************************************************************
	
	public void withdrawAmount(double amount) {
		
		if(amount > 0.0) {
			savingsBalance -= amount;
		} else {
			throw new IllegalArgumentException("No Negative Numbers.");
		}
	}
	
	//***************************************************************
	   //
	   //  Method:       toString
	   // 
	   //  Description:  returns savingsBalance as a string
	   //
	   //  Parameters:   none
	   //
	   //  Returns:     String
	   //
	   //**************************************************************
	
	public String toString() {
		DecimalFormat format = new DecimalFormat("#.00");
		return ""+format.format(savingsBalance);
	}
	
	//***************************************************************
	   //
	   //  Method:       modifyInterestRate
	   // 
	   //  Description:  changes the interest rate variable
	   //
	   //  Parameters:   double rate
	   //
	   //  Returns:      void 
	   //
	   //**************************************************************
	
	public static double modifyInterestRate(double rate) {
		if (rate >= 2.0 && rate <= 5.0) {
			annualInterestRate = rate;
			return annualInterestRate;
		}else {
			throw new IllegalArgumentException("2-5 only");
		}
	}
	
	
}