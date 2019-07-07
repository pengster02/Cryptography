/**
 * This program will run the corresponding class of the user's choice of encryption.
 * Authors: Sarah Peng
 * Created: May 18th, 2019
 */

//Imports scanner.
import java.util.Scanner;

//Allows the user to choose which type of encryption they want.
public class ChooseCipher 
{
  //Test to see if the user's input matches one of the available cipher options.
  public static boolean choice(String choice, String type)
  {
	if (choice.equals(type))
	  return true;
	return false;
  }
	
  //Depending on the user's choice, it will run the corresponding cipher. 
  public static void main(String[] args) 
  {
	Scanner kb = new Scanner(System.in);
	String cipherType;
	boolean validEntry;
			
    //Prevents the user from entering a cipher option that is not available.
	do
	{
	  System.out.print("What type of encryption do you want to conduct: ");
	  cipherType = kb.nextLine();
	  if (choice(cipherType, "substitution") || choice(cipherType, "caesar cipher") || choice(cipherType, "complex caesar cipher"))
	    validEntry = true;
	  else
	  {
		validEntry = false;				
		System.out.println("INVALID ENTRY. PLEASE CHOOSE FROM: substitution, caesar cipher or complex caesar cipher.");
	  }
	}
	while (validEntry == false);
		
	//Runs the Substitution class if user inputs substitution.
	if (choice(cipherType, "substitution"))
	  Substitution.main(args);
	//Runs the CaesarCipher class if user inputs caesar cipher.
	else if (choice(cipherType, "caesar cipher"))
	  CaesarCipher.main(args);
	//Runs the ComplexCaesarCipher class if user inputs complex caesar cipher.
	else if (choice(cipherType, "complex caesar cipher"))
	  ComplexCaesarCipher.main(args);
  }
}

