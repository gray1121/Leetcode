// Recurision
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = this.binarySearch1(nums, 0, nums.length - 1, target);
        int end = this.binarySearch2(nums, 0, nums.length - 1, target);
        return new int[]{start, end};
    }
    
    private int binarySearch1(int[] nums, int l, int r, int target) {
        if(l > r)   return - 1;
        if(l == r)  return nums[l] == target ? l : -1;
        int mid = ((r - l) >> 2) + l;
        if(nums[mid] >= target) {
            return this.binarySearch1(nums, l, mid, target);
        } else {
            return this.binarySearch1(nums, mid + 1, r, target);
        }
    }
    private int binarySearch2(int[] nums, int l, int r, int target) {
        if(l > r)   return - 1;
        if(l == r)  return nums[r] == target ? r : -1;
        int mid = ((r - l) >> 2) + l + 1;
        if(nums[mid] <= target) {
            return this.binarySearch2(nums, mid, r, target);
        } else {
            return this.binarySearch2(nums, l, mid - 1, target);
        }
    }
}



// Non-recurision
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int leftEnd = left, rightEnd = right;
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] >= target){
                right = mid;
            } else {
                left = mid; 
            }
        }
        if(nums[left] == target) leftEnd = left;
        else if(nums[right] == target) leftEnd = right;
        else leftEnd = -1;
        left = 0;
        right = nums.length - 1;
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] <= target){
                left = mid;
            } else {
                right = mid; 
            }
        }
        if(nums[right] == target) rightEnd = right;
        else if(nums[left] == target) rightEnd = left;
        else rightEnd = -1;
        int[] rst = new int[2];
        rst[0] = leftEnd;
        rst[1] = rightEnd;
        return rst; 
    }
}