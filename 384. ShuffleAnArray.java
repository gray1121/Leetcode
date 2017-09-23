import java.util.Random;

class Solution {
    private int[] nums;
    private Random random;
    public Solution(int[] nums) {
        this.nums = nums;
        random = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    // 1. Fisher–Yates shuffle
    // https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle
    // 2. Collection.shuffle();
    // Using Collections to shuffle an array of primitive types is a bit of an overkill
    public int[] shuffle() {
        if (nums == null || nums.length <= 1)
            return nums;
        int[] res = nums.clone();
        for (int i = res.length - 1; i > 0; i--) {
          int index = random.nextInt(i + 1);
          // Simple swap
          int temp = res[index];
          res[index] = res[i];
          res[i] = temp;
        }
        return res;
    }
}