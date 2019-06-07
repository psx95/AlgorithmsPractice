import java.util.ArrayList;
import java.util.Scanner;

public class PowerSet {
    public static void main (String Args[]) {
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter number of elements");
        int n = sc.nextInt();
        System.out.println ("Enter the Set");
        int arr[] = new int[n];
        for (int i=0; i < n ; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
    }

    private ArrayList<ArrayList<Integer>> computePowerSet (int[] arr) {
        ArrayList<ArrayList<Integer>> powerSet = new ArrayList<>();
        return powerSet;
    }
}