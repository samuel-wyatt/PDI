/*********************************                                              
 *Author: Samuel Wyatt (20555535)*                                              
 *Date: 10/10/2021               *                                              
 *Purpose: PDI Assignment        *                                              
 *File Name: Date.java           *                                              
 *********************************/  

import java.util.*;
public class Date
{
    private int dayOfMonth;
    private int monthOfYear;
    private int year;

    /*
    SUBMODULE: Date (Constructor with parameters)
    IMPORT: pDayOfMonth (integer), pMonthOfYear (integer), pYear (integer)
    EXPORT: None
    ASSERTION: To create a Date object with given class fields.
    */
    public Date(int pDayOfMonth, int pMonthOfYear, int pYear)
    {
        //Checks if the provided values are valid, then creates the object.
        if (isValid(pDayOfMonth, pMonthOfYear, pYear))
        {
            dayOfMonth = pDayOfMonth;
            monthOfYear = pMonthOfYear;
            year = pYear;
        //Invalid values result in a 00/00/0000 date.
        } else {
            dayOfMonth = 0;
            monthOfYear = 0;
            year = 0000;
        }
    }
    
    
    /* 
    SUBMODULE: Date (Copy Constructor)
    IMPORT: pDate (Date)
    EXPORT: None
    ASSERTION: To create a copy of a Date object.
    */
    public Date(Date pDate)
    {
        //Copies one object's values onto another.
        dayOfMonth = pDate.getDayOfMonth();
        monthOfYear = pDate.getMonthOfYear();
        year = pDate.getYear();
    }
    
    /*
    SUBMODULE: Date (Default Constructor)
    IMPORT: None
    EXPORT: None
    ASSERTION: To create a Date object with default values.
    */
    public Date()
    {
        //Creates a default date of 01/01/2021.
        dayOfMonth = 1;
        monthOfYear = 1;
        year = 2021;
    }
    
    /*
    SUBMODULE: getDayOfMonth
    IMPORT: None
    EXPORT: dayOfMonth (integer)
    ASSERTION: To return the value of dayOfMonth.
    */ 
    public int getDayOfMonth()
    {
        return this.dayOfMonth;
    }
    
    /*
    SUBMODULE: getMonthOfYear
    IMPORT: None
    EXPORT: monthOfYear (integer)
    ASSERTION: To return the value of monthOfYear.
    */
    public int getMonthOfYear()
    {
        return this.monthOfYear;
    }

    /*
    SUBMODULE: getYear
    IMPORT: None
    EXPORT: year (integer)
    ASSERTION: To return the value of year.
    */
    public int getYear()
    {
        return this.year;
    }

    /*
    SUBMODULE: toString
    IMPORT: None
    EXPORT: date (String)
    ASSERTION: To create a string containing the date in dd/mm/yyyy format.
    */
    public String toString()
    {
        //String named date is created.
        String date;
        
        /*Creates a string in dd/mm/yyyy format, determining if dayOfMonth and 
        monthOfYear are single or double digits, so that zeroes can be placed
        correctly. */
        if (dayOfMonth < 10 && monthOfYear < 10) 
        {
            date = "0" + dayOfMonth + "/0" + monthOfYear + "/" + year;
        } 
        else if (dayOfMonth < 10 && monthOfYear > 9) 
        {
            date  = "0" + dayOfMonth + "/" + monthOfYear + "/" + year;
        } 
        else if (dayOfMonth > 9 && monthOfYear < 10)
        {
            date = dayOfMonth + "/0" + monthOfYear + "/" + year;
        } 
        else
        {
            date = dayOfMonth + "/" + monthOfYear + "/" + year;
        }
        return date;
    }
    /*
    SUBMODULE: isValid
    IMPORT: dayOfMonth (integer), monthOfYear (integer), year (integer)
    EXPORT: (boolean)
    ASSERTION: To check if Date is valid.
    */
    public boolean isValid(int dayOfMonth, int monthOfYear, int year)
    {
        //Checks if year is between 'reasonable' bounds.
        if (year < 1000 || year > 2999) 
        {
            return false;
        }
        //Checks if monthOfYear is between 1 and 12 inclusive.
        if ((monthOfYear < 1) || (monthOfYear > 12))
        {
            return false;
        }
        //Checks if dayOfMonth is between 1 and 31 inclusive.
        if ((dayOfMonth < 1) || (dayOfMonth > 31))
        {
            return false;
        }
        /*Determines whether dayOfMonth is valid depending on how many days in
        each month. */
        switch (monthOfYear)
        {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return true;
            case 4: case 6: case 9: case 11:
                if (dayOfMonth < 31)
                {
                    return true;
                } else {
                    return false;
                }
            /*Checks if year was a leap year using isLeap(). If yes,dayOfMonth 
            29 is a valid value. */
            case 2: 
                boolean leap = isLeap(year);
                if (leap == true)
                {
                    if (dayOfMonth <= 29)
                    {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    if (dayOfMonth <= 28)
                    {
                        return true;
                    } else {
                        return false;
                    }
                }
        }
        return true;
    }

    /*
    SUBMODULE: isLeap
    IMPORT: year (integer)
    EXPORT: leap (boolean)
    ASSERTION: To determine whether a certain year is a leap year or not.
    */
    public boolean isLeap(int year)
    {
        //Runs through algorithim to determine if a year is a leap year or not.
        boolean leap = false;
        if (year % 4 == 0)
        {
            if (year % 100 == 0)
            {
                if (year % 400 == 0)
                {
                    leap = true;
                } else  {
                    leap = false;
                }
            } else {
                leap = true;
            }
        } else {
            leap = false;
        }
    //Returns a true or false boolean.
    return leap;
    }
}
