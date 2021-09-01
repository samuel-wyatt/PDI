import java.util.*;
public class CelsAndFaren
{
    public static void main(String[] args) 
    {  
        //Data Type Initialisation  
        Scanner sc = new Scanner(System.in);        
        double celsiusTemp, fahrenTemp, answer;
        char userChoice;
        boolean exit = false;

        //Menu Prompt to User
        System.out.println("Which temperature scale are you converting from?\n>(C)elsius\n>(F)ahrenheit");
        userChoice = sc.next().charAt(0);

        do 
        {
            if (userChoice != 'C' && userChoice != 'c' && userChoice != 'F' && userChoice != 'f')
            {
                System.out.println("ERROR: Invalid Choice, Please select one of the above choices");
                userChoice = sc.next().charAt(0);
            } else {
            exit = true;
            }
        } while (!exit);


        //Calculate fahrenheit from celsius
        if ((userChoice == 'c' ) || (userChoice == 'C'))
        {
            System.out.print("Please enter the celsius temperature: ");
            celsiusTemp = sc.nextDouble();
        
            answer = 1.8 * celsiusTemp + 32.0;
            answer = Math.round(answer*100.0)/100.0;
            System.out.println("The temperature in fahrenheit is: " + answer + " degrees fahrenheit");
        }

        //Calculate celsius from fahrenheit 
        else if ((userChoice == 'f') || (userChoice == 'F'))
        {
            System.out.println("Please enter the fahrenheit temperature: ");
            fahrenTemp = sc.nextDouble();

            answer = (fahrenTemp - 32.0) * (5.0 / 9.0);
            answer = Math.round(answer*100.0)/100.0;
            System.out.println("The temperature in celsius is: " + answer + " degrees celsius");
        }
        sc.close();
    }
}
