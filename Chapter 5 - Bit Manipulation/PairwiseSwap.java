import java.util.Scanner;
public class PairwiseSwap {
    public static void main (String args[]) {
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter the number in binary");
        String num = sc.next();
        int number = Integer.parseInt(num,2);
        System.out.println("The pairwise swapped number is "+ Integer.toBinaryString(performPairwiseSwap(number)));
        System.out.println("Pairwise Swap (Efficient) "+Integer.toBinaryString(performSwap_Efficient(number)));
        sc.close();
    }

    private static int performPairwiseSwap (int num) {
        int temp = num;
        int evenCount = 0, oddCount = 1;
        int evenBit, oddBit;
        while (temp!=0){    
            evenBit = ((1 << evenCount) & num) >> evenCount;
            oddBit = ((1 << oddCount) & num) >> oddCount;            
            if (oddBit!=evenBit) {
                num = (evenBit == 1) ? ((~(1 << evenCount) & num) | ((1 << oddCount))) : ((1  << evenCount) | num) & (~(1 << oddCount));
            }                            
            temp <<= 2;
            evenCount+=2;
            oddCount+=2;
        }
        return num;
    }

    public static int performSwap_Efficient (int num) {
        int oddMask = 0xAAAAAAAA; // 10101010
        int evenMask = 0x55555555;
        // mask all odd bits -> make all even bits 0, then right shift all masked bits by 1 to even positions  | 
        // mask all even bits -> make all odd bits 0, then shift left by 1
        // this will shift all masked bits to odd positions
        return ((num & oddMask) >>> 1) | ((num & evenMask) << 1);
    }
}