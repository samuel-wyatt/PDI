import java.util.*;
public class CharConverter {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        char upperCase, lowerCase;
        int upperDec, lowerDec;

        System.out.print("Please enter an uppercase character: ");
        upperCase = sc.next().charAt(0);
        
        upperDec = (int)upperCase;
        lowerDec = upperDec + 32;
        lowerCase = (char)lowerDec;

        System.out.println("The ASCII value of '" + upperCase + "' is: " + upperDec);
        System.out.println("The lowercase value of '" + upperCase + "' is: '" + lowerCase + "'");
        sc.close();
    }
}
