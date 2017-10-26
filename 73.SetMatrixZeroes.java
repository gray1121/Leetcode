class Solution {
    // Use the col0 and row0 to store if the row and the col have to be changed
    // space: O(mn) -> O(m + n) -> O(1)
    public void setZeroes(int[][] matrix) {
        boolean col = false;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) { col = true; }
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = matrix[0].length - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0)  { matrix[i][j] = 0; }
            }
            if (col) { matrix[i][0] = 0; }
        }
    }
}