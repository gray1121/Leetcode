class Solution {
    // SO MANY EDGE CASE!!!
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        // the range of elements are betweens lower and upper
        // "two pointer"
        // lower can be Integer.MIN_VALUE
        // may have duplicate
        int left = lower;
        List<String> res = new LinkedList<String>();
        for (int i = 0; i < nums.length; i++) {
            // upper can be Integer.MAX_VALUE
            int right = nums[i];
            if (left == upper) {
                break;
            }
            if (left + 1 == right) {
                res.add(String.valueOf(left));
            }
            else if (left + 1 < right) {
                res.add(left + "->" + (right - 1));
            }
            if (right == upper) {
                break;
            }
            left = right + 1;
        }
        if (nums.length != 0 && nums[nums.length - 1] == upper) {
            return res;
        }
        left = nums.length == 0 ? lower: nums[nums.length - 1] + 1;
        if (left == upper) {
            res.add(String.valueOf(left));
        }
        else if (left < upper) {
            res.add(String.valueOf(left) + "->" + upper);
        }
        return res;
    }
}