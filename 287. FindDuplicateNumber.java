class Solution {
    // must not modify the array
    // and O(1) space
    // < O(n2) --> Binary Search
    // if we sort we will get the duplicate make 
    // the arrays longer than the length after the point
    // so find the point without sort
    public int findDuplicate(int[] nums) {
        int start = 1, end = nums.length - 1;
        while (start < end) {
            int count = 0;
            int mid = start + (end - start) / 2;
            for (int num : nums) {
                if (num <= mid) 
                    ++count;
            }
            if (count <= mid) {
                start = mid + 1;
            }
            else {
                end = mid;
            }
        }
        return start;
    }
}

// https://en.wikipedia.org/wiki/Cycle_detection
// floyd's cycle finding algorithms
// like find cycle in linkedlist
// the value in the array can be assumed as pointer to another node (index)
public class Solution {
    public int findDuplicate(int[] nums) {
        if(nums.length == 0)
            return 0;
        int slow=0, fast=0;
        slow = nums[slow];
        fast = nums[nums[fast]];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}