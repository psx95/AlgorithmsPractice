package Leetcode;

import java.util.Scanner;

public class ClimbStairs {
    public static void main(String Args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of stairs");
        int n = sc.nextInt();
        System.out.println("Number of ways to climb " + n + " stairs is " + climbStairs(n));
        sc.close();
    }

    private static int climbStairs(int n) {
        int[] dp = new int[n + 1];
        return calculateWays(n, dp);
    }

    private static int calculateWays(int n, int[] dp) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        } else {
            if (dp[n] == 0) {
                dp[n] = calculateWays(n - 1, dp) + calculateWays(n - 2, dp);
            }
            return dp[n];
        }
    }
}
