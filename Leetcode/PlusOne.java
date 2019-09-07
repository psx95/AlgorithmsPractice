package Leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class PlusOne {

    public static void main(String Args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of digits");
        int n = sc.nextInt();
        System.out.println("Enter the digits");
        int[] digits = new int[n];
        for (int i = 0; i < n; i++) {
            digits[i] = sc.nextInt();
        }
        System.out.println("Result of PlusOne on number " + Arrays.toString(plusOne(digits)));
        sc.close();
    }

    public static int[] plusOne(int[] digits) {
        int carry = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (i == digits.length - 1) {
                int currDig = digits[i];
                int newDig = (currDig + 1) % 10;
                carry = (currDig + 1) >= 10 ? (currDig + 1) / 10 : 0;
                digits[i] = newDig;
            } else if (carry != 0) {
                int currDig = digits[i];
                int newDig = (currDig + carry);
                carry = (newDig) >= 10 ? 1 : 0;
                digits[i] = newDig % 10;
            }
            if (i == 0 && carry != 0) {
                int[] arr = new int[digits.length + 1];
                arr[0] = carry;
                System.arraycopy(digits, 0, arr, 1, digits.length - 1);
                return arr;
            }
        }
        return digits;
    }
}
