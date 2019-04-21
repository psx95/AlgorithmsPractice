import java.util.Scanner;
public class NextNumber {
    public static void main (String Args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println ("Enter the number in binary");
        String num = sc.next();
        int n = Integer.parseInt(num,2);
        System.out.println("Number in Base 10 is "+n);        
        int small = findNextSmallest(n);
        System.out.println ("Next Smallest Number is "+small+ " ("+Integer.toBinaryString(small)+")");
        int large = findNextLargestNumber(n);
        System.out.println ("Next Largest Number is "+large+ " ("+Integer.toBinaryString(large)+")");
        sc.close();
    }

    private static int findNextLargestNumber (int num) {
        int lastZeroPos = -1;
        int firstOnePos = -1;
        int currentPos = 0;
        int temp = num;
        while (temp != 0) {
            if ((1&temp) == 1 && firstOnePos == -1) {
                firstOnePos = currentPos;
            } else if ((1 & temp) == 0) {
                lastZeroPos = currentPos;
            }
            currentPos++;
            temp >>= 1;
        }
        num = ~(1 << firstOnePos) & num; 
        num = (1 << lastZeroPos) | num;
        return num;
    }

    private static int findNextSmallest(int num) {
        int firstZeroPos = -1; 
        int lastOnePos = -1;
        int currentPos = 0;
        int temp = num;
        while (temp != 0) {            
            if ((1 & temp) == 0 && firstZeroPos == -1) {                
                firstZeroPos = currentPos;
            } else if ((1 & temp) == 1) {
                lastOnePos = currentPos;
            }        
            currentPos++;
            temp >>= 1;
        }
        num = (1 << firstZeroPos) | num; // set bit
        num = ~(1 << lastOnePos) & num; // unset bit
        return num;
    }
}