import java.util.*;
public class WhileValidation
{
    public static void main(String[] args)
    {
        int number = 0;
        Scanner sc = new Scanner(System.in);
        do
        {
            System.out.print("Enter a number between 1 and 6: ");
            number = sc.nextInt();
        }while(number > 7 && number < 0);              
        sc.close();
    }
}