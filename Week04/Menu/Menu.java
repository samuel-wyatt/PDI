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
            boolean exit = false;
            Scanner sc = new Scanner(System.in);
            do 
            {
                 
                
                int minValue = 0, maxValue = 3;
                System.out.println("\nWelcome to Programming Design and Implementation\n");
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
                        System.out.println("Error: the value must be between " + minValue + " and " + maxValue);
                        System.out.print("Please enter another choice: ");
                    }
                }
                while (userInput > maxValue || userInput < minValue);
                   //Switch Statement for Menu Selection
                switch (userInput) {
                    case 1: 
                        System.out.print("Please enter the first integer: ");
                        integerOne = sc.nextInt();
                        System.out.print("Please enter the second integer: ");
                        integerTwo = sc.nextInt();
                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nThe sum of the two integers is: " + (integerOne + integerTwo));
                        break;
                    case 2:
                        System.out.print("Please enter the first integer: ");
                        integerOne = sc.nextInt();
                        System.out.print("Please enter the second integer: ");
                        integerTwo = sc.nextInt();
                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nThe product of the two integers is: " + (integerOne * integerTwo));
                        break;
                    case 3:
                        System.out.print("Please enter the first integer: ");
                        integerOne = sc.nextInt();
                        System.out.print("Please enter the second integer: ");
                        integerTwo = sc.nextInt();
                        divideAnswer = integerOne % integerTwo;
                        if (divideAnswer == 0)
                        {
                            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nThe two integers ARE divisible");
                        } else 
                        {
                            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nThe two integers are NOT divisible");
                        }
                        break;
                    case 0:
                        System.out.println("Goodbye!");
                        exit = true;
                        break;
                    }
            } while (!exit);
            sc.close();
    }        
}
