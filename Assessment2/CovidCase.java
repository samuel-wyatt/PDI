public class CovidCase
{
    private String Country, Province, Region, AgeGroup;
    private int Cases;
    private char Sex;
    private Date date;

    /*
    SUBMODULE: CovidCase
    IMPORT: pDate (Date), pCountry (String), pProvince (String), pRegion (String), 
            pAgeGroup (String), pSex (char), pCases (integer), 
    EXPORT: None
    ASSERTION: To create a CovidCase object using given variables.
    */
    public CovidCase(Date pDate, String pCountry, String pProvince, String pRegion, String pAgeGroup, char pSex, int pCases)
    {
        date = pDate;
        Country = pCountry;
        Province = pProvince;
        Region = pRegion;
        AgeGroup = pAgeGroup;
        Sex = pSex;
        Cases = pCases;
    }
}
