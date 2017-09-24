public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums == null || nums.length == 0)
            return res;
        helper(nums, new LinkedList<Integer>(), 0, res);
        return res;
    }
    
    private void helper(int[] nums, List<Integer> list, int index, List<List<Integer>> res) {
        res.add(new LinkedList<Integer>(list));
        for (int i = index; i < nums.length; ++i) {
            list.add(nums[i]);
            helper(nums, list, i + 1, res);
            list.remove(list.size() - 1);
        }
    }
}