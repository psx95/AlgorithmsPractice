package Leetcode;

import java.util.Scanner;

public class MaxSubarray {

    public static void main(String Args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter the elements");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println("Maximum subarray sum is " + maxSubArray(nums));
        sc.close();
    }

    private static int maxSubArray(int[] nums) {
        int maxSoFar = Integer.MIN_VALUE, maxEndingHere = 0;
        boolean containsZero = false;
        int maximumElement = Integer.MIN_VALUE;
        for (int num : nums) {
            maxEndingHere += num;
            if (num == 0)
                containsZero = true;
            if (num > maximumElement)
                maximumElement = num;
            if (maxEndingHere < 0) {
                maxEndingHere = 0;
            }
            if (maxEndingHere > maxSoFar) {
                maxSoFar = maxEndingHere;
            }
        }
        if (maxSoFar == 0 && !containsZero)
            return maximumElement;
        return maxSoFar;
    }
}
