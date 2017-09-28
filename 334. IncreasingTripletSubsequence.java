// Memorized Binary Search
// iterate the array with its order
// determine if there are 3 numbers with increasing value
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for(int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            i = i < 0 ? -(i + 1) : i;
            dp[i] = num;
            if(i == len) {
                if(++len >= 3) {
                    return true;
                }
            }
        }
        return false;
    }
}
// DP storing the smaller and middle one
// find the largest then return true;
class Solution {
    // [1, 4, 3, 2, 5]
    public boolean increasingTriplet(int[] nums) {
        int small = Integer.MAX_VALUE, large = Integer.MAX_VALUE;
        for(int num : nums) {
            // duplicate [1,1,2]
            if(num <= small) {
                small = num;
            } else if(num <= large) {
                large = num;
            } else {
                return true;
            }
        }
        return false;
    }
}