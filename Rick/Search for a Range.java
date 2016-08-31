public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] range = {-1,-1};
        if (null == nums || nums.length == 0){
            return range;
        }
        int start = 0, end = nums.length - 1;
        int mid;
        // Search for left bound
        while (start + 1 < end){
            mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                start = mid;
            }else{
                end = mid;
            }
        }
        if(nums[start] == target){
            range[0] = start;
        }else if(nums[end] == target){
            range[0] = end;
        }else{
            return range;
        }
        // Search for right bound
        start = 0;
        end = nums.length - 1;
        while(start + 1 < end){
            mid = start + (end - start)/2;
            if(nums[mid] > target){
                end = mid;
            }else{
                start = mid;
            }
        }
        if(nums[end] == target){
            range[1] = end;
        }else if(nums[start] == target){
            range[1] = start;
        }else{
            range[0] = -1;
            range[1] = -1;
            return range;
        }
        return range;
    }
}