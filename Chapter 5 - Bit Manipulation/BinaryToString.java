import java.util.Scanner;
public class BinaryToString {
    public static void main (String Args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Eneter the number between 0 and 1");
        double number = sc.nextDouble();
        System.out.println(getBinaryRepresentation(number));
        sc.close();
    }

    private static String getBinaryRepresentation (double number) {
        double temp = number;
        String ans = ".";
        int bitCount = 0;
        while (temp!=0 && bitCount <= 32) {        
            temp = temp*2;
            if (temp >= 1) {
                ans+="1";
                temp -=  1;            
            } else {
                ans+="0";
            }
            bitCount++;
        }        
        // System.out.println(ans + " \n bitCOunt  "+bitCount);
        if (bitCount > 32) {
            return "ERROR";
        }        
        return ans;
    }
}