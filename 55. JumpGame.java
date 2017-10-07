class Solution {
    // dp approach
    // TLE
    // [25000,24999,24998,24997,24996,
    //  24995,24994,24993,24992,24991.....]
    public boolean canJump(int[] nums) {
        if (nums.length == 1) { return true; }
        int len = nums.length;
        boolean[] dp = new boolean[len];
        dp[len - 1] = true;
        for (int i = len - 2; i >= 0; i--) {
            for (int j = nums[i]; j > 0; j--) {
                if (i + j >= len - 1 || dp[i + j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }
}
// Use Greedy
// O(N)
class Solution {
    public boolean canJump(int[] nums) {
        int mostFar = 0;
        for (int i = 0; i < nums.length; i++) {
            if (mostFar >= i) {
                mostFar = Math.max(mostFar, i + nums[i]);
            }
        }
        return mostFar >= nums.length - 1;
    }
}