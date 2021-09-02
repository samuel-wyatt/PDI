/**********************************
 *Author: Samuel Wyatt (20555535) *
 *Date: 02/09/2021                *
 *Purpose: Assignment 1 Java Code *
 **********************************/

 import java.util.*;
 public class TaskTwo
 {
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args)
    {
    initialMsg();

    int[] mohamedSalah = new int[5];
    mohamedSalah = mohamedSalahArray();
    System.out.println("---------------");
    
    int[] harryKane = new int[5];
    harryKane = harryKaneArray();
    System.out.println("---------------");
    
    int[] lionelMessi = new int[5];
    lionelMessi = lionelMessiArray();
    
    System.out.println("===============\nData Entry Complete\n===============");
    
    //menuChoice();
    }

    /************************************************
    *SUBMODULE: mohamedSalahArray
    *IMPORT: none
    *EXPORT: none
    *ASSERTION: To fill mohamedSalah with user input.
    *************************************************/
    public static int[] mohamedSalahArray()
    {
        Scanner sc = new Scanner(System.in);
        int[] mohamedSalah = new int[5];
        System.out.println("Please enter the goals scored by Mohamed Salah: ");
        for (int i = 0; i < 5; i++)
        {
            System.out.print("Week " + (i + 1) + ": ");
            int a = sc.nextInt();
            if (a < 0)
            {
                mohamedSalah[i] = 0;
            } else {
                mohamedSalah[i] = a;
            }
                
        }
        return mohamedSalah;
        
    }
    
    /************************************************
    *SUBMODULE: harryKaneArray
    *IMPORT: none
    *EXPORT: none
    *ASSERTION: To fill harryKane with user input.
    *************************************************/
    public static int[] harryKaneArray()
    {
        Scanner sc = new Scanner(System.in);
        int[] harryKane = new int[5];
        System.out.println("Please enter the goals scored by Harry Kane: ");
        for (int i = 0; i < 5; i++)
        {
            System.out.print("Week " + (i + 1) + ": ");
            int a = sc.nextInt();
            if (a < 0)
            {
                harryKane[i] = 0;
            } else {
                harryKane[i] = a;
            }
                
        }
        return harryKane;
        
    }
    
    /************************************************
    *SUBMODULE: lionelMessiArray
    *IMPORT: none
    *EXPORT: none
    *ASSERTION: To fill lionelMessi with user input.
    *************************************************/
    public static int[] lionelMessiArray()
    {
        Scanner sc = new Scanner(System.in);
        int[] lionelMessi = new int[5];
        System.out.println("Please enter the goals scored by Lionel Messi: ");
        for (int i = 0; i < 5; i++)
        {
            System.out.print("Week " + (i + 1) + ": ");
            int a = sc.nextInt();
            if (a < 0)
            {
                lionelMessi[i] = 0;
            } else {
                lionelMessi[i] = a;
            }
                
        }
        return lionelMessi;
        
    }

    /*****************************************************
    *SUBMODULE: initalMsg
    *IMPORT: none
    *EXPORT: none
    *ASSERTION: Print the initial message for the program
    ******************************************************/ 

    public static void initialMsg()
    {
        System.out.println("**********************************************");
        System.out.println("| Welcome to the Golden Boot Tracker Program |");
        System.out.println("|  Your program will track goals scored by 3 |");
        System.out.println("|          players during 5 matches.         |");
        System.out.println("**********************************************");
        System.out.println("\nData Entry: ");
    }

    /*************************************************************************
    *SUBMODULE: menuChoice
    *IMPORT: mohamedSalah, harryKane, lionelMessi
    *EXPORT: none
    *ASSERTION: To prompt the user with a menu, and return the input if valid.
    **************************************************************************/

    public static void menuChoice(int[] mohamedSalah, int[] harryKane, int[] lionelMessi)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("*-+*-+*-+*-+*-+*-+*-+*-+*-+*-+*-+*-+*-+*-+*-+*-+*");
        System.out.println("Menu Choice: ");
        System.out.println("> 1. Display the total number of goals scored by" + 
                                                                "each player.");
        System.out.println("> 2. Display the average number of goals scored " + 
                                                             "by each player.");
        System.out.println("> 3. Display the highest goal scorer's name and " + 
                                                            "number of goals.");
        System.out.print("\nYour choice: ");
        do
        {
            int userInput = sc.nextInt();
            if (userInput == 1 || userInput == 2 || userInput == 3)
            {
                calcControl(userInput);
            } else {
                System.out.print("Invalid Choice, please try again: ");
            }
        while (userInput != 1 || userInput != 2 || userInput != 3);
        System.out.println("*-+*-+*-+*-+*-+*-+*-+*-+*-+*-+*-+*-+*-+*-+*-+*-+*");
        }
    }

    /********



}
