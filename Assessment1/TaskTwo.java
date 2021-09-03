/**********************************
 *Author: Samuel Wyatt (20555535) *
 *Date: 02/09/2021                *
 *Purpose: Assignment 1 Java Code *
 **********************************/

 import java.util.*;
 public class TaskTwo
 {
    public static void main(String[] args)
    {
        //Calls the initialMsg method, printing the title of the program.
        initialMsg();

        //Creates an array, and fills it by calling the method for that array.
        int[] mohamedSalah = new int[5];
        mohamedSalah = mohamedSalahArray();
        System.out.println("---------------");
    
        int[] harryKane = new int[5];
        harryKane = harryKaneArray();
        System.out.println("---------------");
    
        int[] lionelMessi = new int[5];
        lionelMessi = lionelMessiArray();
    
        System.out.println("===============\nData Entry Complete\n===============");
        int userInput;
        do
        {
            menuMsg();
            userInput = menuChoice(mohamedSalah, harryKane, lionelMessi);
        } while (userInput != 0);  
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
    *ASSERTION: Print the initial message of the program
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

    /****************************************************
    *SUBMODULE: menuMsg
    *IMPORT: none
    *EXPORT: none
    *ASSERTION: To print the menu message of the program
    *****************************************************/

    public static void menuMsg()
    {
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

    /*************************************************************************
    *SUBMODULE: menuChoice
    *IMPORT: mohamedSalah, harryKane, lionelMessi
    *EXPORT: userInput (integer)
    *ASSERTION: To control the input and output of the menu. 
    **************************************************************************/

    public static int menuChoice(int[] mohamedSalah, int[] harryKane, int[] lionelMessi)
    {
        Scanner sc = new Scanner(System.in);
        int userInput = sc.nextInt();
        do
        {
            switch (userInput)
            {
                case 1: 
                    totalGoals(mohamedSalah, harryKane, lionelMessi);    
                break;
                case 2: 
                    averageGoals(mohamedSalah, harryKane, lionelMessi);
                break;
                case 3:
                    highestGoals(mohamedSalah, harryKane, lionelMessi);
                break;
                case 0:
                    return userInput;
                default:
                System.out.print("Invalid Choice, please try again: ");
                userInput = sc.nextInt();
            }   

        }
        while (userInput == 0);
        System.out.println();
        System.out.println("*-+*-+*-+*-+*-+*-+*-+*-+*-+*-+*-+*-+*-+*-+*-+*-+*");
        return userInput;
    }
    
    /****************************************************************
    *SUBMODULE: totalGoals
    *IMPORT: mohamedSalah, harryKane, lionelMessi
    *EXPORT: none
    *ASSERTION: To run menu choice 1, the sum of each player's goals
    ****************************************************************/

    public static void totalGoals(int[] mohamedSalah, int[] harryKane, int[] lionelMessi)
    {
        int[] tempArray = new int[5];
        tempArray = mohamedSalah;
        int sum = sumArray(tempArray);
        if (sum == 1)
        {
            System.out.println("Mohamed Salah scored " + sum + "goal.");
        } else {
            System.out.println("Mohamed Salah scored " + sum + " goals.");
        }
        tempArray = harryKane;
        sum = sumArray(tempArray);
        if (sum == 1)
        {
            System.out.println("Harry Kane scored " + sum + " goal.");
        } else {
                System.out.println("Harry Kane scored " + sum + " goals.");
        }
        tempArray = lionelMessi;
        sum = sumArray(tempArray);
        if (sum == 1)
        {
            System.out.println("Lionel Messi scored "+ sum + " goal.");
        } else {
            System.out.println("Lionel Messi scored " + sum + " goals.");
        }
    }

    /*******************************************************************
    *SUBMODULE: averageGoals
    *IMPORT: mohamedSalah, harryKane, lionelMessi
    *EXPORT: none
    *ASSERTION: To run menu choice 2, the average of each player's goals.
    *******************************************************************/
    
    public static void averageGoals(int[] mohamedSalah, int[] harryKane, int[] lionelMessi)
    {
        int[] tempArray = new int[5];
        tempArray = mohamedSalah;
        System.out.println("Mohamed Salah scored an average of " + 
                                   avgArray(tempArray) + " goals per game.");
        tempArray = harryKane;
        System.out.println("Harry Kane scored an average of " + 
                                      avgArray(tempArray) + " goals per game.");
        tempArray = lionelMessi;
        System.out.println("Lionel Messi scored an average of " + 
                                    avgArray(tempArray) + " goals per game.");
    }

    /*******************************************************************
    *SUBMODULE: highestGoals
    *IMPORT: mohamedSalah, harryKane, lionelMessi
    *EXPORT: none
    *ASSERTION: To run menu choice 3, displaying the highest goal scorer.
    *******************************************************************/

    public static void highestGoals(int[] mohamedSalah, int[] harryKane, int[] lionelMessi)
    {
        int[] largestArray = new int[5];
        largestArray = arrayComparison(mohamedSalah, harryKane, lionelMessi);
        String name; 
        name = playerName(largestArray, mohamedSalah, harryKane);
        System.out.println(name + " is the highest goal scorer, with " +
                                        sumArray(largestArray) + " goals.");
    }

    /**********************************************
    *SUBMODULE: sumArray
    *IMPORT: tempArray
    *EXPORT: sum
    *ASSERTION: To calcualte the sum of each array.
    ***********************************************/

    public static int sumArray(int[] tempArray)
    {
        int sum = 0;
        for (int i = 0; i < 5; i++)
        {
            sum += tempArray[i];
        }
        return sum;
    }
    
    /*****************************************************************
    *SUBMODULE: avgArray
    *IMPORT: tempArray
    *EXPORT: average (integer)
    *ASSERTION: To find the average of an array, and return the result
    ******************************************************************/

    public static double avgArray(int[] tempArray)
    {
        int sum = 0;
        double average;
        for (int i = 0; i < 5; i++)
        {
            sum += tempArray[i];
        }
        average = (double)sum / 5.0;
        return average;
    }

    /******************************************************************************
    *SUBMODULE: arrayComparison
    *IMPORT: mohamedSalah, harryKane, lionelMessi)
    *EXPORT: largestArray
    *ASSERTION: To compare 3 arrays, and return the array with the largest sum of variables.
    ******************************************************************************/

    public static int[] arrayComparison(int[] mohamedSalah, int[] harryKane, int[] lionelMessi)
    {
        int array1 = sumArray(mohamedSalah);
        int array2 = sumArray(harryKane);
        int array3 = sumArray(lionelMessi);
        int[] largestArray = new int[5];
        if (array1 > array2 && array1 > array3)
        {
            largestArray = mohamedSalah;
        } else if (array2 > array1 && array2 > array3)
        {
            largestArray = harryKane;
        } else if (array3 > array1 && array3 > array2)
        {
            largestArray = lionelMessi;
        }
        return largestArray;
    }

    /************************************************************************
    *SUBMODULE: playerName
    *IMPORT: largestArray, mohamedSalah, harryKane, lionelMessi
    *EXPORT: name (String)
    *ASSERTION: To compare largestArray with player arrays to determine name.
    *************************************************************************/

    public static String playerName(int[] largestArray, int[] mohamedSalah, int[] harryKane)
    {
        String name;
        if (Arrays.equals(largestArray, mohamedSalah))
        {
            name = "Mohamed Salah";
        } else if (Arrays.equals(largestArray, harryKane))
        {
            name = "Harry Kane";
        } else
        {
            name = "Lionel Messi";
        }
        return name;
    }
}
