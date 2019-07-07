/**
 * This program substitutes all characters within a string with another one based on the user's inputs.
 * Authors: Sarah Peng
 * Created: May 18th, 2019
 */

//Imports scanner.
import java.util.Scanner;

//Substitutes a character with another character of the user's choice.
public class Substitution 
{
  //Tests to see if the input is a character.
  public static boolean isChar(String testChar)
  {
	if (testChar.length() == 1)
	  return true;
	return false;
  }
	
  //Tests to see if inputed character is in the message.
  public static boolean inMessage(String message, String testChar)
  {
	if (message.indexOf(testChar.charAt(0)) >= 0)
	  return true;
	return false;
  }
  
  //Asks the user for information for the encryption, printing out the original and the substi messages.
  public static void main(String[] args)
  {
	Scanner kb = new Scanner(System.in);
	String plainText, chosenChar, replaceChar;
		
	//Asks user to input a message.
	System.out.print("Enter your message: ");
	plainText = kb.nextLine();
		
	//Makes the user input a character that is present in the message inputed above.
	do
	{
	  System.out.print("Choose a character to change: ");
	  chosenChar = kb.nextLine();
   	  if (isChar(chosenChar) == false)
		System.out.println("INVALID ENTRY. TOO MANY CHARACTERS.");
	  if (inMessage(plainText, chosenChar) == false && isChar(chosenChar))
		System.out.println("INVALID ENTRY. CHOSEN CHARACTER NOT IN MESSAGE.");
	}
    while (!(isChar(chosenChar) && inMessage(plainText, chosenChar)));
	      
	//Makes the user input a character, not a string.
	do 
	{
	  System.out.print("Choose a character to replace it: ");
	  replaceChar = kb.nextLine(); 
	  if (isChar(replaceChar) == false)
	    System.out.println("TOO MANY CHARACTERS. TRY AGAIN.");
	}
	while (isChar(replaceChar) == false);
	 	
	//Prints the original and the encrypted text.
    System.out.println("Plaintext: " + plainText);    
	System.out.println("CipherText: " + plainText.replaceAll(chosenChar, replaceChar));   
  }
}
