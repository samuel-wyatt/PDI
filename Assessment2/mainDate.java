import java.util.*;
public class mainDate
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int pDayOfMonth, pMonthOfYear, pYear;
        System.out.print("Please enter the day: ");
        pDayOfMonth = sc.nextInt();
        System.out.print("Please enter the month: ");
        pMonthOfYear = sc.nextInt();
        System.out.print("Please enter the year: ");
        pYear = sc.nextInt();
        Date date1 = new Date(pDayOfMonth, pMonthOfYear, pYear);
        //System.out.println(date1.toString());
    }
}
