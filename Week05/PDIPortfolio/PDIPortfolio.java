/*******************************************************************************
Author: Samuel Wyatt                                                           *
Date: 18/08/2002                                                               *
Purpose: To prompt user with a menu, with basic arithmatic functions available *
*******************************************************************************/
import java.util.*;
public class PDIPortfolio
{
    public static void main(String[] args)
        {
            //Initialise userInput
            int userInput;
            do 
            {
                //Call the menuPrompt method
                userInput = menuPrompt();
                //Switch Statement for Menu Selection
                switch (userInput) 
                {    
                    case 1:
                        sum2Ints();
                        break;
                    case 2:
                        prod2Ints();
                        break;
                    case 3:
                        div2Ints();
                       break;
                    case 0:
                        System.out.println("Goodbye!");
                        break;
                }
            } while (userInput != 0);
        }        

    /***************************************************************************
    SUBMODULE: sum2Ints
    IMPORT: integerOne (int), integerTwo (int)
    EXPORT: none
    ASSERTION: To sum two integers and print the result
    ***************************************************************************/

    public static void sum2Ints()
    {
        System.out.println("\nThe sum of the two integers is: " +
                                    (integerOneInput() + integerTwoInput()));
    }

    /***************************************************************************
    SUBMODULE: prod2Ints
    IMPORT: integerOne (int), integerTwo (int)
    EXPORT: none
    ASSERTION: To multiply two integers and print the result
    ***************************************************************************/

    public static void prod2Ints()
    {
        System.out.println("\nThe product of the two integers is: " +
                                        (integerOneInput() * integerTwoInput()));
    }

    /***************************************************************************
    SUBMODULE: div2Ints
    IMPORT: integerOne (int), integerTwo (int)
    EXPORT: none
    ASSERTION: To divide two integers and print if they are divisible
    ***************************************************************************/

    public static void div2Ints()
    {
        if ((integerOneInput() % integerTwoInput()) == 0)
        {
            System.out.println("\nThe two integers ARE divisible");
        }
        else
        {
            System.out.println("\nThe two integers are NOT divisible");
        }
    }                 

    /***************************************************************************
    SUBMODULE: integerOneInput
    IMPORT: none
    EXPORT: integerOne
    ASSERTION: To prompt the user to enter the first integer and return it.
    ***************************************************************************/

    public static int integerOneInput()
    {
        Scanner sc = new Scanner(System.in);
        int integerOne;
        System.out.print("Please enter the first integer: ");
        integerOne = sc.nextInt();
        return integerOne;
    }

    /***************************************************************************
    SUBMODULE: integerTwoInput
    IMPORT: none
    EXPORT: integerTwo
    ASSERTION: To prompt the user to enter the second integer and return it.
    ***************************************************************************/

    public static int integerTwoInput()
    {
        Scanner sc = new Scanner(System.in);
        int integerTwo;
        System.out.print("Please enter the second integer: ");
        integerTwo = sc.nextInt();
        return integerTwo;
    }

    /***************************************************************************
    SUBMODULE: menuPrompt
    IMPORT: none
    EXPORT: userInput
    ASSERTION: To show a menu, and return the user input
    ***************************************************************************/

    public static int menuPrompt()
    {
        int userInput, maxValue = 3, minValue = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("\nWelcome to Programming Design and Impl" +
                                                               "ementation\n");
        System.out.println("What would you like to do?");
        System.out.println(" > 1. Sum of 2 Integers");
        System.out.println(" > 2. Product of 2 Integers");
        System.out.println(" > 3. Determine if 2 Integers are Divisible");
        System.out.println(" > 0. Exit");
        //Check if userInput is within accepted limits
        do
            {
                userInput = sc.nextInt();
                if (userInput > maxValue || userInput < minValue)
                {
                    System.out.println("Error: the value must be between " +
                                                minValue + " and " + maxValue);
                    System.out.print("Please enter another choice: ");
                }
            }
        while (userInput > maxValue || userInput < minValue);
        return userInput;
    }
}
