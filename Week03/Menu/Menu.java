/********************************************************************************
Author: Samuel Wyatt                                                            *
Date: 18/08/2002                                                                *
Purpose: To prompt user with a menu, with basic arithmatic functions available  *
*********************************************************************************/
import java.util.*;
public class Menu
{
    public static void main(String[] args)
        {
            //Initialise variables, scanner, output menu message, and recieve userInput
            int divideAnswer, userInput, integerOne, integerTwo;
            Scanner sc = new Scanner(System.in);
    	    System.out.println("Welcome to Programming Design and Implementation\n\nWhat would you like to do?");
            System.out.println(" > 1. Sum of 2 Integers\n > 2. Product of 2 Integers\n > 3. Determine if 2 Integers are Divisible\n > 0. Exit");
            userInput = sc.nextInt();
            //Sum of two integers
            if (userInput == 1)
            {
                System.out.print("Please enter the first integer: ");
                integerOne = sc.nextInt();
                System.out.print("Please enter the second integer: ");
                integerTwo = sc.nextInt();
                System.out.println("The sum of the two integers is: " + (integerOne + integerTwo));
            }
            //Product of two integers
            else if (userInput == 2)
            {
                System.out.print("Please enter the first integer: ");
                integerOne = sc.nextInt();
                System.out.print("Please enter the second integer: ");
                integerTwo = sc.nextInt();
                System.out.println("The product of the two integers is: " + (integerOne * integerTwo));
            }
            //Check if two integers are divisible
            else if (userInput == 3)
            {
                System.out.print("Please enter the first integer: ");
                integerOne = sc.nextInt();
                System.out.print("Please enter the second integer: ");
                integerTwo = sc.nextInt();
                divideAnswer = integerOne % integerTwo;
                if (divideAnswer == 0)
                {
                    System.out.println("The two integers ARE divisible");
                } else 
                {
                    System.out.println("The two integers are NOT divisible");
                }
            //Exit message
            } else if (userInput == 0)
            {
                System.out.println("Goodbye!");
            }
            //Error message
            else 
            {
                System.out.println("ERROR: Invalid Input");
            }

            sc.close();
    }        
}


