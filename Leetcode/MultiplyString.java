import java.util.*;
public class MultiplyString
{
    public static void main (String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println ("Enter numbers to multiply");
        String num1 = sc.next();
        String num2 = sc.next();
        System.out.println ("Final Result " + multiply(num1, num2));
    }

    public static String multiply(String num1, String num2)
    {
    	int multiplier = 1;
        if (num1.charAt(0) == '-')
        {
            num1 = num1.substring(1);
            multiplier *= -1;
        }
        if (num2.charAt(0) == '-')
        {
            num2 = num2.substring(1);
            multiplier *= -1;
        }
     
        int l1 = num1.length();
        int l2 = num2.length();
        String longerString, smallerString;        
        StringBuilder finalRes = new StringBuilder("");
        if (l1 > l2)
        {
            longerString = num1;
            smallerString = num2;
        }
        else
        {
            longerString = num2;
            smallerString = num1;
        }

        ArrayList<String> singleMultiplicationResult = new ArrayList<>();
        int currentCarry = 0;
        for (int i = smallerString.length() - 1; i >= 0; i--)
        {
            int smallerChar = smallerString.charAt(i) - 48;
            StringBuilder str = new StringBuilder("");
            int counter = smallerString.length() - 1;
            while (counter != i)
            {
                str.append("0");
                counter--;
            }

            for (int j = longerString.length() - 1; j >= 0; j--)
            {
                int longerChar = longerString.charAt(j) - 48;
                int singleDigMultiplicationResult = (longerChar * smallerChar) + currentCarry;
                System.out.println ("Single digit result " + singleDigMultiplicationResult);
                if (j > 0)
                {
                    str.insert(0, (singleDigMultiplicationResult % 10));
                    currentCarry = (int)(singleDigMultiplicationResult / 10);
                }
                else
                {
                    str.insert(0, singleDigMultiplicationResult);
                    System.out.println ("Inserted " + str.toString());
                    currentCarry = 0;
                }
            }
            singleMultiplicationResult.add(str.toString());
        }

        System.out.println ("Single MultiplicationResult " + Arrays.toString(singleMultiplicationResult.toArray()));

        String lastResult = singleMultiplicationResult.get(singleMultiplicationResult.size() - 1);
        int posFromLast = 0;
        currentCarry = 0;
        int lastPosWithNonZeroChar = -1;
        for (int i = lastResult.length() - 1; i >= 0; i--)
        {
            int sumAllCharsAtPos = sumAllCharsFromPosition(posFromLast, singleMultiplicationResult);
            if (i > 0)
            {
                int singleDigitAdditionResult = sumAllCharsAtPos + currentCarry;
                finalRes.insert(0, ((singleDigitAdditionResult % 10)));
                currentCarry = (int)(singleDigitAdditionResult / 10);
                System.out.println("SUM CURRENT CARRY " + currentCarry);
                if (singleDigitAdditionResult % 10 != 0)
                    lastPosWithNonZeroChar = i;
            }
            else
            {
                finalRes.insert(0, sumAllCharsAtPos + currentCarry);
                if ((sumAllCharsAtPos + currentCarry) != 0)
                    lastPosWithNonZeroChar = i;
            }
            posFromLast++;
        }
        System.out.println (lastPosWithNonZeroChar + " is the last Position with non zero char");
        if (lastPosWithNonZeroChar == -1)
            return "0";
        if (multiplier == -1)
            finalRes.insert(0, "-");
        return finalRes.substring(lastPosWithNonZeroChar);
    }


    private static int sumAllCharsFromPosition (int posFromLast, ArrayList<String> singleMultiplicationResult)
    {
        int res = 0;
        for (int i = 0; i < singleMultiplicationResult.size(); i++)
        {
            String currString = singleMultiplicationResult.get(i);
            if (currString.length() - 1 >= posFromLast)
            {
                res = res + (currString.charAt(currString.length() - 1 - posFromLast) - 48);
            }
        }
        System.out.println ("Sum row result " + res);
        return res;
    }
}