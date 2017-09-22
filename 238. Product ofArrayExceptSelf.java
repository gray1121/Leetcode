class Solution {
    // Solve it without division and in O(n)
    // Not use set and only use mutiplication
    // duplicate
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] output = new int[len];
        Arrays.fill(output, 1);
        // len > 1
        // two side DP
        // first iteration is calculating the product of nums on the left of this index
        // second ... on the right of this index (without the num of this index)
        for (int i = 1; i < len; i++) {
            output[i] = output[i - 1] * nums[i - 1];
        }
        // optimized the space to O(1)
        int rightroduct = nums[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            output[i] *= rightProduct;
            rightProduct *= nums[i];
        }
        return output;
    }
}