// 3 pass 3*9^2 Time 9 space
class Solution {
    public boolean isValidSudoku(char[][] board) {
        int len = board.length;
        for (int i = 0; i < len; i++) {
            if (!isValid(board, i, i, 0, len - 1)) { return false; }
            if (!isValid(board, 0, len - 1, i, i)) { return false; }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!isValid(board, i*3, i*3 + 2, j*3, j*3 + 2)) { return false; }
            }
        }
        return true;
    }
    private boolean isValid(char[][] board, int row1, int row2, int col1, int col2) {
        Set<Character> set = new HashSet<>();
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                if (board[i][j] == '.') { continue; }
                if (set.contains(board[i][j])) { return false; }
                set.add(board[i][j]);
            }
        }
        return true;
    }
}
// 1 pass 9^2 Time 9*3 space
class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> col = new HashSet<>();
            Set<Character> row = new HashSet<>();
            Set<Character> cube = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !col.add(board[i][j])) { return false; }
                if (board[j][i] != '.' && !row.add(board[j][i])) { return false; }
                // start index of cube row(col)
                // find the start row(col) index combination by JUST the I index
                // because the no. of cube is determined by I
                // And the position in the cube should be determined by J
                // 0(0)    0(3)    0(6)
                // 3(0)    3(3)    3(6)
                // 6(0)    6(3)    6(6)
                int rowIndex = i / 3 * 3;
                int colIndex = i % 3 * 3;
                int rowDelta = j / 3;
                int colDelta = j % 3;
                if (board[rowIndex + rowDelta][colIndex + colDelta] != '.' 
                    && !cube.add(board[rowIndex + rowDelta][colIndex + colDelta])) {
                        return false;
                }
            }
        }
        return true;
    }
}