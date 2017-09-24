class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        dfs(nums, new LinkedList<Integer>(), res);
        return res;
    }
    private void dfs(int[] nums, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == nums.length)
            res.add(new LinkedList<Integer>(list));
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i]))
                continue;
            list.add(nums[i]);
            dfs(nums, list, res);
            list.remove(list.size() - 1);
        }
    }
}