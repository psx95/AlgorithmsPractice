import java.util.Scanner;
public class StrToInt
{
    public static void main (String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println ("Enter number string");
        String num = sc.next();
        System.out.println ("Converted number is " + myAtoi(num));
    }

    public static int myAtoi(String str)
    {
        boolean digitEncountered = false;
        boolean negativeSignEncountered = false;
        boolean positiveSignEncountered = false;
        long number = 0;
        for (int i = 0; i < str.length(); i++)
        {
            char x = str.charAt(i);
            if (Character.isDigit(x))
            {
                digitEncountered = true;                
                number = number * 10 + (x - 48);
                if (number > Integer.MAX_INT) {
                	number = Integer.MAX_INT;
                	if (negativeSignEncountered) {
                		return (int)(number * -1);             	
                	} else {
                		return (int)number;
                	}                	
                } 
            }
            else if (x == '-' || x == '+')
            {
                if (digitEncountered || negativeSignEncountered || positiveSignEncountered)
                {
                    break;
                }
                if (x == '-')
                    negativeSignEncountered = true;
                else 
                	positiveSignEncountered = true;
            }
            else
            {
                // Some other literal except digits and negative sign
               if (digitEncountered || negativeSignEncountered || positiveSignEncountered || x != 32)               
               		break;              
            }
        }
        if (negativeSignEncountered)
            return (int)(number * -1);
        return (int)number;
    }
}