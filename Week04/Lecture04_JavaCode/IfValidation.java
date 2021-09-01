import java.util.*;
public class IfValidation
{
    public static void main(String[] args)
    {
        int number = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number between 1 and 6: ");
        number = sc.nextInt();
        sc.close();
        if(number < 7 && number > 0)
        {
            System.out.println("Look what happens now: AMAZING");
        }
        else
        {
            System.out.println("Input was outside of range!");
        }
    }
}
