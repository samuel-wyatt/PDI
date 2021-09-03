/**********************************
 *Author: Samuel Wyatt (20555535) *
 *Date: 02/09/2021                *
 *Purpose: Assignment 1 Java Code *
 *File Name: TaskTwo.java         *
 **********************************/

 import java.util.*;
 public class TaskTwo
 {
    public static void main(String[] args)
    {
        //Calls the initialMsg method, printing the title of the program.
        initialMsg();

        //Creates an array for Mohamed Salah, and fills it by createArray method
        System.out.println("Please enter the goals scored by Mohamed Salah: ");
        int[] mohamedSalah = new int[5];
        mohamedSalah = createArray();
        
        System.out.println("---------------");

        //Create an array for Harry Kane, and fills it by createArray method.
        System.out.println("Please enter the goals scored by Harry Kane: ");
        int[] harryKane = new int[5];
        harryKane = createArray();
        
        System.out.println("---------------");
        
        //Creates an array for Lionel Messi, and fills it by createArray method.
        System.out.println("Please enter the goals scored by Lionel Messi: ");
        int[] lionelMessi = new int[5];
        lionelMessi = createArray();
        
        //Visual Output for UI
        System.out.println("====================");
        System.out.println("Data Entry Complete");
        System.out.println("====================");
        
        //Calls the menuMsg method, which displays the main menu.
        //Calls the menuChoice method, which allows for user input.
        menuMsg();
        menuChoice(mohamedSalah, harryKane, lionelMessi);
        System.out.println("Goodbye!");
    }

    /************************************************
    *SUBMODULE: createArray
    *IMPORT: none
    *EXPORT: newArray (ARRAY)
    *ASSERTION: To fill the arrays with user input.
    *************************************************/
    public static int[] createArray()
    {
        Scanner sc = new Scanner(System.in);
        int[] newArray = new int[5];
        
        //For loop which outputs Week 1 to 5, and records the input into each 
        // element of the array from 0 through 4.
        for (int i = 0; i < 5; i++)
        {
            System.out.print("Week " + (i + 1) + ": ");
            int a = sc.nextInt();
            
            //Checks if input is a negative, and inputs zero if true.
            if (a < 0)
            {
                newArray[i] = 0;
            } else {
                newArray[i] = a;
            }
        }
        return newArray;
    }

    /*****************************************************
    *SUBMODULE: initalMsg
    *IMPORT: none
    *EXPORT: none
    *ASSERTION: Print the initial message of the program.
    ******************************************************/ 

    public static void initialMsg()
    {
        //Prints the inital message for the program
        System.out.println("**********************************************");
        System.out.println("| Welcome to the Golden Boot Tracker Program |");
        System.out.println("|  Your program will track goals scored by 3 |");
        System.out.println("|          players during 5 matches.         |");
        System.out.println("**********************************************");
        System.out.println("\nData Entry: ");
    }

    /****************************************************
    *SUBMODULE: menuMsg
    *IMPORT: none
    *EXPORT: none
    *ASSERTION: To print the menu message of the program.
    *****************************************************/

    public static void menuMsg()
    {   
        //Prints the main menu message for the program
        System.out.println();
        System.out.println("*-+*-+*-+*-+*-+*-+*-+*-+*-+*-+*-+*-+*-+*-+*-+*-+*");
        System.out.println("Menu Choice: ");
        System.out.println("> 1. Display the total number of goals scored by " + 
                                                                "each player.");
        System.out.println("> 2. Display the average number of goals scored " + 
                                                             "by each player.");
        System.out.println("> 3. Display the highest goal scorer's name and " + 
                                                            "number of goals.");
        System.out.println("> 0. Exit the program");
        System.out.print("\nYour choice: ");
    }

    /*******************************************************
    *SUBMODULE: menuChoice
    *IMPORT: mohamedSalah (ARRAY), harryKane (ARRAY), lionelMessi (ARRAY)
    *EXPORT: userInput (INTEGER)
    *ASSERTION: To control the input and output of the menu. 
    ********************************************************/

    public static int menuChoice(int[]mohamedSalah,int[]harryKane,int[]lionelMessi)
    {
        Scanner sc = new Scanner(System.in);

        //Takes user input.
        int userInput = sc.nextInt();
        //Loops method until userInput == 0
        do
        {
            //Takes userInput, and runs a method depending on choice.
            switch (userInput)
            {
                //Case 1,2 and 3 all call their own method, and the menuMsg
                // method afterwards to reprompt the user for more input.
                case 1: 
                    System.out.println();
                    totalGoals(mohamedSalah, harryKane, lionelMessi);    
                    menuMsg();
                    userInput = sc.nextInt();
                break;
                
                case 2: 
                    System.out.println();
                    averageGoals(mohamedSalah, harryKane, lionelMessi);
                    menuMsg();
                    userInput = sc.nextInt();
                break;
                
                case 3:
                    System.out.println();
                    highestPlayer(mohamedSalah, harryKane, lionelMessi);
                    menuMsg();
                    userInput = sc.nextInt();
                break;
                
                case 0:

                break;
                //Error message if input is invalid.
                default:
                    System.out.print("Invalid Choice, please try again: \n");
                    userInput = sc.nextInt();
            }   
            //Loop will only end if 0 is input, which is "Exit the Program"
            // on the menu.
        } while (userInput != 0);
        return userInput;
    }
    
    /****************************************************************
    *SUBMODULE: totalGoals
    *IMPORT: mohamedSalah (ARRAY), harryKane (ARRAY), lionelMessi (ARRAY)
    *EXPORT: none
    *ASSERTION: To run menu choice 1, the sum of each player's goals.
    ****************************************************************/

    public static void totalGoals(int[]mohamedSalah,int[]harryKane,int[]lionelMessi)
    {
        //Uses the sumArray method to sum the elements of the array.
        //Checks if the sum is 1, so grammar is correct when outputting the sum.
        int sum = sumArray(mohamedSalah);
        if (sum == 1)
        {
            System.out.println("Mohamed Salah scored " + sum + "goal.");
        } else {
            System.out.println("Mohamed Salah scored " + sum + " goals.");
        }
        
        sum = sumArray(harryKane);
        if (sum == 1)
        {
            System.out.println("Harry Kane scored " + sum + " goal.");
        } else {
            System.out.println("Harry Kane scored " + sum + " goals.");
        }
        
        sum = sumArray(lionelMessi);
        if (sum == 1)
        {
            System.out.println("Lionel Messi scored " + sum + " goal.");
        } else {
            System.out.println("Lionel Messi scored " + sum + " goals.");
        }
    }

    /*******************************************************************
    *SUBMODULE: averageGoals
    *IMPORT: mohamedSalah (ARRAY), harryKane (ARRAY), lionelMessi (ARRAY)
    *EXPORT: none
    *ASSERTION: To run menu choice 2, the average of each player's goals.
    *******************************************************************/
    
    public static void averageGoals(int[]mohamedSalah,int[]harryKane,int[]lionelMessi)
    {
        //Prints the average of each player, by using the sumArray method, 
        //and dividing by 5.
        System.out.println("Mohamed Salah scored an average of " + 
                   ((double)sumArray(mohamedSalah) / 5.0) + " goals per game.");
        
        System.out.println("Harry Kane scored an average of " + 
                      ((double)sumArray(harryKane) / 5.0) + " goals per game.");
        
        System.out.println("Lionel Messi scored an average of " + 
                    ((double)sumArray(lionelMessi) / 5.0) + " goals per game.");
    }

    /**********************************************
    *SUBMODULE: sumArray
    *IMPORT: tempArray (ARRAY)
    *EXPORT: sum (INTEGER)
    *ASSERTION: To calcualte the sum of each array.
    ***********************************************/

    public static int sumArray(int[]tempArray)
    {
        //Uses a for loop to add each element of the array to the variable sum.
        int sum = 0;
        for (int i = 0; i < 5; i++)
        {
            sum += tempArray[i];
        }
        return sum;
    }
    
    /**************************************************************************
    *SUBMODULE: arrayComparison
    *IMPORT: mohamedSalah (ARRAY), harryKane (ARRAY), lionelMessi (ARRAY)
    *EXPORT: largestArray (ARRAY)
    *ASSERTION: To compare 3 arrays, and return the array with the largest 
    *           sum of variables.
    **************************************************************************/

    public static int[] arrayComparison(int[]mohamedSalah,int[]harryKane,int[]lionelMessi)
    {
        //Records the sum of each array as an integer.
        int array1 = sumArray(mohamedSalah);
        int array2 = sumArray(harryKane);
        int array3 = sumArray(lionelMessi);
        
        //Creates an array called largestArray.
        int[] largestArray = new int[5];
       
        /* Each array sum is compared to each other, and the largest is copied
           to largestArray. If two arrays are the same size, one is copied over
           to represent this. */
        if (array1 > array2 && array1 > array3)
        {
            largestArray = mohamedSalah;
        } else if (array2 > array1 && array2 > array3)
        {
            largestArray = harryKane;
        } else if (array3 > array1 && array3 > array2)
        {
            largestArray = lionelMessi;
        } else if (array1 == array2)
        {
            largestArray = mohamedSalah;
        } else if (array1 == array3)
        {
            largestArray = mohamedSalah;
        } else if (array2 == array3)
        {
            largestArray = harryKane;
        } else 
        {
            largestArray = mohamedSalah;
        }
        return largestArray;
    }

    /*************************************************************************
    SUBMODULE: highestPlayer
    IMPORT: mohamedSalah (ARRAY), harryKane (ARRAY), lionelMessi (ARRAY)
    EXPORT: none
    ASSERTION: To determine the player/s with the highest score, and print it.
    **************************************************************************/

    public static void highestPlayer(int[]mohamedSalah,int[]harryKane,int[]lionelMessi)
    {
        /*lrgArr is created, and the arrayComparison method is called to
          determine the largest of the three, and copy it to that array. */
        int[] lrgArr = new int[5];
        lrgArr = arrayComparison(mohamedSalah, harryKane, lionelMessi);
        
        //The sum of lrgArr is created using the sumArray method.
        int arrSum = sumArray(lrgArr);
        
        //The sum of the three arrays are assigned to integers for comparison.
        int mohSal = sumArray(mohamedSalah);
        int harKan = sumArray(harryKane);
        int lioMes = sumArray(lionelMessi);

        /*lrgArr is compared to the sum of all three player arrays, then 
          combinations of two, and then finally individually to determine 
          if multiple players have the same total amount of goals, and the 
          relevant message is output. */
        if ((arrSum == mohSal) && (arrSum == harKan) && (arrSum == lioMes))
        {
            System.out.println("Mohamed Salah, Harry Kane and Lionel Messi " +
                      "all scored the same amount, with " + arrSum + " goals.");
        } else if((arrSum == mohSal) && (arrSum == harKan))
        {
            System.out.println("Mohamed Salah and Harry Kane are the equal " +
                                         "highest, with " + arrSum + " goals.");
        } else if((arrSum == mohSal) && (arrSum == lioMes))
        {
            System.out.println("Mohamed Salah and Lionel Messi are the equal" +
                                        " highest, with " + arrSum + " goals.");
        } else if((arrSum == harKan) && (arrSum == lioMes))
        {
            System.out.println("Harry Kane and Lionel Messi are the equal " +
                                         "highest, with " + arrSum + " goals.");
        } else if (arrSum == mohSal)
        {
            System.out.println("Mohamed Salah scored the highest, with " +
                                                            arrSum + " goals.");
        } else if (arrSum == harKan)
        {
            System.out.println("Harry Kane scored the highest, with " + 
                                                            arrSum + " goals.");
        } else if (arrSum == lioMes)
        {
            System.out.println("Lionel Messi scored the highest, with " +
                                                            arrSum + " goals.");
        } 
    } 
}
