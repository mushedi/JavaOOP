//***************************************************************
//
//  Developer:         Azul Lanas
//
//  Program #:         2
//
//  File Name:         Program2.java
//
//  Course:            ITSE 2321 Object-Oriented Programming - Java 
//
//  Due Date:          Feb 9th 2021
//
//  Instructor:        Prof. Fred Kumi 
//
//  Chapter:           Chapter 2
//
//  Description:
//     Calculate the tax and tip on a restaurant bill
//
//***************************************************************

public class Program2
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
		developerInfo();
		
		double bill = 44.50;
		
		double tax = bill * .0825;
		
		double subTotal = bill + tax;
		
		double tip = subTotal * .15;
		
		
		System.out.printf("Meal Cost:        %.2f%n", bill);
		System.out.printf("Tax Amount(8.25):  %.2f%n", tax);
		System.out.printf("Sub Total:        %.2f%n", subTotal);
		System.out.printf("Tip Amount(15):    %.2f%n", tip);
		System.out.printf("Total Bill:       %.2f%n", (bill + tax + tip));
		
       
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
       System.out.println("Program: Two \n");

    } // End of developerInfo
}
