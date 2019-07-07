/**
 * This program shifts all characters within a string incrementally depending on the user's input.
 * Authors: Sarah Peng
 * Created: May 18th, 2019
 */

//Imports scanner.
import java.util.Scanner;

//Encrypts the user's message by shifting all the characters by a certain amount based on the input.
public class ComplexCaesarCipher 
{
  //Asks the user for information for the encryption, printing out the original and the incrementally shifted messages.
  public static void main(String[] args) 
  {
	Scanner kb = new Scanner(System.in);
	String plainText, shift;
	int shiftNum, counter = 0;
	boolean validEntry;
		
	//Asks the user to input the message they want to encrypt.
	System.out.print("Enter your message: ");		
	plainText = kb.nextLine();
		
	//Prevents the user from inputing any other characters except for numbers between -25 to 25.
	do
	{
	  System.out.print("Choose the shifting value: "); 
	  shift = kb.nextLine();
	  try 
	  {
	    shiftNum = Integer.parseInt(shift);
	    
	    //Prevents the user from entering an integer less than 25 or more than 25.
	    if (shiftNum < -25 || shiftNum > 25)
		{
		  System.out.println("INVALID ENTRY. MUST BE AN INTEGER BETWEEN -25 TO 25");
		  validEntry = false;
		}
		else
		  validEntry = true;
	  }
	  catch (NumberFormatException e) 
	  {
		System.out.println("INVALID ENTRY. MUST BE AN INTEGER BETWEEN -25 TO 25");
		validEntry = false;
	  }
	}
	while (validEntry == false);
	
	//Prints the original and shifted messages.
	shiftNum = Integer.parseInt(shift);
	System.out.println("Plaintext: " + plainText);
	System.out.print("Ciphertext: ");
	for (int i = shiftNum; counter < plainText.length(); i++)
	{
	  System.out.print(CaesarCipher.newChar(plainText, i, counter));
	  counter++;
	}
  }
}