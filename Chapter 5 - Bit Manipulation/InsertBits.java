import java.util.*;
public class InsertBits {
    public static void main  (String args[]) {
        Scanner sc = new Scanner (System.in);
        System.out.println ("Enter number to be inserted IN : ");
        String binaryNumber1 = sc.next();
        int num1 = Integer.parseInt(binaryNumber1, 2);
        System.out.println ("Enter number to be inserted ");
        String binaryNumber2 = sc.next();
        int num2 = Integer.parseInt(binaryNumber2, 2);        
        System.out.println("Enter start and end Position");
        int startPosition = sc.nextInt();
        int endPosition = sc.nextInt();
        System.out.println ("Result of insertion " + Integer.toBinaryString(insertNumber(num1, num2, startPosition, endPosition, binaryNumber1.length())));
    }

    private static int insertNumber (int numberInsertedIn, int numberToBeInsered, int startPosition, int endPosition, int totalLength) {
        int mask = (-1 << (endPosition+1)) | ((-1 >> totalLength-1-startPosition));
        int clearedBitsNumber = numberInsertedIn & mask;
        return (numberToBeInsered << startPosition) | clearedBitsNumber;
    }
}