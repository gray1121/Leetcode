class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) { return -1; }
        int l = 0, r = nums.length - 1;
        while(l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) { return mid; }
            if (nums[l] <= nums[mid]) {
                if (target < nums[mid] && target >= nums[l]) {
                    r = mid - 1;
                }
                else {
                    l = mid + 1;
                }
            }
            else {
                if (target > nums[mid] && target <= nums[r]) {
                    l = mid + 1;
                }
                else {
                    r = mid - 1;
                }
            }
        }
        if (nums[l] == target) { return l; }
        if (nums[r] == target) { return r; }
        return -1;
    }
}
// Follow up: Contains Duplicate
public class Solution {
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0)    return false;
        int l = 0, r = nums.length - 1;
        while(l + 1 < r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] == target) {
                return true;
            } else if(nums[l] < nums[mid]) {
                if(nums[l] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else if(nums[l] > nums[mid]) {
                if(nums[mid] < target && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            // if nums[l] == nums[mid]
            } else {
                ++l;
            }
        }
        if(nums[l] == target || nums[r] == target)  return true;
        return false;
    }
}