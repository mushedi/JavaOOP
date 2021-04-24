//***************************************************************
//
//  Developer:         Azul Lanas
//
//  Program #:         1
//
//  File Name:         Program1.java
//
//  Course:            ITSE 2321 Object-Oriented Programming - Java 
//
//  Due Date:          Feb 4th 2021
//
//  Instructor:        Prof. Fred Kumi 
//
//  Chapter:           Chapter 2
//
//  Description:
//     Calculate gross income per paycheck for a employee earning 32500.00 anually
//
//***************************************************************

public class Program1
{
    //***************************************************************
    //
    //  Method:       main
    // 
    //  Description:  The main method of the program
    //
    //  Parameters:   String array
    //
    //  Returns:      N/A 
    //
    //**************************************************************
	public static void main(String[] args)
    {
       // declare variables here
	   double amount = 32500.00;
	   
       developerInfo();
    
       double twiceMonth = amount / 24;
       
       double biWeekly = amount / 26;
       
       System.out.println("Annual Salary           = " + amount);
       System.out.println("When paid twice a month = " + twiceMonth);
       System.out.println("When paid bi-weekly     = " + biWeekly);
    }
	
	//***************************************************************
    //
    //  Method:       developerInfo
    // 
    //  Description:  The developer information method of the program
    //
    //  Parameters:   None
    //
    //  Returns:      N/A 
    //
    //**************************************************************
    public static void developerInfo()
    {
       System.out.println("Name:    Azul Lanas");
       System.out.println("Course:  ITSE 2321 Object-Oriented Programming");
       System.out.println("Program: One \n");

    } // End of developerInfo
}