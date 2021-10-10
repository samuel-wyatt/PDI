import java.util.*;
import java.lang.*;
import java.io.*;
public class MainClass
{
    public static void main(String[] args)
    {
        readCSV("COVID19BE_CASES_TESTDATA.csv");
        openingMenu();
        menuChoice();
    }

    /*
    SUBMODULE: readCSV
    IMPORT: None
    EXPORT: CovidCase (CovidCase[])
    ASSERTION: To read the data file, and return an array containing CovidCase objects.
    */  
    public static CovidCase[] readCSV(String pFileName);
    {
        int lineNum = 0;
        String line;
        FileInputStream fileStream = null;
        InputStreamReader isr;
        BufferedReader bufRdr;
        try
        {
            fileStream = new FileInputStream(pFileName);
            isr = new InputStreamReader(fileStream);
            bufRdr = new BufferedReader(isr);
            line = bufRdr.readLine();
            while (line != null)
            {
                lineNum++;
                line = bufRdr.readLine();
            }
            fileStream.close();
        } 
        catch (IOException e) 
        {
            if (fileStream != null)
            {
                try 
                {
                    fileStream.close();
                } 
                catch (IOException ex2)
                { 
                }
            }
            System.out.println("Error in fileProcessing: " + e.getMessage());
        
        }
    }
                

    /*
    SUBMODULE: openingMenu
    IMPORT: None
    EXPORT: None
    ASSERTION: To print and run the opening menu, and coordinate the loop.
    */
    public static void openingMenu()
    {
        
        System.out.println("\nWelcome to the COVID-19 Data Analysis Program.");
        System.out.println("Make a selection from the menu below regarding" + 
                                     " the information you would like to see.");
        System.out.println("\nPlease select from the menu below.");
        System.out.println("> 1. Statistics of entire nation.");
        System.out.println("> 2. Statistics of regions.");
        System.out.println("> 3. Exit the program.");
        System.out.print("Your choice: ");

    }
   
    /*
    SUBMODULE: menuChoice
    IMPORT: None
    EXPORT: None
    ASSERTION: To control the menu user input and direction.
    */
    public static void menuChoice()
    {
        Scanner sc = new Scanner(System.in);
        int userInput = Integer.parseInt(sc.nextLine());
        do
        {
            switch (userInput)
            {
                case 1: 
                    System.out.println();
                    menuOne();
                    openingMenu();
                    userInput = Integer.parseInt(sc.nextLine());
                break;
                case 2:
                    System.out.println();
                    menuTwo();
                    openingMenu();
                    userInput = Integer.parseInt(sc.nextLine());
                break;
                case 3:
                break;
                default:
                    System.out.print("Invalid Choice, Please enter a valid" + 
                                                     " number between 1 and 3");
                break;
            }
        } while (userInput != 3);
        System.out.println("Goodbye!");
    }

    /*
    SUBMODULE: menuOne
    IMPORT: None
    EXPORT: None
    ASSERTION: To print, and control, menu choice 1.
    */
    public static void menuOne()
    {
        Scanner sc = new Scanner(System.in);
        int userInput;
        boolean exit = false;
        do 
        {
            System.out.println();
            System.out.println("Statistics for the entire nation: select from the" +
                                                                " menu below:");
            System.out.println("> 1. Display the total number of COVID-19 cases.");
            System.out.println("> 2. Display the total number of COVID-19 cases: Males.");
            System.out.println("> 3. Display the total number of COVID-19 cases: Females");
            System.out.println("> 4. Display the total number of COVID-19 cases: 0-9 age group.");
            System.out.println("> 5. Display the total number of COVID-19 cases: 10-19 age group.");
            System.out.println("> 6. Display the total number of COVID-19 cases: 20-29 age group.");
            System.out.println("> 7. Display the total number of COVID-19 cases: 30-39 age group.");
            System.out.println("> 8. Display the total number of COVID-19 cases: 40-49 age group.");
            System.out.println("> 9. Display the total number of COVID-19 cases: 50-59 age group.");
            System.out.println("> 10. Display the total number of COVID-19 cases: 60-69 age group.");
            System.out.println("> 11. Display the total number of COVID-19 cases: 70-79 age group.");
            System.out.println("> 12. Display the total number of COVID-19 cases: 80-89 age group.");
            System.out.println("> 13. Display the total number of COVID-19 cases: 90+ age group.");
            System.out.print("Your choice: ");
            userInput = Integer.parseInt(sc.nextLine());
            //nationCases(userInput);
            exit = yesNoChoice();
        } while (exit != true);
    }
  
    /*
    SUBMODULE: menuTwo
    IMPORT: None
    EXPORT: None
    ASSERTION: To print, and control, menu choice 2.
    */
    public static void menuTwo()
    {
        Scanner sc = new Scanner(System.in);
        int userInput;
        boolean exit = false;
        do 
        {
            System.out.println("Statistics by Region: select from the menu below:");
            System.out.println("Which region would you like statistics for?");
            System.out.println("> 1. Flanders.");
            System.out.println("> 2. Brussels.");
            System.out.println("> 3. Wallonia.");
            System.out.println("> 4. Unknown.");
            System.out.println("Your choice: ");
            userInput = Integer.parseInt(sc.nextLine());
            //regionCases(userInput);
            exit = yesNoChoice();
        } while (exit != true);        
    }

    /*
    SUBMODULE: nationCases
    IMPORT: userInput (integer)
    EXPORT: None
    ASSERTION: Calculate the nationwide statistics.
    */
    //public static void nationCases(userInput)
    {

    }

    /*
    SUBMODULE: regionCases
    IMPORT: userInput (integer)
    EXPORT: None
    ASSERTION: Calculate the regionwide statistics.
    */
    //public static void regionCases(userInput)
    {

    }

    /*
    SUBMODULE: yesNoChoice
    IMPORT: None
    EXPORT: exit (boolean)
    ASSERTION: To decide whether the menu will loop, based on user input.
    */
    public static boolean yesNoChoice()
    {
        Scanner sc = new Scanner(System.in);
        char userInput;
        boolean loop = false;
        do
        {
            System.out.print("Would you like to make another selection? (Y or N)? ");
            userInput = sc.next().charAt(0);
            if ((userInput == 'y') || (userInput == 'Y'))
            {
                loop = false;
                return false;
            } else if ((userInput == 'n') || (userInput == 'N')) {
                loop = false;
                return true;
            } else {
                System.out.println("Invalid Choice, Please enter a valid character.");
                loop = true;
            } 
        } while (loop != false);
        return true;
    }
}
