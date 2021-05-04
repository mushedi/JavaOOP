import java.io.IOException;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.NoSuchElementException;
import java.util.Scanner;

//***************************************************************
//
//  Developer:         Azul Lanas
//
//  Program #:         Program 10
//
//  File Name:         Program10.java
//
//  Course:            ITSE 2321 Object-Oriented Programming - Java 
//
//  Due Date:          May 8th 2021
//
//  Instructor:        Fred Kumi 
//
//  Chapter:           Chapter 
//
//  Description:	   this program keeps track of the bank account of two savers, the data is hardcoded
//     
//		
//
//***************************************************************


public class Program10 {
	
	private Scanner input;
	private Formatter output;
	
	
	public static void main(String[] args){
		ArrayList<Object> records = new ArrayList<Object>();
		Program10 myObject = new Program10();
		myObject.openFile();
		myObject.developerInfo();
		myObject.readRecords(records);
		myObject.closeFile();
	}
	
	public void openFile(){
		try {
			input = new Scanner(Paths.get("program10.txt"));
			output = new Formatter("Program10-out.txt");
		}
		catch(IOException ioException){
			System.err.println("Error opening file. Terminating.");
	        System.exit(1);
		}
	}
	
	public void readRecords(ArrayList<Object> records) {
		int count = 0, id = 0, household = 0;
		double income = 0.0;
		String state = "";
		try 
	      { 
	         while (input.hasNext())
	         {
	        	 if (count == 0) {
	        		 id = Integer.parseInt(input.next());
	        		 count++;
	        	 } else if (count == 1) {
	        		 income = Double.parseDouble(input.next());
	        		 count++;
	        	 } else if (count == 2) {
	        		 household = Integer.parseInt(input.next());
	        		 count++;
	        	 } else if ( count == 3) {
	        		 state = input.next();
	        		 count = 0;
	        		 
	        		 Household record = new Household(id, income, household, state);
	        		 
	        		 records.add(record);
	        	 }
	         }
	         calculations(records);
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
	
	public void calculations(ArrayList<Object> records) {
		double total = 0, avg = 0, povertyLevel = 0, percentage = 0;
		int count = 0;
		for (Object i : records) {
			if (records.indexOf((Household) i) == 0) {
				printRecords(records, 0, 0, (Household) i);
				
			}
			printRecords(records, 3, 0, (Household) i);
			total += ((Household) i).getIncome();
			count++;
			
			if (count == records.size()) {
				avg = total / count;
				
			    printRecords(records, 2, avg, (Household) i);
			}
		}
	    count = 0;
	    for (Object i : records) {
			if (((Household) i).getIncome() > avg) {
				if (count == 0) {
					printRecords(records, 0, 0, (Household) i);
					count++;
				}
				printRecords(records, 3, 0, (Household) i);
			}	
	    }
	    count = 0;
	    for (Object i : records) {
	    	if (((Household)i).getState().equals("Alaska")) {
	    		povertyLevel = 21550.00 + 5600.00 * (((Household)i).getHousehold() - 2);
	    	} else if(((Household)i).getState() == "Hawaii") {
	    		povertyLevel = 19830.00 + 5150.00 * (((Household)i).getHousehold() - 2);
	    	} else {
	    		povertyLevel = 17240.00 + 4480.00 * (((Household)i).getHousehold() - 2);
	    	}
	
	    	if (((Household)i).getIncome() < povertyLevel) {
	    		if (percentage == 0) {
					printRecords(records, 4, 0, (Household) i);
				}
	    		printRecords(records, 5, povertyLevel, (Household) i);
	    		percentage++;
	    	}
	    	count++;
	    	if (count == records.size()) {
	    		percentage = percentage / records.size() * 100;    	
		    	printRecords(records, 6, percentage, (Household) i);
	    	}
	    }
	}
	
	public void printRecords(ArrayList<Object> records, int determiner, double avg, Household r) {
		DecimalFormat format = new DecimalFormat("$#,###.00");
		if (determiner == 0) {
			output.format("%n%9s %20s %15s %15s%n%n", "ID", "Income", "Members", "State");
			
		} else if (determiner == 1) {
			output.format("%10d %20s %10d %20s%n", ((Household) r).getID(), format.format(((Household) r).getIncome()), ((Household) r).getHousehold(), ((Household) r).getState());
			
		} else if (determiner == 2) {
			output.format("%n%nThe average household income is: %s%n", format.format(avg));
			
		} else if(determiner == 3) {
			output.format("%10d %20s %10d %20s%n", ((Household) r).getID(), format.format(((Household) r).getIncome()), ((Household) r).getHousehold(), ((Household) r).getState());
		
		} else if(determiner == 4) {
			output.format("%n%nFamilies below the poverty level:%n%n%18s %7s %20s %15s %16s%n%n","Poverty Level", "ID", "Income", "Members", "State");
		
		} else if(determiner == 5) {
			output.format("%16s %10d %20s %10d %20s%n", format.format(avg), ((Household) r).getID(),format.format(((Household) r).getIncome()), ((Household) r).getHousehold(), ((Household) r).getState());
		} else if(determiner == 6) {
			output.format("%n%nThe percentage of households below the poverty level: %.2f%%", avg);
		}
	}
	
	public void closeFile() {
		if (input != null) {
			input.close();
		}
		if (output != null) {
			output.close();
		}
	}
	
	public void developerInfo(){
		output.format("%nName:    Azul Lanas%nCourse:  ITSE 2321 Object-Oriented Programming%nProgram: Ten %n%n");
	} 
 }