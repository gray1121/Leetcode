// two passes
class Solution {
    public void sortColors(int[] nums) {
        int red = 0, white = 0, blue = 0;
        for (int num : nums) {
            if (num == 0) {
                red++;
            }
            else if (num == 1) {
                white++;
            }
            else {
                blue++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (red-- > 0) {
                nums[i] = 0;
            }
            else if (white-- > 0) {
                nums[i] = 1;
            }
            else {
                nums[i] = 2;
            }
        }
    }
}
// one pass
class Solution {
    public void sortColors(int[] nums) {
        int j = 0;
        int k = nums.length - 1;
        for (int i = 0; i <= k; i++) {
            if (nums[i] == 0) {
                swap(nums, i, j);
                j++;
            }
            else if (nums[i] == 2) {
                swap(nums, i, k);
                k--;
                i--;
            } 
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}