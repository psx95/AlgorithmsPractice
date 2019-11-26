public class UglyNumber2 {
    public int nthUglyNumber(int n) {
        if (n <= 6) {
            return n;
        } else {
            // n is greater than 6
            int[] dp = new int [1691];
            for (int i = 0; i <= 6; i++) {
                dp[i] = i;
            }
            int index2 = 4;
            int index3 = 3;
            int index5 = 2;
            int factor5 = dp[index5];
            int factor3 = dp[index3];
            int factor2 = dp[index2];
            for (int i = 7; i <= n+1; i++) {
                 if (factor5 * 5 <= factor3 * 3 && factor5 * 5 <= factor2 * 2 && factor5 * 5 > dp[i-1]) {
                    dp[i] = factor5 * 5;                
                    factor5 = dp[++index5];
                } else if (factor3 * 3 <= factor2 * 2 && factor3 * 3 <= factor5 * 5 && factor3 * 3 > dp[i-1]) {
                    dp[i] = factor3 * 3;
                    factor3 = dp[++index3];                
                } else {
                    dp[i] = factor2 * 2;
                    factor2 = dp[++index2];                
                }              
            }
            for (int i = 0; i <= n + 1; i++)
                System.out.println (dp[i] +", ");
            return dp[n];   
        }             
    }
}