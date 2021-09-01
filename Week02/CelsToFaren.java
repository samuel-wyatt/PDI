import java.util.*;
public class CelsToFaren {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);        
        double celsiusTemp, answer;
   
        System.out.print("Please enter the celsius temperature, as a whole number: ");
        celsiusTemp = sc.nextInt();
        
        answer = 1.8*celsiusTemp+32;
        System.out.println("The temperature in fahrenheit is: " + answer + " degrees fahrenheit");

        sc.close();
    }
}
