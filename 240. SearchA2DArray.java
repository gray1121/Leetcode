// Greedy Hanhattan Distance
// O(M+N)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) { return false; }
        int i = 0, j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) { return true; }
            else if (matrix[i][j] < target) { i++; }
            else { j--; }
        }
        return false;
    }
}

// naive binary Search
// O (MlongN)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0)
            return false;
        for (int[] row : matrix) {
            if (Arrays.binarySearch(row, target) >= 0) {
                return true;
            }
        }
        return false;
    }
}

// O(logM * logN) ????
// I don't think so