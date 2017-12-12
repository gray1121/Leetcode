public class Solution {
    public int maxProduct(int[] nums) {
        int maxProduct = nums[0], minProduct = nums[0], allMax = nums[0];
        for(int i = 1; i < nums.length; ++i) {
            if(nums[i] >= 0) {
                maxProduct = Math.max(maxProduct*nums[i], nums[i]);
                minProduct = Math.min(minProduct*nums[i], nums[i]);
            } else {
                int temp = maxProduct;
                maxProduct = Math.max(minProduct*nums[i], nums[i]);
                minProduct = Math.min(temp*nums[i], nums[i]);
            }
            allMax = Math.max(allMax, maxProduct);
        }
        return allMax;
    }
}