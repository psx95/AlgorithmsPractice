package Leetcode;

import java.util.Scanner;

public class AddBinary {

    private static int carry = 0;

    public static void main(String Args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first binary number");
        String a = sc.next();
        System.out.println("Enter second binary number");
        String b = sc.next();
        System.out.println("The addition of both the numbers are " + addBinary(a, b));
        sc.close();
    }

    public static String addBinary(String a, String b) {
        StringBuilder longer = a.length() >= b.length() ? new StringBuilder(a) : new StringBuilder(b);
        String smaller = a.length() < b.length() ? a : b;
        int smallerLength = smaller.length();
        for (int i = longer.length() - 1; i >= 0; i--) {
            char x = longer.charAt(i);
            System.out.println("i is " + i + " smaller length is " + (smallerLength - 1));
            if (smallerLength > 0) {
                char y = smaller.charAt(smallerLength - 1);
                smallerLength -= 1;
                char addResult = addBinary(x, y);
                longer.setCharAt(i, addResult);
            } else {
                char addResult = addBinary(x, '0');
                longer.setCharAt(i, addResult);
            }
        }
        if (carry != 0) {
            longer.insert(0, '1');
        }
        return longer.toString();
    }

    private static char addBinary(char a, char b) {
        System.out.println("A is " + a + " and B is " + b);
        int sum = (a - 48) + (b - 48) + carry;
        System.out.println("Sum is  " + sum);
        if (sum == 0) {
            carry = 0;
            return '0';
        } else if (sum == 1) {
            carry = 0;
            return '1';
        } else if (sum == 2) {
            carry = 1;
            return '0';
        } else {
            // sum = 3
            carry = 1;
            return '1';
        }
    }
}
