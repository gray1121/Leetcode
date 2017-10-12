class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int lives = liveNeighbors(board, i, j, m, n);
                if (board[i][j] == 1 ) {
                    if (lives == 2 || lives == 3) {
                        // use second to store the new stage
                        board[i][j] |= 1 << 1;
                    }
                }
                else {
                    if (lives == 3) {
                        board[i][j] |= 1<< 1;
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1;
            }
        }
    }
    
    private int liveNeighbors(int[][] board, int i, int j, int m, int n) {
        int lives = 0;
        // elegant way to iterate all neighbors
        for (int x = Math.max(i - 1, 0); x <= Math.min(i + 1, m - 1); x++) {
            for (int y = Math.max(j - 1, 0); y <= Math.min(j + 1, n - 1); y++) {
                lives += board[x][y] & 1;
            }
        }
        // the position itself
        lives -= board[i][j] & 1;
        return lives;
    }
}