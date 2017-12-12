public class Solution {
    // bottom - up
    // dfs + memorize
    public int coinChange(int[] coins, int amount) {
        if(amount < 0 || coins == null || coins.length == 0)
            return -1;
        if(amount == 0)  return 0;
        int[] dp = new int[amount + 1];
        return this.helper(coins, dp, amount);
    }
    private int helper(int[] coins, int[] dp, int resAmount) {
        if(resAmount < 0)   return -1;
        if(resAmount == 0)  return 0;
        if(dp[resAmount] != 0)  return dp[resAmount];
        int min = Integer.MAX_VALUE;
        for(int coin : coins) {
            int rest = this.helper(coins, dp, resAmount - coin);
            if(resAmount >= coin && rest != -1) {
                min = Math.min(min, rest + 1);
            }   
        }
        dp[resAmount] = min < Integer.MAX_VALUE ? min : -1;
        return dp[resAmount];
    }
}
public class Solution {
    // top - down
    // edgecase
    // coins = [2, 5], amount = 6
    public int coinChange(int[] coins, int amount) {
        if(amount < 0 || coins == null || coins.length == 0)
            return -1;
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for(int i = 1; i <= amount; ++i) {
            int min = Integer.MAX_VALUE;
            for(int coin : coins) {
                if(i >= coin && dp[i - coin] != Integer.MAX_VALUE) {
                    min = Math.min(min, dp[i - coin] + 1);
                }
            }
            dp[i] = min;
        }
        return dp[amount] < Integer.MAX_VALUE ? dp[amount] : -1;
    }
}