package Leetcode;

public class MaxSubarray {

    public static void main(String Args[]) {

    }

    public static int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        int absoluteMax = nums[0];
        int currentMax = nums[0];
        int maxPos = -1;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
            if (dp[i] >= absoluteMax) {
                absoluteMax = dp[i];
                maxPos = i;
            }
        }
        currentMax = absoluteMax;
        System.out.println("max Pos is "+maxPos + " absolute max All elems "+absoluteMax);

        for (int i = 0; i < maxPos; i++) {
            currentMax -= nums[i];
            System.out.println("Current max "+currentMax);
            if (currentMax > absoluteMax)
                absoluteMax = currentMax;
        }
        return absoluteMax;
    }
}
