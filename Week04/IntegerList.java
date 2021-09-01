/*
Author: Samuel Wyatt
Date: 24/08/2021
Purpose: To take a user input and output every number from 1 to that input
*/

import java.util.*;
public class IntegerList
{
    public static void main(String[] args)
    {
        //Initialise Scanner
        Scanner sc = new Scanner(System.in);
        //Gather User Input
        int input;
        System.out.print("Please enter an integer: ");
        input = sc.nextInt();
        //For Loop
        for (int i = 1; i <= input; i++)
        {
        System.out.print(i + " ");
        }
    }
}
