class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int x = 1;
            while (x * x <= i) {
                dp[i] = Math.min(dp[i - x * x] + 1, dp[i]);
                x++;
            }
        }
        return dp[n];
    }
}
