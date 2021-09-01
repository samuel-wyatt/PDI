import java.util.*;
public class NewFile
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int numberOne, numberTwo, numberThree, answer;

		System.out.print("Enter Number One: ");
		numberOne = sc.nextInt();
		System.out.print("Enter Number Two: ");
		numberTwo = sc.nextInt();
		System.out.print("Enter Number Three: ");
		numberThree = sc.nextInt();

		answer = numberOne + numberTwo + numberThree;
		System.out.println("Those three number sum to: " + answer);

		sc.close();
	}
} 
