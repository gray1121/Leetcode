// O(N^2)
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for(int i = 0; i < nums.length - 2; ++i) {
            if(nums[i] > 0) break;
            if(i > 0 && nums[i] == nums[i - 1]) { continue; }
            int l = i + 1, r = nums.length - 1;
            while(l < r) {
                if(nums[l] + nums[r] == -nums[i]){
                    while(l < r && nums[l] == nums[l+1])   { ++l; }
                    while(l < r && nums[r] == nums[r-1])   { --r; }
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    ++l;
                    --r;
                } else if(nums[l] + nums[r] < -nums[i]){
                    while(l < r && nums[l] == nums[l+1])    { ++l; }
                    ++l;
                } else {
                    while(l < r && nums[r] == nums[r-1])    { --r; }
                    --r;
                }
            }
        }
        return res;
    }
}