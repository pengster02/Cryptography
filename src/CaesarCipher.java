/**
 * This program shifts all characters within a string depending on the user's input.
 * Authors: Sarah Peng
 * Created: May 18th, 2019
 */

//Imports the scanner.
import java.util.Scanner;
public class CaesarCipher 
{
  //Tests to see if the character is upper case.
  public static boolean isUpperCase(String message, int k)
  {
	if (Character.isUpperCase(message.charAt(k)))
	  return true;
	return false;
  }

  //Tests to see if the character is lower case.
  public static boolean isLowerCase(String message, int k)
  {
	if (Character.isLowerCase(message.charAt(k)))
	  return true;
	return false;
  }
	
  //Returns the new character after being shifted.
  public static char newChar(String message, int n, int k)
  {
	char newChar = message.charAt(k);
    
	//Shifts lower case letters.
	if (CaesarCipher.isLowerCase(message, k))
	  newChar = (char) ((newChar - 97 + n) % 26 + 97);
    
	//Shifts upper case letters.
	if (CaesarCipher.isUpperCase(message, k))
	  newChar = (char) ((newChar - 65 + n) % 26 + 65);
	return newChar;
  }
	
  //Asks the user for information for the encryption, printing out the original and the shifted messages.
  public static void main(String[] args) 
  {
	Scanner kb = new Scanner(System.in);
	String plainText, shift;
	int shiftNum;
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
		
	//Prints out the original message and the shifted one.
	System.out.println("Plaintext: " + plainText);
	System.out.print("Ciphertext: ");
	for(int k = 0; k < plainText.length(); k ++)
	{
	  shiftNum = Integer.parseInt(shift);
	  System.out.print(newChar(plainText, shiftNum, k));
	}
  }
}
