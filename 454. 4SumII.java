class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        // Use space to reduce the time complexity
        // similar X sum problem
        // just need the count of possible tuples
        // no need to store the index
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        // same length
        int len = A.length;
        for (int i = 0; i < len; ++i) {
            for (int j = 0; j < len; ++j) {
                int sum = A[i] + B[j];
                // store the possible comblination of the sum
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        int res = 0;
        for (int i = 0; i < len; ++i) {
            for (int j = 0; j < len; ++j) {
                // even the sum of C[i] and D[j] may has duplicate
                // it counts different combination of tuples
                int negativeSum = C[i] + D[j];
                if (map.containsKey(-negativeSum)) 
                    res += map.get(-negativeSum);
            }
        }
        return res;
    }
}