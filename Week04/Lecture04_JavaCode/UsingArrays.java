import java.util.*;
public class UsingArrays
{
    public static void main(String[] args)
    {
        int [] theArray;
        theArray = new int[100];
        int theArrayLength = theArray.length;
        
        for(int i = 0; i < theArrayLength; i++)
        {
            theArray[i] = i * i;
        }

        for(int i = 0; i < theArrayLength; i++)
        {
            System.out.println("theArray["+i+"] is: " + theArray[i]);
        }
        theArray[100] = -1;
    }
}
