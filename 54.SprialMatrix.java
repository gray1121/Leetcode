// Check all edges
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new LinkedList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
        int m = matrix.length, n = matrix[0].length, row = 0, col = -1;
        while (true) {
            for (int i = 0; i < n; i++) res.add(matrix[row][++col]);
            if (--m == 0)  break;
            for (int i = 0; i < m; i++) res.add(matrix[++row][col]);
            if (--n == 0) break;
            for (int i = 0; i < n; i++) res.add(matrix[row][--col]);
            if (--m == 0) break;
            for (int i = 0; i < m; i++) res.add(matrix[--row][col]);
            if (--n == 0) break;
        }
        return res;
    } 
}

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new LinkedList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return res;
        int rowStart = 0;
        int rowEnd   = matrix.length - 1;
        int colStart = 0;
        int colEnd   = matrix[0].length - 1;
        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int i = colStart; i <= colEnd; ++i) {
                res.add(matrix[rowStart][i]);
            }
            rowStart++;
            for (int i = rowStart; i <= rowEnd; ++i) {
                res.add(matrix[i][colEnd]);
            }
            colEnd--;
            if (rowStart <= rowEnd) {
                for (int i = colEnd; i >= colStart; --i) {
                    res.add(matrix[rowEnd][i]);
                }
                rowEnd--;
            }
            if (colStart <= colEnd) {
                for (int i = rowEnd; i >= rowStart; --i) {
                    res.add(matrix[i][colStart]);
                }
                colStart++;
            }
        }
        return res;
    }
}