/*********************************                                              
 *Author: Samuel Wyatt (20555535)*                                              
 *Date: 10/10/2021               *                                              
 *Purpose: PDI Assignment        *                                              
 *File Name: MainClass.java      *                                              
 *********************************/  

import java.util.*;
import java.lang.*;
import java.io.*;
public class MainClass
{
    public static void main(String[] args)
    {
        display("Log File Output", 0);
        display("*+-*+-*+-*+-*+-*+-*+-*+-*+-*+-*+-*+-*+-*+-*+-*+-*+-*+-*+-", 0);
        //Calculates lineNum for creating caseArray.
        String fileName = "COVID19BE_CASES.csv";
        int lineNum = 0;
        lineNum = lineCount(fileName); 
        
        //Creates CovidCase array and fills it with objects using readCSV. 
        CovidCase[] caseArray = new CovidCase[lineNum];
        caseArray = readCSV(fileName, lineNum); 
        
        //Calls the menuChoice method, which controls all user input and menus.
        menuChoice(caseArray, lineNum);
        display("*+-*+-*+-*+-*+-*+-*+-*+-*+-*+-*+-*+-*+-*+-*+-*+-*+-*+-*+-", 0);

    }

    /*
    SUBMODULE: readCSV
    IMPORT: pFileName (String), lineNum (integer)
    EXPORT: CovidCase (CovidCase[])
    ASSERTION: To read the data file, and return an array containing CovidCase objects.
    */  
    public static CovidCase[] readCSV(String pFileName, int lineNum)
    {
        //Initialise Scanner.
        Scanner sc = new Scanner(System.in); 
        
        //Used to create the objects needed for file input.
        FileInputStream fileStream = null;
        InputStreamReader isr;
        BufferedReader bufRdr;
        String line;
        
        /* An array of CovidCase objects is created, length is variable
        depending of the amount of lines in the file. */
        CovidCase[] caseArray = new CovidCase[lineNum];

        try
        {
            //Initialises the objects needed for file input.
            fileStream = new FileInputStream(pFileName);
            isr = new InputStreamReader(fileStream);
            bufRdr = new BufferedReader(isr);
            
            /*The first line is read, which contains the header information, 
            and then the second line is read, ready to be parsed. */
            line = bufRdr.readLine();
            line = bufRdr.readLine(); 
                                   
            //A loop passes each line to the parseLine method to be parsed.
            for (int i = 0; i < lineNum; i++)
            {
                /*The output of the parseLine method is assigned to each 
                variable of the array. */
                caseArray[i] = parseLine(line, lineNum);
                line = bufRdr.readLine();
            }
            fileStream.close();
        } 
        //Any IO errors are caught
        catch (IOException errorDetails)
        {
            //Checks if the end of the file has been reached
            if (fileStream != null)
            {
                try 
                {
                    fileStream.close();
                }
                catch (IOException ex2)
                { }
            }
            //Prints the error message.
            display("Error in processing file: "+errorDetails.getMessage(), 1);
            display("Exiting Program", 1);
            System.exit(0);
        }
        return caseArray;
    }
    
    /*
    SUBMODULE: lineCount
    IMPORT: pFileName (String)
    EXPORT: lineNum (integer)
    ASSERTION: To count the amount of lines within the csv file.
    */
    public static int lineCount(String pFileName)
    {
        /*Initialises Scanner, the file input objects, line counting objects,
        and the exit variable. */
        Scanner sc = new Scanner(System.in);
        FileInputStream fileStream = null;
        InputStreamReader isr;
        BufferedReader bufRdr;
        int lineNum = 0;
        String line;
        
        try
        {
            fileStream = new FileInputStream(pFileName);
            isr = new InputStreamReader(fileStream);
            bufRdr = new BufferedReader(isr);
            
            /*The first line is read, which contains the header information, 
            and then the second line is read, ready to be parsed. */
            line = bufRdr.readLine();
            line = bufRdr.readLine();

            //Iterates through the file, and keeps a count of the lineNum.
            while (line != null) 
            {
                lineNum++;
                line = bufRdr.readLine();
            }
            fileStream.close();
        //Catches an IO Exception
        } catch (IOException errorDetails)
        {
            if (fileStream != null)
            {
                try 
                {
                    fileStream.close();
                }
                catch (IOException ex2)
                { }
            }
            //Prints the error message.
            display("Error in processing file: "+errorDetails.getMessage(), 1);
            display("Exiting Program", 1);
            System.exit(0);
        }
        return lineNum;
    }
  
    /*
    SUBMODULE: parseLine
    IMPORT: csvLine (String), lineNum (integer)
    EXPORT: newCase (CovidCase)
    ASSERTION: To parse the CSV row into a CovidCase object.
    */
    public static CovidCase parseLine(String csvLine, int lineNum)
    {
        //Splits the line at each comma into elements of an array.
        String[] splitLine;
        splitLine = csvLine.split(",");
       
        //Parse required Strings into integers and assign to variables.
        int dayOfMonth = Integer.parseInt(splitLine[0]);
        int monthOfYear = Integer.parseInt(splitLine[1]);
        int year = Integer.parseInt(splitLine[2]);
        int cases = Integer.parseInt(splitLine[8]);
        
        //Assign Strings to variables.
        String country = splitLine[3];
        String province = splitLine[4];
        String region = splitLine[5];
        String ageGroup = splitLine[6];
        
        //Convert String into char.
        String var7 = splitLine[7];
        char sex = var7.charAt(0);
        
        //Creates Date object using dayOfMonth, monthOfYear and year. 
        Date date = new Date(dayOfMonth, monthOfYear, year);
        
        //Creates new CovidCase object containing the data parsed from the line.
        CovidCase newCase = new CovidCase(date, country, province, region, ageGroup, sex, cases);
        return newCase;
    }

    /*
    SUBMODULE: menuChoice
    IMPORT: caseArray (CovidCase[]), lineNum (integer)
    EXPORT: None
    ASSERTION: To control the menu user input and direction.
    */
    public static void menuChoice(CovidCase[] caseArray, int lineNum)
    {
        boolean exit = false;
        do
        {
        openingMenu();
            try
            {
                //Gets user input.
                Scanner sc = new Scanner(System.in);
                int userInput = Integer.parseInt(sc.nextLine());
                display(userInput + "", 0);
                    switch (userInput)
                    {
                        //Runs method for menu one and two depending on choice.
                        case 1: 
                            menuOne(caseArray, lineNum);
                        break;
                        case 2:
                            menuTwo(caseArray, lineNum);
                        break;
                        //Exits the program
                        case 3:
                        exit = true;
                        display("Goodbye!", 1);
                        break;
                        //Error message for any integer value other than 1,2,3.
                        default:
                            display("Invalid Choice: Please enter a valid " +
                                                "number between 1 and 3", 1);
                        break;
                    }
            //Catch InputMismatchException for incorrect input type.
            } catch (Exception e) 
            {
                display("Error: Invalid Input " + e.getMessage(), 1);
            }
        //Loops the menu until exit is chosen, or correct entry is given.
        } while (exit != true);
    }
    
    /*
    SUBMODULE: openingMenu
    IMPORT: None
    EXPORT: None
    ASSERTION: To print and run the opening menu.
    */
    public static void openingMenu()
    {
        //Prints the initial menu message.
        display("", 1);
        display("Welcome to the COVID-19 Data Analysis Program.", 1);
        display("Make a selection from the menu below regarding the information" +
                                               " you would like to see.", 1);
        display("\nPlease select from the menu below.", 1);
        display("> 1. Statistics of entire nation.", 1);
        display("> 2. Statistics of regions.", 1);
        display("> 3. Exit the program.", 1);
        display("Your choice: ", 2);

    }

    /*
    SUBMODULE: menuOne
    IMPORT: caseArray (CovidCase[]), lineNum (integer)
    EXPORT: None
    ASSERTION: To print, and control, menu choice 1.
    */
    public static void menuOne(CovidCase[] caseArray, int lineNum)
    {
        Scanner sc = new Scanner(System.in);
        int userInput = 0;
        boolean exit = false;
        
        //Loop for menu looping.
        do 
        {
            //Loop for input validation.
            do
            {
            try
            {
                //Prints the entire menu one.
                display("", 1);
                display("Statistics for the entire nation: select from the " + 
                                                              "menu below:", 1);
                display("> 1. Display the total number of COVID-19"+" cases.", 1);
                display("> 2. Display the total number of COVID-19" +
                                                           " cases: Males.", 1);
                display("> 3. Display the total number of COVID-19" +
                                                          " cases: Females", 1);
                display("> 4. Display the total number of COVID-19" +
                                                   " cases: 0-9 age group.", 1);
                display("> 5. Display the total number of COVID-19" +
                                                 " cases: 10-19 age group.", 1);
                display("> 6. Display the total number of COVID-19" +
                                                 " cases: 20-29 age group.", 1);
                display("> 7. Display the total number of COVID-19" +
                                                 " cases: 30-39 age group.", 1);
                display("> 8. Display the total number of COVID-19" +
                                                 " cases: 40-49 age group.", 1);
                display("> 9. Display the total number of COVID-19" +
                                                 " cases: 50-59 age group.", 1);
                display("> 10. Display the total number of COVID-19"+
                                                 " cases: 60-69 age group.", 1);
                display("> 11. Display the total number of COVID-19"+
                                                 " cases: 70-79 age group.", 1);
                display("> 12. Display the total number of COVID-19"+
                                                 " cases: 80-89 age group.", 1);
                display("> 13. Display the total number of COVID-19"+
                                                   " cases: 90+ age group.", 1);
                display("Your choice: ", 2);
                userInput = Integer.parseInt(sc.nextLine());
                display(userInput + "", 0);
                /*Checks if userInput is between accepted values, error message
                if not. */
                if (userInput < 1 || userInput > 13)
                {
                    display("Invalid Choice: Please enter a valid number " +
                                                        "between 1 and 13.", 1);
                    exit = false;
                } else {
                    //Allows the program to leave the validation loop for input.
                    exit = true;
                }
            //Catches InputMismatchException for incorrect input type.
            } catch (Exception e2) {
                display("Error: Invalid Input " + e2.getMessage(), 1);
            }
            } while (exit != true);
            //Calls the method to calculate data based on user input.
            nationCases(userInput, caseArray, lineNum);

            /*Once data has been calculated and displayed, calls the yesNoChoice
            method, which asks the user if they would like to choose another option */
            exit = yesNoChoice();
        //Loop exits if exit is true.
        } while (exit != true);
    }
  
    /*
    SUBMODULE: menuTwo
    IMPORT: caseArray (CovidCase[], lineNum)
    EXPORT: None
    ASSERTION: To print, and control, menu choice 2.
    */
    public static void menuTwo(CovidCase[] caseArray, int lineNum)
    {
        Scanner sc = new Scanner(System.in);
        int userInput = 0;
        boolean exit = false;
        //Loop for menu looping.
        do 
        {
            //Loop for input validation.
            do
            {
            try
            {   
                //Prints out the entire menu two.
                display("", 1);
                display("Statistics by Region: select from the menu below:", 1);
                display("Which region would you like statistics for?", 1);
                display("> 1. Flanders.", 1);
                display("> 2. Brussels.", 1);
                display("> 3. Wallonia.", 1);
                display("> 4. Unknown.", 1);
                display("Your choice: ", 2);
                userInput = Integer.parseInt(sc.nextLine());
                display(userInput + "", 0);
                //Checks if userInput is an accepted value.
                if (userInput < 1 || userInput > 4)
                {
                    display("Invalid Choice: Please enter a valid number " +
                                                         "between 1 and 4.", 1);
                    exit = false;
                } else {
                    //Allows the program to exit the input validation loop.
                    exit = true;
                }
            //Catches InputMismatchException.
            } catch (Exception e3) {
                display("Error: Invalid Input " + e3.getMessage(), 1);
            }
            } while (exit != true);
            //Calculates statistics for the region selected.
            regionCases(userInput, caseArray, lineNum);
           
            //Calls yesNoChoice method, exits the loop if true.
            exit = yesNoChoice();
        } while (exit != true);        
    }

    /*
    SUBMODULE: nationCases
    IMPORT: userInput (integer), caseArray (CovidCase[]), lineNum (integer)
    EXPORT: None
    ASSERTION: Calculate the nationwide statistics.
    */
    public static void nationCases(int userInput, CovidCase[] caseArray, int lineNum)
    {
        //Calls a statistic calculation method based on userInput.
        switch (userInput)
        {
            /*Each method requires the caseArray, lineNum (to increase speed by
            reducing amount of file IO), and the indicator of which menu the 
            request is coming from. */
            
            //0 means that the statistics are being calculated for the whole country.

            case 1:
            totalCases(caseArray, lineNum, 0);
            break;
            case 2:
            sexCases(caseArray, lineNum, 0, 'M', " male ");        
            break;
            case 3:
            sexCases(caseArray, lineNum, 0, 'F', " female ");
            break;
            case 4:
            ageCases(caseArray, lineNum, 0, "0-9");
            break;
            case 5:
            ageCases(caseArray, lineNum, 0, "10-19");
            break;
            case 6:
            ageCases(caseArray, lineNum, 0, "20-29");
            break;
            case 7:
            ageCases(caseArray, lineNum, 0, "30-39");
            break;
            case 8:
            ageCases(caseArray, lineNum, 0, "40-49");
            break;
            case 9:
            ageCases(caseArray, lineNum, 0, "50-59");
            break;
            case 10:
            ageCases(caseArray, lineNum, 0, "60-69");
            break;
            case 11:
            ageCases(caseArray, lineNum, 0, "70-79");
            break;
            case 12:
            ageCases(caseArray, lineNum, 0, "80-89");
            break;
            case 13:
            ageCases(caseArray, lineNum, 0, "90+");
            break;
        }
    }

    /*
    SUBMODULE: regionCases
    IMPORT: userInput (integer), caseArray (CovidCase[]), lineNum (integer)
    EXPORT: None
    ASSERTION: Calculate the regionwide statistics.
    */
    public static void regionCases(int userInput, CovidCase[] caseArray, int lineNum)
    {
        /*Selects a case depending on user input, which calls all of the statistics
        methods, and uses the integer calcType to determine which region is 
        being calculated. */
            display("", 1);
            totalCases(caseArray, lineNum, userInput);
            sexCases(caseArray, lineNum, userInput, 'M', " male ");        
            sexCases(caseArray, lineNum, userInput, 'F', " female ");
            ageCases(caseArray, lineNum, userInput, "0-9");
            ageCases(caseArray, lineNum, userInput, "10-19");
            ageCases(caseArray, lineNum, userInput, "20-29");
            ageCases(caseArray, lineNum, userInput, "30-39");
            ageCases(caseArray, lineNum, userInput, "40-49");
            ageCases(caseArray, lineNum, userInput, "50-59");
            ageCases(caseArray, lineNum, userInput, "60-69");
            ageCases(caseArray, lineNum, userInput, "70-79");
            ageCases(caseArray, lineNum, userInput, "80-89");
            ageCases(caseArray, lineNum, userInput, "90+");
    }

    /*
    SUBMODULE: yesNoChoice
    IMPORT: None
    EXPORT: (boolean)
    ASSERTION: To decide whether the menu will loop, based on user input.
    */ 
    public static boolean yesNoChoice()
    {
        Scanner sc = new Scanner(System.in);
        char userInput;
        boolean exit = true;
        //Loop for input validation.
        do
        {
            //Prints message to user
            display("", 1);
            display("Would you like to make another selection? (Y or N)? ", 2);
            //Gets the character from user input.
            userInput = sc.next().charAt(0);
            display(userInput + "", 0);
            /*If the user would like to make another selection false is returned. */
            if ((userInput == 'y') || (userInput == 'Y'))
            {
                return false;
            /*If the user would not like to make another selection true is returned. */
            } else if ((userInput == 'n') || (userInput == 'N')) {
                return true;
            /*If userInput is an invalid character, the user is prompted to 
            re-enter, and the loop is not exited. */
            } else {
                display("Invalid Choice, Please enter a valid character.", 1);
                exit = false;
            } 
        } while (exit != true);
        return true;
    }
     
    /*
    SUBMODULE: totalCases
    IMPORT: caseArray (CovidCase[]), lineNum (integer), calcType (integer)
    EXPORT: None
    ASSERTION: To determine the total number of cases.
    */
    public static void totalCases(CovidCase[] caseArray, int lineNum, int  calcType)
    {
        //calcType 0 is for calculating total covid cases regardless of region.
        if (calcType == 0)
        {
            int totalCases = 0;
            
            for (int i = 0; i < lineNum; i++)
            { 
                //A new CovidCase object is created from an element of the array.
                CovidCase newCase = new CovidCase(caseArray[i]);           

                //Using the getCases() method, the amount of cases are recorded.
                totalCases = totalCases + newCase.getCases();
            }
        display("Total number of cases: " + totalCases, 1);    
        
        //calcType 1 is for calculating total covid cases for Flanders.
        } else if (calcType == 1)
        {
            int flanCases = 0;
            for (int i = 0; i < lineNum; i++)
            {                    
                /*New CovidCase object is created, and test if equal to Flanders
                using getRegion() and .equals(). */
                CovidCase newCase = new CovidCase(caseArray[i]);           
                if (newCase.getRegion().equals("Flanders"))
                {
                    //If true, the amount of cases is recorded.
                    flanCases = flanCases + newCase.getCases();
                }
            }
            display("Total number of COVID-19 cases for Flanders is: " +
                                                                  flanCases, 1);
        //calcType 2 is for calculating total number of cases for Brussles.
        } else if (calcType == 2)
        {
            int brusCases = 0;
            for (int i = 0; i < lineNum; i++)
            {                    
                CovidCase newCase = new CovidCase(caseArray[i]);           
                if (newCase.getRegion().equals("Brussels"))
                {
                    brusCases = brusCases + newCase.getCases();
                }
            }
            display("Total number of COVID-19 cases for Brussels is: " + 
                                                                  brusCases, 1);
        //calcType 3 is for calculating the total number of cases for Wallonia.
        } else if (calcType == 3)
        {
            int wallCases = 0;
            for (int i = 0; i < lineNum; i++)
            {                    
                CovidCase newCase = new CovidCase(caseArray[i]);           
                if (newCase.getRegion().equals("Wallonia"))
                {
                    wallCases = wallCases + newCase.getCases();
                }
            }
            display("Total number of COVID-19 cases for Wallonia is : " + 
                                                                  wallCases, 1);    
        //calcType 4 is for calculating the total number of cases for unknown.
        } else if (calcType == 4)
        {
            int unknCases = 0;
            for (int i = 0; i < lineNum; i++)
            {                    
                CovidCase newCase = new CovidCase(caseArray[i]);           

                /*If region of the new CovidCase object is NOT equal to all
                three other regions, the total is calculated. */
                if (!(newCase.getRegion().equals("Flanders")) && 
                    !(newCase.getRegion().equals("Brussles")) && 
                    !(newCase.getRegion().equals("Wallonia")))
                {
                    unknCases = unknCases + newCase.getCases();
                }
            }
            display("Total number of COVID-19 cases for all unknown regions " +
                                                           "is: "+unknCases, 1);
        }
    }
    
    /*
    SUBMODULE: sexCases
    IMPORT: caseArray (CovidCase[]), lineNum (integer), calcType (integer), 
                                                sex (char), gender (String)
    EXPORT: None
    ASSERTION: To determine the number of cases for males or females.
    */
    public static void sexCases(CovidCase[] caseArray, int lineNum, int calcType, char sex, String gender)
    {
        //calcType 0 is for calculating total gendered covid cases regardless of region.
        if (calcType == 0)
        {
            int totalCases = 0;
            for (int i = 0; i < lineNum; i++)
            {
                CovidCase newCase = new CovidCase(caseArray[i]);
                
                /*Using getSex(), the value of the sex is compared with the 
                provided char, either 'F' or 'M' depending on which is being calculated. */
                if (newCase.getSex() == sex)
                {
                    //All cases are added to the total.
                    totalCases = totalCases + newCase.getCases();
                }
            }
            //Total is printed.
            display("Total number of"+gender+ "cases: "+ totalCases, 1);
        //Calculates number of gendered cases for Flanders.
        } else if (calcType == 1)
        {
            int flanCases = 0;
            for (int i = 0; i < lineNum; i++)
            {                    
                CovidCase newCase = new CovidCase(caseArray[i]); 
                //First checks if region is equal to "Flanders".
                if (newCase.getRegion().equals("Flanders"))
                {
                    //Then checks if sex equals the imported char value.
                    if (newCase.getSex() == sex)
                    {
                        flanCases = flanCases + newCase.getCases();
                    }
                }
            }
            display("Total number of COVID-19" + gender +"cases for Flanders " +
                                                         "is: " + flanCases, 1);
        //Calculates the number of gendered cases for Brussels.
        } else if (calcType == 2)
        {
            int brusCases = 0;
            for (int i = 0; i < lineNum; i++)
            {                    
                CovidCase newCase = new CovidCase(caseArray[i]);
                //First checks if region is equal to "Flanders".
                if (newCase.getRegion().equals("Brussels"))
                {
                    //Then checks if sex equals the imported char value.
                    if (newCase.getSex() == sex)
                    {
                        brusCases = brusCases + newCase.getCases();
                    }
                }
            }
            display("Total number of COVID-19" + gender + "cases for Brussels" +
                                                        " is: " + brusCases, 1);

        } else if (calcType == 3)
        {
            int wallCases = 0;
            for (int i = 0; i < lineNum; i++)
            {                    
                CovidCase newCase = new CovidCase(caseArray[i]);           
                //Calculates the number of gendered cases for Wallonia.
                if (newCase.getRegion().equals("Wallonia"))
                {
                    //Then checks if sex equals the imported char value.
                    if (newCase.getSex() == sex)
                    {
                        wallCases = wallCases + newCase.getCases();
                    }
                }
            }
            display("Total number of COVID-19" +gender+"cases for Wallonia " + 
                                                        "is : " + wallCases, 1);    
        } else if (calcType == 4)
        {
            int unknCases = 0;
            for (int i = 0; i < lineNum; i++)
            {                    
                CovidCase newCase = new CovidCase(caseArray[i]);           
                /*Checks if region !equals "Flanders", "Brussels" and "Wallonia". */
                if (!(newCase.getRegion().equals("Flanders")) && 
                    !(newCase.getRegion().equals("Brussels")) && 
                    !(newCase.getRegion().equals("Wallonia")))
                {
                    //Then checks if sex equals the imported char value.
                    if (newCase.getSex() == sex)
                    {
                        unknCases = unknCases + newCase.getCases();
                    }
                }
            }
            display("Total number of COVID-19" +gender+ "cases for all unknown"+ 
                                                " regions is: " + unknCases, 1);
        }
 
    }

    /*
    SUBMODULE: ageCases 
    IMPORT: caseArray (CovidCase[]), lineNum (integer), calcType (integer), age (String)
    EXPORT: None
    ASSERTION: To determine the number of cases for a certain age range.
    */
    public static void ageCases(CovidCase[] caseArray, int lineNum, int calcType, String age)
    {
        //calcType 0 is for total cases for specific age groups (menu one).
        if (calcType == 0)
        {
            int totalCases = 0;
            for (int i = 0; i < lineNum; i++)
            {
                CovidCase newCase = new CovidCase(caseArray[i]);
                //Checks if age equals the imported age String.
                if (newCase.getAgeGroup().equals(age))
                { 
                    totalCases = totalCases + newCase.getCases();
                }
            }
        display("Total number of cases for "+age+ " : " +totalCases, 1);
        } else if (calcType == 1)
        {
            int flanCases = 0;
            for (int i = 0; i < lineNum; i++)
            {                    
                CovidCase newCase = new CovidCase(caseArray[i]);           
                //Checks if region equals "Flanders".
                if (newCase.getRegion().equals("Flanders"))
                {
                    //Checks if age equals the imported age String.
                    if (newCase.getAgeGroup().equals(age))
                    {
                        flanCases = flanCases + newCase.getCases();
                    }
                }
            }
            display("Total number of COVID-19 cases in " + age + " age group " +
                                            "for Flanders is: " + flanCases, 1);
        } else if (calcType == 2)
        {
            int brusCases = 0;
            for (int i = 0; i < lineNum; i++)
            {                    
                CovidCase newCase = new CovidCase(caseArray[i]);         
                //Checks if region equals "Brussels".
                if (newCase.getRegion().equals("Brussels"))
                {
                    //Checks if age equals the imported age String. 
                    if (newCase.getAgeGroup().equals(age))
                    {
                        brusCases = brusCases + newCase.getCases();
                    }
                }
            }
            display("Total number of COVID-19 cases in " + age + " age group " +
                                            "for Brussels is: " + brusCases, 1);

        } else if (calcType == 3)
        {
            int wallCases = 0;
            for (int i = 0; i < lineNum; i++)
            {                    
                CovidCase newCase = new CovidCase(caseArray[i]);        
                //Checks if region equals "Wallonia".
                if (newCase.getRegion().equals("Wallonia"))
                {
                    //Checks if age equals the imported age String.
                    if (newCase.getAgeGroup().equals(age))
                    {
                        wallCases = wallCases + newCase.getCases();
                    }
                }
            }
            display("Total number of COVID-19 cases in " + age + " age group " +
                                            "for Wallonia is: " + wallCases, 1);    
        } else if (calcType == 4)
        {
            int unknCases = 0;
            for (int i = 0; i < lineNum; i++)
            {                    
                CovidCase newCase = new CovidCase(caseArray[i]);           
                //Checks if the region !equals any of the three previous.
                if (!(newCase.getRegion().equals("Flanders")) && 
                    !(newCase.getRegion().equals("Brussels")) && 
                    !(newCase.getRegion().equals("Wallonia")))
                {
                    //Checks if age equals the imported age String.
                    if (newCase.getAgeGroup().equals(age))
                    {
                        unknCases = unknCases + newCase.getCases();
                    }
                }
            }
            display("Total number of COVID-19 cases in " + age + " age group " +
                                      "for unknown regions is: "+ unknCases, 1);
        }
    }
    
    /*
    SUBMODULE: display
    IMPORT: line (String), println (integer)
    EXPORT: None
    ASSERTION: To take a String of text, and print it to both the command line
                as well as a logFile.
    */
    public static void display(String line, int println)
    {
    //println == 0 for log file only.
    //println == 1 for println.
    //println == 2 for print.
        try
        {
            //println == 1 uses System.out.println in the terminal.
            if (println == 1) 
            {
                System.out.println(line);
              //println == 2 uses System.out.print in the terminal.  
            } else if (println == 2)
            {
                System.out.print(line);
            }
            //Creating the log file and the necessary objects.
            
            /*true in the FileWriter means that the location in the file is 
            appended, so it isn't overwritten. */

            FileWriter fw = new FileWriter("logFile.txt", true); 
            BufferedWriter bw = new BufferedWriter(fw);             
            //Writes a line to the log file.
            bw.write(line);
            //Adds a new line in the log file if println == 0 or 1. 
            if (println == 0 || println == 1)
            {
                bw.newLine();
            } 
            bw.close();
        //IOException caught for any errors in file processing.
        } catch (IOException e)
        {
            System.out.println("Error in File Processing: " + e.getMessage());
        }
    }
}
