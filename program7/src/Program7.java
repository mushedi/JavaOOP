//***************************************************************
//
//  Developer:         Azul Lanas
//
//  Program #:         Program 7
//
//  File Name:         Program7.java
//
//  Course:            ITSE 2321 Object-Oriented Programming - Java 
//
//  Due Date:          April 12th 2021
//
//  Instructor:        Fred Kumi 
//
//  Chapter:           Chapter 6
//
//  Description:       this is a multiplication game that you can exit if you get the answer correct five times
//					   and have to repeat if you get it wrong until you get it right
//					   after the first five correct you can choose to exit after each you get right
//
//***************************************************************
import java.security.SecureRandom;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Program7 {
	private Scanner input = new Scanner(System.in);
	private SecureRandom randomNum = new SecureRandom();
	
	private int count = 0, answer;
	
	public static void main (String[] args) {
		Program7 myObject = new Program7();
		
		developerInfo();
		myObject.promptQuestion();
		myObject.closeFile();
	}
	
	  //***************************************************************
	   //
	   //  Method:       promptQuestion
	   // 
	   //  Description:  Generates the two random integers and prompts them for an answer then calls checkAnswer and passes  
	   //   			 the answer, number 1 and number 2
	   //
	   //  Parameters:   None
	   //
	   //  Returns:      N/A 
	   //
	   //**************************************************************
	   
	
	public void promptQuestion() {		
		int n1 = randomNum.nextInt(10);
		int n2 = randomNum.nextInt(10);
		
		System.out.printf("How much is %d times %d?%nEnter your answer: ", n1, n2);
		
		answer = input.nextInt();
		
		checkAnswer(n1, n2, answer);
		
	}
	
	  //***************************************************************
	   //
	   //  Method:       checkAnswer
	   // 
	   //  Description:  This method receives arguments from promptQuestion and checks their answer 
	   //   			 then calls displayMessage to display a message and calls gameLoop
	   //				 to begin the loops for the game
	   //
	   //  Parameters:   int n1, int n2, int answer
	   //
	   //  Returns:      N/A 
	   //
	   //**************************************************************
	   
	
	public void checkAnswer(int n1, int n2, int answer) {
		boolean correct;
		if (answer == (n1 * n2)) {
			correct = true;
		} else {
			correct = false;
		}
		
		displayMessage(correct);
		
		gameLoop(correct, n1, n2);
	}
	
	  //***************************************************************
	   //
	   //  Method:       displayMessage
	   // 
	   //  Description:  displays a random message from one of the arrays depending on if the value of correct
	   //   			 
	   //
	   //  Parameters:   boolean correct
	   //
	   //  Returns:      N/A 
	   //
	   //**************************************************************
	   
	
	public void displayMessage(boolean correct) {
		try {
			String[] right = {"Excellent!","Very good!", "Nice work!", "Way to go!", "Keep up the good work!"}, 
					 wrong = {"That is incorrect!" ,"No. Please try again!","Wrong, Try once more!","No. Don’t give up!", "Incorrect. Keep trying!"};
			
			int n1 = randomNum.nextInt(5);
			
			if (correct == true) {
				System.out.println("\n"+right[n1] +"\n--------------------------------------------------------------------");
			} else {
				System.out.println("\n"+wrong[n1] + "\n--------------------------------------------------------------------");
			}
		}
		catch (InputMismatchException elementException) {
			System.err.println("Wrong data type. Terminating.");
			System.exit(1);
		}
		catch (NoSuchElementException elementException)
	      {
	         System.err.println("File improperly formed. Terminating.");
			 System.exit(1); // terminate the program
	      } 
		
	}
	
	  //***************************************************************
	   //
	   //  Method:       gameLoop
	   // 
	   //  Description:  This method increases the count if the user was correct and if not it will continuously prompt the the same 
	   //   			 question until they are right. Then it checks if the count is 5 or above and then asks if they want to exit.
	   //
	   //  Parameters:   boolean correct, int n1, int n2
	   //
	   //  Returns:      N/A 
	   //
	   //**************************************************************
	   
	public void gameLoop(boolean correct, int n1, int n2) {
		
		if(correct == true) {
			++count;
		} else {
			while (correct != true) {
				System.out.printf("How much is %d times %d?%nEnter your answer: ", n1, n2);
				answer = input.nextInt();
				if(answer == (n1 * n2)) {
					correct = true;
					++count;
				}
			
				displayMessage(correct);
			}
		}
		
		if (count >= 5) {
			System.out.printf("%nYou have gotten %d correct. Would you like to exit the game? Y or N: ", count);
			
			char leave = Character.toUpperCase(input.next(".").charAt(0));
			
			System.out.print("\n--------------------------------------------------------------------\n--------------------------------------------------------------------\n");
			
			if( leave == 'N') {
				promptQuestion();
			} else {
				System.out.print("Goodbye!\n--------------------------------------------------------------------\n--------------------------------------------------------------------");
				
			}
		} else {
			promptQuestion();
		}
	}
	
	  //***************************************************************
	   //
	   //  Method:       openFile
	   // 
	   //  Description:  closes the input to avoid data leakage
	   //   			 
	   //
	   //  Parameters:   None
	   //
	   //  Returns:      N/A 
	   //
	   //**************************************************************
	   
	public void closeFile() {
		if(input != null) {
			input.close();
		}
	}
	
	public static void developerInfo(){
		System.out.printf("%nName:    Azul Lanas%nCourse:  ITSE 2321 Object-Oriented Programming%nProgram: Seven %n%n--------------------------------------------------------------------%n");
	} // End of developerInfo
}