import java.util.*;
public class WhileLoop
{
    public static void main(String[] args)
    {
        char choice;
        boolean close = false;
        Scanner input = new Scanner(System.in);
        while(!close) 
        {
            System.out.print("Enter letter: ");
            choice = input.next().charAt(0);
            switch(choice)
            {
                case 'a': case 'A':
                    System.out.println("You entered:" + choice);
                break;
                case 'e': case 'E':
                    System.out.println("You entered:" + choice);
                    //close = true;
                break;
                default:
                    System.out.println("Invalid Choice");
            }
        }
        input.close(); // Close the Scanner object.
    }
}
