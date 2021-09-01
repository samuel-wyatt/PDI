import java.util.*;
public class DoWhileLoop
{
    public static void main(String[] args)
    {
        int age;
        Scanner input = new Scanner(System.in);
        
        do
        {
            System.out.println("Enter Age");
            age = input.nextInt();
        }while((age <= 0) || (age >= 0));        
        input.close();
    }
}
