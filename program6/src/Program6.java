//***************************************************************
//
//  Developer:         Azul Lanas
//
//  Program #:         Program 6
//
//  File Name:         Program6.java
//
//  Course:            ITSE 2321 Object-Oriented Programming - Java 
//
//  Due Date:          April 5th 2021
//
//  Instructor:        Fred Kumi 
//
//  Chapter:           Chapter 15
//
//  Description:
//     This program reads a text file with current employee salaries and calculates the raise, percent and new salary
//		then sends the output to another text file
//
//***************************************************************
import java.util.*;
import java.io.IOException;
import java.nio.file.Paths;

public class Program6

{
   private Scanner input;
   private Formatter output;
   
   private double raiseAvg, raiseSum, totalSumBefore, totalAvgBefore, totalSumAfter, totalAvgAfter;

   public static void main(String[] args)
   {
	   Program6 myObject = new Program6();
	   
	   myObject.openFile();
       myObject.readRecords();
       myObject.closeFile();
	  
   } 

   //***************************************************************
   //
   //  Method:       openFile
   // 
   //  Description:  creates a scanner object input to read the contents of Program6 and 
   //   			 creates a formatter object output to write the text to the file
   //
   //  Parameters:   None
   //
   //  Returns:      N/A 
   //
   //**************************************************************
   
   public void openFile()
   {
      try
      {
         input = new Scanner(Paths.get("Program6.txt"));
         output = new Formatter("Program6-output.txt");
         
      } 
      catch (IOException ioException)
      {
         System.err.println("Error opening file. Terminating.");
         System.exit(1);
      }
   }
   
   
   //***************************************************************
   //
   //  Method:       readRecords
   // 
   //  Description:  goes line by line through the program6.txt file sending the old salary and counter to the calculations method   
   // 				 along with newSalary, raise and percent so that the variable doesn't have to be redeclared in the loop.
   //  Parameters:   None
   //
   //  Returns:      N/A 
   //
   //**************************************************************
   
   void readRecords()
   {
	  int count = 0;
  	  double oldSalary, newSalary = 0, raise = 0, percent = 0;
  	  
      try 
      { 
         while (input.hasNext())
         {
        	 count++;
        	 
        	 oldSalary = input.nextDouble();
        	 
        	 calculations(count, oldSalary, newSalary, raise, percent);
        	
         }
      }

      catch (NoSuchElementException elementException)
      {
         System.err.println("File improperly formed. Terminating.");
		 System.exit(1); // terminate the program
      } 
      catch (IllegalStateException stateException)
      {
         System.err.println("Error reading from file. Terminating.");
		 System.exit(1); // terminate the program
      }
   }
   
 //***************************************************************
   //
   //  Method:       calculations
   // 
   //  Description:  performs the calculations for the new salary, raise, and percent
   //
   //  Parameters:   int count, double oldSalary, double newSalary, double raise, double percent
   //
   //  Returns:      N/A 
   //
   //**************************************************************
   
   void calculations(int count, double oldSalary, double newSalary, double raise, double percent) {
	   
	   if (oldSalary > 70000) {
      		 percent = 4.0;
      	 } else if (oldSalary > 50000) {
      		 percent = 7.0;
      	 } else {
      		 percent = 5.5;
      	 }
      	 
      	raise = oldSalary * (percent / 100);
      	newSalary = oldSalary + raise;
      	
      	raiseSum += raise;
      	totalSumBefore += oldSalary;
      	totalSumAfter += newSalary;
      	
      	raiseAvg = raiseSum / count;
      	totalAvgAfter = totalSumAfter / count;
      	totalAvgBefore = totalSumBefore / count;
      	
      	writeToFile(count, oldSalary, newSalary, raise, percent);

   }
   
 //***************************************************************
   //
   //  Method:       writeToFile
   // 
   //  Description:  writes the arguments sent by calculations into the Program6-output file
   //
   //  Parameters:   int count,double oldSalary, double newSalary,double raise, double percent
   //
   //  Returns:      N/A 
   //
   //**************************************************************
   
   void writeToFile(int count,double oldSalary, double newSalary,double raise, double percent) {
	   
	   if (count == 1) {
		   developerInfo();
		   
		   output.format("%n %-12s %-15s %-15s %-15s %-15s %n%n", "Numbers", "Old Salary", "Percent", "Raise", "New Salary");
	   }
	   
	   output.format("%3s%-2d %17.2f %11.1f%% %15.2f %18.2f%n","", count, oldSalary, percent, raise, newSalary);
	   
	   if (count == 28) {
		   output.format("%n%nSum of Raises: %21.2f%nAverage of Raises: %17.2f%nSum of Old Salaries: %15.2f%nAverage of Old Salaries: %11.2f%nSum of New Salaries: %15.2f%nAverage of New Salaries: %11.2f%n", raiseSum, raiseAvg, totalSumBefore, totalAvgBefore, totalSumAfter, totalAvgAfter);
	   }
	   
   }
   
 //***************************************************************
   //
   //  Method:       closeFile
   // 
   //  Description:  closes the scanner and formatter objects to avoid leakage
   //
   //  Parameters:   None
   //
   //  Returns:      N/A 
   //
   //**************************************************************
   
   public void closeFile() {
	   if (output != null) {
		   output.close();
	   }
	   if (input != null) {
		   input.close();
	   }
   }

   void developerInfo()
   {
      output.format("%nName:    Azul Lanas%n");
      output.format("Course:  ITSE 2321 Object-Oriented Programming%n");
      output.format("Program: Six %n");
	  
   } // End of developerInfo
}


