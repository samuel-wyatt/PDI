import java.util.*;
public class UserInputException2
{
    public static void main(String[] args)
    {
        int number = 0;
        Scanner sc = new Scanner(System.in);
        try
        {
            System.out.print("Enter an integer: ");
            number = sc.nextInt();
            System.out.println("The integer is:" + number);
            sc.close();
        }
        catch(InputMismatchException error)
        {
            System.out.println("Something went wrong!" + error);
            System.out.println("The error: " + error);
        }
    }
}
