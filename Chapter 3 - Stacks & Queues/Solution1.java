import java.util.Scanner;

public class Solution1 {
    private static int count = 0;
    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println ("Enter a number of initial elements");
        int num = sc.nextInt();
        int arr[] = new int[num*2];
        for (int i =0; i<num; i++) {
            arr[i] = sc.nextInt();  
            count++;     
        }
        printArray(arr);
        System.out.println ("Enter element to add ");
        int element = sc.nextInt();
        shiftAndAdd(element, arr);
        printArray(arr);
    }

    private static void shiftAndAdd (int a, int arr[]) {
        int temp = -999; int temp_2;
        count++;
        for (int i = 0; i <count; i++) {
            if (temp!=-999) {
                temp_2 = arr[i];
                arr[i] = temp;
                temp = temp_2;
            } else {
                temp = arr[i];
                arr[i] = a;
            }
        }
    }

    private static void printArray (int[] arr) {
        for (int i = 0; i<count; i++) {
            System.out.print (arr[i] + ", ");
        }
        System.out.println();
    }
}