import java.util.Scanner;

public class TripleStep {
    public static void main (String Args[]) {
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter Number of Steps");
        int n = sc.nextInt();    
        long time1 = System.nanoTime();
        System.out.println("Number of ways climbed "+calculateStep(n));
        System.out.println("Total time taken cached "+(System.nanoTime() - time1)/1000);
        long time = System.nanoTime();
        System.out.println ("Number of ways recursive "+calculateStep_recursive(n));
        System.out.println("Total time taken no-cache "+(System.nanoTime() - time)/1000);
        sc.close();
    }

    private static int calculateStep (int n) {
        int[] arr = new int[n+1];        
        return calculateStep(n, arr);
    }


    private static int calculateStep (int n, int[] cache) {
        if (n == 3)
        return 4;
        if (n == 2)
        return 2;
        if (n == 1)
        return 1;
        if (cache[n] == 0) {
            cache[n] = calculateStep(n-1, cache) + calculateStep(n-2, cache) + calculateStep(n-3, cache);
        }
        return cache[n];
    }

    private static int calculateStep_recursive (int n) {
        if (n == 3)
        return 4;
        if (n == 2)
        return 2;
        if (n == 1)
        return 1;
        return calculateStep_recursive(n-1) + calculateStep_recursive(n-2) + calculateStep_recursive(n-3);
    }

}