import java.util.*;
public class PracticeProgram
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int age, year;
        String name;
        
        System.out.print("Enter your name: ");
        name = sc.nextLine();
        System.out.print("Enter your age: ");
        age = sc.nextInt();
        year = 2021-age;
        System.out.println("Hi " + name + "! Your age is " + age + " meaning you were born in the year of " + year);

        sc.close();
    }
}
        
