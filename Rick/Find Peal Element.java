public class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0, high = nums.length - 1;
        while(low + 1 < high){ // Prevent from infinity loop
            int mid = low + (high - low)/2;// Prevent from overflow 
            if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]){
                return mid;
            }else if(nums[mid] > nums[mid - 1] && nums[mid] < nums[mid + 1]){
                low = mid;  // without "-1" which is useful in find a target 
                            // but this one is more universal
            }else{
                high = mid;
            }
        }
        // Compare the two pointer
        return nums[low] > nums[high] ? low : high;
    }
}