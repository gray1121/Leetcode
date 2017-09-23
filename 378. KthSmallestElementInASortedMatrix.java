class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int small = matrix[0][0];
        int large = matrix[n - 1][n - 1];
        // binary search approach
        // get count of elements smaller or equal to mid
        // the condition is determine if the count of elements euqal to k
        while (small <= large) {
            int mid = small + (large - small) / 2;
            if (getCount(matrix, n, mid) < k)
                small = mid + 1;
            else 
                large = mid - 1;
        }
        // base case small = large + 1
        // large is target - 1
        return small;
    }
    private int getCount(int[][] matrix, int n, int value) {
        int count = 0;
        int i = n - 1, j = 0;
        // from the first of bottom
        // (from last of top?)
        while (i >= 0 && j < n) {
            if (matrix[i][j] > value) {
                i--;
            }
            else {
                count += i + 1;
                j++;
            }
        }
        return count;
    }
}