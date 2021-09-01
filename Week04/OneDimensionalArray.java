/****************************************************************************
Author: Samuel Wyatt
Date: 24/08/2021
Purpose: To create an array filled with random numbers, length of user input.
*****************************************************************************/

import java.util.*;
public class OneDimensionalArray
{
    public static void main(String[] args)
    {
        //Initialise Scanner and Random number
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        //Initialise Variables
        int userInput, maxValue = 20, randomNum;
        boolean exit = false;

        //Generate user input within values
        System.out.print("Please enter an integer between 1 and 20: ");
        userInput = scan.nextInt();
        do 
        {
            if (userInput <= 0 || userInput >= 20)
            {
                System.out.println("ERROR: Integer is not between 1 and 20");
                System.out.print("Please enter a new value: ");
                userInput = scan.nextInt();
            }
        } while (userInput <= 0 || userInput >= 20);
        
        //Create array
        int[] theArray = new int[userInput];

        //For Statement
        for (int i = 0; i < userInput; i++)
        {
            randomNum = rand.nextInt(maxValue);
            theArray[i] = randomNum;
        }
        for (int a = 0; a < userInput; a++)
        {
            System.out.println("The value of element " + (a + 1) + " of the array is " + theArray[a] + ".");
        }
                
    }

}
