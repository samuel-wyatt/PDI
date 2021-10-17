/*********************************
 *Author: Samuel Wyatt (20555535)*
 *Date: 10/10/2021               *
 *Purpose: PDI Assignment        *
 *File Name: CovidCase.java      *
 *********************************/

public class CovidCase
{
    private String country, province, region, ageGroup;
    private int cases;
    private char sex;
    private Date date;

    /*
    SUBMODULE: CovidCase (Constructor with parameters)
    IMPORT: pDate (Date), pCountry (String), pProvince (String), pRegion (String), 
                               pAgeGroup (String), pSex (char), pCases (integer)
    EXPORT: None
    ASSERTION: To create a CovidCase object using given variables.
    */
    public CovidCase(Date pDate,String pCountry,String pProvince,String pRegion,String pAgeGroup,char pSex,int pCases)
    {
        date = pDate;
        country = pCountry;
        province = pProvince;
        region = pRegion;
        ageGroup = pAgeGroup;
        sex = pSex;
        cases = pCases;
    }
    
    /*
    SUBMODULE: CovidCase (Copy Constructor)
    IMPORT: pCovidCase (CovidCase)
    EXPORT: None
    ASSERTION: To create a copy of a CovidCase object.
    */
    public CovidCase(CovidCase pCovidCase)
    {
        date = pCovidCase.getDate();
        country = pCovidCase.getCountry();
        province = pCovidCase.getProvince();
        region = pCovidCase.getRegion();
        ageGroup = pCovidCase.getAgeGroup();
        sex = pCovidCase.getSex();
        cases = pCovidCase.getCases();
    }

    /*
    SUBMODULE: CovidCase (Default Constructor)
    IMPORT: None
    EXPORT: None
    ASSERTION: To create a CovidCase object with default values.
    */
    public CovidCase()
    {
        Date date = new Date();
        country = "Belgium";
        province = "NA";
        region = "NA";
        ageGroup = "NA";
        sex = 'N';
        cases = 0;
    }

    /*
    SUBMODULE: getDate
    IMPORT: None
    EXPORT: date (Date)
    ASSERTION: To return the object date.
    */
    public Date getDate()
    {
        return this.date;
    }

    /*
    SUBMODULE: getCountry
    IMPORT: None
    EXPORT: country (String)
    ASSERTION: To return the value of country.
    */
    public String getCountry()
    {
        return this.country;
    }
   
    /*
    SUBMODULE: getProvince
    IMPORT: None
    EXPORT: Province (String)
    ASSERTION: To return the value of province.
    */
    public String getProvince()
    {
        return this.province;
    } 
    
    /*
    SUBMODULE: getRegion
    IMPORT: None
    EXPORT: region (String)
    ASSERTION: To return the value of region.
    */
    public String getRegion()
    {
        return this.region;
    }

    /*
    SUBMODULE: getAgeGroup
    IMPORT: None
    EXPORT: ageGroup (String)
    ASSERTION: To return the value of ageGroup.
    */
    public String getAgeGroup()
    {
        return this.ageGroup;
    }

    /*
    SUBMODULE: getSex
    IMPORT: None
    EXPORT: sex (char)
    ASSERTION: To return the value of sex.
    */
    public char getSex()
    {
        return this.sex;
    }

    /*
    SUBMODULE: getCases
    IMPORT: None
    EXPORT: cases (integer)
    ASSERTION: To return the value of cases.
    */
    public int getCases()
    {
        return this.cases;
    }

    /*
    SUBMODULE: toString
    IMPORT: None 
    EXPORT: covCase (String) 
    ASSERTION: To create a string expressing the CovidCase object.
    */
    public String toString()
    {
        String covCase =date+" "+country+" "+province+" "+region+" "+ageGroup+
                                                              " "+sex+" "+cases;
        return covCase;
    }
}
