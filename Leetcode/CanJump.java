package Leetcode;

import java.util.Scanner;

public class CanJump {
    public static void main(String Args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter the elements");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println("Can you reach last elements ? - " + canJump(nums));
        sc.close();
    }

    public static boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        return calculateJump(nums, 0, dp);
    }

    private static boolean calculateJump(int[] nums, int pos, int[] dp) {
        if (pos >= (nums.length - 1)) {
            return true;
        } else {
            int num = nums[pos];
            boolean ans = false;
            for (int i = num; i > 0; i--) {
                if ((pos + i < nums.length)) {
                    if (dp[pos + i] == 0) {
                        ans = calculateJump(nums, pos + i, dp);
                        dp[pos + i] = ans ? 1 : 2;
                        if (ans)
                            return ans;
                    } else if (dp[pos + i] == 1) {
                        ans = true;
                        return ans;
                    }
                } else {
                    return true;
                }
            }
            return ans;
        }
    }
}
