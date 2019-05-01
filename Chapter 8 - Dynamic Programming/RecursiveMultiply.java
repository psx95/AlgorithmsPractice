import java.util.Scanner;

public class RecursiveMultiply {
    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        long timeS = System.nanoTime();
        //System.out.println("Recursive multiply "+ recurseMultiply(num1, num2) +" fast ("+(System.nanoTime()-timeS)+")");
        //timeS = System.nanoTime();
        System.out.println("Recursive multiply "+ recurseMultiply_slow(num1, num2) +" slow ("+(System.nanoTime()-timeS)+")");
        sc.close();
    }

    private static int recurseMultiply(int a, int b) {
        int max = Math.max(a,b);
        int min = Math.min(a, b);
        if (min%2 == 0) {
            int ans = multiply(max, min/2);
            return ans+ans;
        } else {            
            int ans = multiply(max, (int)Math.floor(min/2));
            return ans+ans+max;
        }       
    }

    private static int recurseMultiply_slow(int a, int b) {
        int max = Math.max(a,b);
        int min = Math.min(a, b);
        return multiply(max, min);
    }

    // divide smaller number by 2 to get res and then res+res.
    private static int multiply(int max, int min) {
        if (min == 0) {
            return 0;
        } else if (min == 1) {
            return max;
        } 
        int s = min >> 1; // divide by 2;       
        int halfprod = multiply(max, s); 
        if (min % 2 == 0) {
            return halfprod + halfprod;
        } else {
            return halfprod + halfprod + max;
        }                                
    }
}