class Solution {
    // Two operations O(N^2)
    // 1. have symmetry about diagonal
    // 2. have symmetry about middle line
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0
           || matrix[0] == null || matrix[0].length == 0) { return; }
        int len = matrix.length;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (i != j) {
                    swap(matrix, i, j, j, i);
                }
            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len / 2; j++) {
                swap(matrix, i, j, i, len - 1 - j);
            }
        }
    }
    private void swap(int[][] matrix, int ax, int ay, int bx, int by) {
        int temp = matrix[ax][ay];
        matrix[ax][ay] = matrix[bx][by];
        matrix[bx][by] = temp;
    }
}
// rotate the matrix directly
class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0
           || matrix[0] == null || matrix[0].length == 0) { return; }
        int len = matrix.length;
        // the size of the matrix can be odd or even
        // if odd, only one of i and j can be the middle index
        for (int i = 0; i < len / 2; i++) {
            for (int j = 0; j < (len + 1) / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[len - 1 - j][i];
                matrix[len - 1 - j][i] = matrix[len - 1 - i][len - 1 - j];
                matrix[len - 1 - i][len - 1 - j] = matrix[j][len - 1 - i];
                matrix[j][len - 1 - i] = temp;
            }
        }
    }
}
