import java.util.*;
public class UserInputException
{
    public static void main(String[] args)
    {
        int number = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        number = sc.nextInt();
        System.out.println("The integer is:" + number);
        sc.close();   
    }
}