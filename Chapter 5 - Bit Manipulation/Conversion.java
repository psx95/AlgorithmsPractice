import java.util.*;
public class Conversion {
    public static void main (String Args[]) {
        Scanner sc = new Scanner (System.in);
        System.out.println ("Enter two Binary numbers");
        String num1 = sc.next();
        String num2 = sc.next(); 
        int n1 = Integer.parseInt(num1, 2);
        int n2 = Integer.parseInt(num2, 2);    
        System.out.println("Number of Swaps Required "+returnNumberOfSwapsRequired(n1, n2));
        System.out.println("Number of Swaps Required (Alternate function) : "+returnNumberOfSwaps2(n1, n2));
        sc.close();
    }

    private static int returnNumberOfSwapsRequired (int a, int b) {
        int count = 0;
        for (int c = a ^ b; c!=0; c = c&(c-1)) {
            count++;
        }
        return count;
    }

    private static int returnNumberOfSwaps2 (int n1, int n2) {
        int count = 0;
        for (int i = n1^n2; i!=0; i = i >> 1) {
            count+= i & 1;
        }
        return count;
    }
}