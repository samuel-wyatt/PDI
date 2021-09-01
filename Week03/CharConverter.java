import java.util.*;
public class CharConverter
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        char upperCase, lowerCase;
        int upperDec, lowerDec, userChoice;

	System.out.println("Would you like to convert from:\n(1) Uppercase to lowercase\n(2) Lowercase to uppercase");
	userChoice = sc.nextInt();

	if (userChoice == 1)
	{
	    System.out.println("Please enter an uppercase character: ");
    	    upperCase = sc.next().charAt(0);
	    upperDec = (int)upperCase;
	    lowerDec = upperDec + 32;
	    lowerCase = (char)lowerDec;
	    System.out.println("The ASCII value of '" + upperCase + "' is: " + upperDec);
	    System.out.println("The lowercase value of '" + upperCase + "' is: '" + lowerCase + "'");
	    
	}
	
	else if (userChoice == 2)
	{
	    System.out.println("Please enter a lowercase character: ");
    	    lowerCase = sc.next().charAt(0);
	    lowerDec = (int)lowerCase;
	    upperDec = lowerDec - 32;
	    upperCase = (char)upperDec;
	    System.out.println("The ASCII value of '" + upperCase + "' is: " + upperDec);
	    System.out.println("The uppercase value of '" + lowerCase + "' is: '" + upperCase + "'");
	}

	else 
	{
	    	System.out.println("ERROR: INVALID INPUT");
   	}
	sc.close();
    }
}
