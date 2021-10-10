public class Date
{
    private int dayOfMonth;
    private int monthOfYear;
    private int year;

    /*
    SUBMODULE: Date
    IMPORT: pDayOfMonth (integer), pMonthOfYear (integer), pYear (integer)
    EXPORT: None
    ASSERTION: To create a Date object with given class fields.
    */
    public Date(int pDayOfMonth, int pMonthOfYear, int pYear)
    {
        
        dayOfMonth = pDayOfMonth;
        monthOfYear = pMonthOfYear;
        year = pYear;
        if ((isValid(dayOfMonth, monthOfYear, year)) == false)
        {
            System.out.println("Invalid Date!");
        } 
    }
    
    /* 
    SUBMODULE: Date
    IMPORT: pDate (Date)
    EXPORT: None
    ASSERTION: To create a copy of a Date object.
    */
    public Date(Date pDate)
    {
        dayOfMonth = pDate.getDayOfMonth();
        monthOfYear = pDate.getMonthOfYear();
        year = pDate.getYear();
    }
    
    /*
    SUBMODULE: getDayOfMonth
    IMPORT: pDayOfMonth (integer)
    EXPORT: dayOfMonth (integer)
    ASSERTION: To return the value of dayOfMonth.
    */ 
    public int getDayOfMonth()
    {
        return this.dayOfMonth;
    }
    
    /*
    SUBMODULE: getMonthOfYear
    IMPORT: pMonthOfYear (integer)
    EXPORT: monthOfYear (integer)
    ASSERTION: To return the value of monthOfYear.
    */
    public int getMonthOfYear()
    {
        return this.monthOfYear;
    }

    /*
    SUBMODULE: getYear
    IMPORT: pYear (integer)
    EXPORT: year (integer)
    ASSERTION: To return the value of year.
    */
    public int getYear()
    {
        return this.year;
    }

    /*
    SUBMODULE: toString
    IMPORT: dayOfMonth (integer), monthOfYear (integer), year (integer)
    EXPORT: dateString
    ASSERTION: To create a string containing the date in dd/mm/yyyy format.
    */
    public String toString()
    {
        String date;
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
    IMPORT: day (integer), month (integer), year (integer)
    EXPORT: None
    ASSERTION: To check if Date is valid.
    */
    public boolean isValid(int dayOfMonth, int monthOfYear, int year)
    {
        if (year < 1000 || year > 2999) 
        {
            return false;
        }
        
        if ((monthOfYear < 1) || (monthOfYear > 12))
        {
            return false;
        }
        
        if ((dayOfMonth < 1) || (dayOfMonth > 31))
        {
            return false;
        }

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
    return leap;
    }
}
