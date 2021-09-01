/*******************************************************************************
* Author: Samuel Wyatt
* Date: 01/09/2021
* Purpose: The Pond Calculator from PDI Worksheet 05
*******************************************************************************/

import java.util.*;
public class PondCalculator
{
    public static void main(String[] args)
    {
        pondCalcProg();
    }


    /*  SUBMODULE: pondCalcProg
        IMPORT: none
        EXPORT: none
        ASSERTION: To call the methods needed for running the program. */
    public static void pondCalcProg()
    {
        boolean exit = false;
        int userInput;
        do
        {
            userInput = mainMenu();
            switch(userInput)
            {
                case 1:
                    exit = joey();
                break;
                case 2:
                    exit = cory();
                break;
                case 3:
                    exit = rachel();
                break;
                case 0:
                    exit = true;
                break;
            }
        exit = secondMenu();
        } while(!(exit == true));
        
    }


    /*  SUBMODULE: mainMenu
        IMPORT: none
        EXPORT: userInput
        ASSERTION: Display the main menu. */
    public static int mainMenu()
    {
        int minVal = 0, maxVal = 3;
        System.out.println("Who's pond would you like to calculate?\n1. Joey" +
                                              "\n2. Cory\n3. Rachel\n0. Exit");
        return userInput(minVal, maxVal);
    }


    /*  SUBMODULE: userInput
        IMPORT: minVal, maxVal
        EXPORT: userInput
        ASSERTION: To take the user input and return the value. */
    public static int userInput(int minVal,int maxVal)
    {
        int userInput;
        Scanner sc = new Scanner(System.in);
        do
        {
            userInput = Integer.parseInt(sc.nextLine());
            if (userInput < minVal || userInput > maxVal)
            {
                System.out.println("Error: the value must be between: " + 
                  minVal + " and " + maxVal + "\nPlease enter a valid choice");
            }
        } while(userInput < minVal || userInput > maxVal);
        
        return userInput;
    }


    /*  SUBMODULE: volCalc
        IMPORT: name
        EXPORT: volume
        ASSERTION:  To gather user input, and calculate the volume. */
    public static int volCalc(String name)
    {
        int depth, length, width, volume;
        Scanner sc = new Scanner(System.in);
        System.out.print("You chose " + name + ". Please enter the: ");
        System.out.print("\nDepth: ");
        depth = Integer.parseInt(sc.nextLine());
        
        System.out.print("Length: ");
        length = Integer.parseInt(sc.nextLine());
        
        System.out.print("Width: ");
        width = Integer.parseInt(sc.nextLine());

        volume = (depth * length * width);
        return volume;
    }


    /*  SUBMODULE: joey
        IMPORT: none
        EXPORT: exit
        ASSERTION: To complete all tasks related to joey */
    public static boolean joey()
    {
        String name = "Joey";
        int minVal = 1, maxVal = 2, volume, userInput;
        boolean exit;
        volume = volCalc(name);
        System.out.println("Thankyou! Now please select an animal: ");
        System.out.println("1. Sting Rays\n2. Arowana");
        userInput = userInput(minVal, maxVal);
        if (userInput == 1)
        {
            double numAnimals = volume * 0.5;
            System.out.println(name + " can store " + (int)numAnimals + 
            " sting rays in his " + volume + "m^3 pond");
        }
        else
        {
            double numAnimals = volume * 0.4;
            System.out.println(name + " can store " + (int)numAnimals + 
            " arowana in his " + volume + "m^3 pond");
        }
    }


    /*  SUBMODULE: cory
        IMPORT: none
        EXPORT: exit
        ASSERTION: To complete all tasks related to cory */
    public static boolean cory()
    {
        String name = "Cory";
        int minVal = 1, maxVal = 2, volume, userInput;
        boolean exit;
        volume = volCalc(name);
        System.out.println("Thankyou! Now please select an animal: ");
        System.out.println("1. Koi\n2. Puffer Fish");
        userInput = userInput(minVal, maxVal);
        if (userInput == 1)
        {
            double numAnimals = volume * 0.6;
            System.out.println(name + " can store " + (int)numAnimals + 
            " koi in his " + volume + "m^3 pond");
        }
        else
        {
            double numAnimals = volume * 0.8;
            System.out.println(name + " can store " + (int)numAnimals + 
            " puffer fish in his " + volume + "m^3 pond");
        }
    }


    /*  SUBMODULE: rachel
        IMPORT: none
        EXPORT: exit
        ASSERTION: To complete all tasks related to joey */
    public static boolean rachel()
    {
        String name = "Rachel";
        int minVal = 1, maxVal = 2, volume, userInput;
        boolean exit;
        volume = volCalc(name);
        System.out.println("Thankyou! Now please select an animal: ");
        System.out.println("1. Turtles\n2. Frogs");
        userInput = userInput(minVal, maxVal);
        if (userInput == 1)
        {
            double numAnimals = volume * 1.2;
            System.out.println(name + " can store " + (int)numAnimals + 
            " turtles in her " + volume + "m^3 pond");
        }
        else
        {
            double numAnimals = volume * 4.5;
            System.out.println(name + " can store " + (int)numAnimals + 
            " frogs in her " + volume + "m^3 pond");
        }
    }


    /*  SUBMODULE: secondMenu
        IMPORT: 
        EXPORT: exit
        ASSERTION: To prompt the user with a menu, asking if they wish to exit */
    public static boolean secondMenu()
    {
        int userInput;
        boolean exit;
        Scanner sc = new Scanner(System.in);
        do
        {
            System.out.println("\nPress 1 to return to the main menu, or 9 to exit");
            userInput = Integer.parseInt(sc.nextLine());
            if (userInput == 1 || userInput == 9)
            {
            } else {
                System.out.println("Please enter a correct menu choice");
            }
        } while (userInput != 1 || userInput != 9);
        return exit = true;
    }   
}
