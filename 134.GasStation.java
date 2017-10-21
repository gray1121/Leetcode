class Solution {
    // Greedy Approach
    // the bruteforce approach is trying every index and iterating whole array
    // the optimized greedy approach is if the i -> j has negative sum
    // the start from every index is in the interval is not the answer(only one answer)
    // And if the total is > 0 it make sure there will be an answer in this problem
    // O(n) time  O(1) 
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length == 0 || cost.length == 0) { return -1; }
        int start = 0;
        int sum = 0;
        int total = 0;
        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            total += diff;
            sum += diff;
            if (sum < 0) {
                start = i + 1;
                sum = 0;
            }
        }
        if (total < 0) {
            return -1;
        }
        return start;
    }
}