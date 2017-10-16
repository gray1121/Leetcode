// O(nlongn) time O(1) space
public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        Arrays.sort(nums);
        return nums[len - k];
}
// O(nlongK) time O(K) space
public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for(int val : nums) {
        pq.offer(val);

        if(pq.size() > k) {
            pq.poll();
        }
    }
    return pq.peek();
}
// QuickSelect O(n) time O(1) space
 class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (k > nums.length || k <= 0) { return -1; }
        int left = 0, right = nums.length - 1;
        k = nums.length - k;
        while (left < right) {
            int pivot = partition(nums, left, right);
            if (pivot < k) {
                left = pivot + 1;
            }
            else if (pivot > k) {
                right = pivot - 1;
            }
            else {
                return nums[pivot];
            }
        }
        return nums[left];
    }
    private int partition(int[] nums, int left, int right) {
        int pivot = left;
        while (left < right) {
            // right pointer goes first, to make sure left pointer point to a value smaller than pivot
            while (left < right && nums[right] > nums[pivot]) { right--; }
            while (left < right && nums[left] <= nums[pivot]) { left++; }
            if (left >= right) { break; }
            swap(nums, left, right);
        }
        swap(nums, pivot, left);
        return left;
    }
    // can not use the XOR swap because when two pointer point to the same position, it will be 0
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
