//***************************************************************
//
//  Developer:         Azul Lanas
//
//  Program #:         Program 8
//
//  File Name:         Program8.java
//
//  Course:            ITSE 2321 Object-Oriented Programming - Java 
//
//  Due Date:          April 23rd 2021
//
//  Instructor:        Fred Kumi 
//
//  Chapter:           Chapter 7
//
//  Description:	   This program reads a txt file with rainfall for the months of the years and displays the rainfall
//     					in correlation with the right month then determines the avg, total, high, and low.
//		
//
//***************************************************************
import java.util.*;
import java.io.IOException;
import java.nio.file.Paths;

public class Program8

{
   private Scanner input;

   public static void main(String[] args)
   {
	   Program8 myObject = new Program8();
	   
	   myObject.openFile();
	   myObject.readRecords();
       myObject.closeFile();
	  
   } 

   //***************************************************************
   //
   //  Method:       openFile6
   // 
   //  Description:  creates a scanner object input to read the contents of Program8.txt 			
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
         input = new Scanner(Paths.get("Program8.txt"));
         
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
   //  Description:  creates a double array from the data in Program.txt
   //
   //  Parameters:   None
   //
   //  Returns:      N/A 
   //
   //**************************************************************
   
   void readRecords()
   {
  	  int count = 0;
  	  double[] rainfall = new double[12];
  	  
      try 
      { 
         while (input.hasNext())
         {
        	 rainfall[count++] = input.nextDouble();
         }
         calculations(rainfall);
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
   //  Description:  performs the calculations for the total, average, high, and low
   //
   //  Parameters:   double[] rainfall
   //
   //  Returns:      N/A 
   //
   //**************************************************************
   
   void calculations(double[] rainfall) {
	   double total = 0, avg = 0, high = rainfall[0], low = rainfall[0];
	   for(double item : rainfall) {
		   total += item;
		   if (item > high) {
			   high = item;
		   }
		   if (item < low) {
			   low = item;
		   }
	   }
	   
	   avg = total / 12;
	   
	   displayOutput(total, avg, high, low, rainfall);
	   
   }
   
   //***************************************************************
   //
   //  Method:       displayOutput
   // 
   //  Description:  displays the output on the console
   //
   //  Parameters:   double total double avg double high double low double[] rainfall
   //
   //  Returns:      N/A 
   //
   //**************************************************************
   
   public void displayOutput(double total, double avg, double high, double low, double[] rainfall) {
	   String name1 = "", name2 = "";
	   String[] months = {"January","February","March","April","May","June","July","August","September","October","November","December"};
	   
	   developerInfo();
	   for (int count = 0; count < rainfall.length; count++) {
		   System.out.printf("%-10s %10.2f%n", months[count], rainfall[count]);
		   
		   if (rainfall[count] == high) {
			   name1 = months[count];
		   } else if (rainfall[count] == low) {
			   name2 = months[count];
		   }
	   }
	   
	   System.out.printf("%n%n%nTotal rainfall for the year was %.2f inches%n%nAverage rainfall for the year was %.2f inches%n%nThe largest amount of rainfall was %.2f inches in the month of %s%n%nThe smallest amount of rainfall was %.2f inches in the month of %s", total, avg, high, name1, low, name2);
   }
   
   //***************************************************************
   //
   //  Method:       closeFile
   // 
   //  Description:  closes the scanner objects to avoid leakage
   //
   //  Parameters:   None
   //
   //  Returns:      N/A 
   //
   //**************************************************************
   
   public void closeFile() {

	   if (input != null) {
		   input.close();
	   }
   }
   
   public void developerInfo(){
		System.out.printf("%nName:    Azul Lanas%nCourse:  ITSE 2321 Object-Oriented Programming%nProgram: Eight %n%n%n");
	} // End of developerInfo
}

