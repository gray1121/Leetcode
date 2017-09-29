class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0)
            return;
        int m = board.length;
        int n = board[0].length;
        // flip the regions connect to the edge to another marker 'Y'
        for (int i = 0; i < n; ++i) {
            if (board[0][i] == 'O')     dfs(board, 0, i, m, n);
            if (board[m - 1][i] == 'O') dfs(board, m - 1, i, m, n);
        }
        if (m > 2) {
            for (int i = 1; i < m - 1; ++i) {
                if (board[i][0] == 'O')     dfs(board, i, 0, m, n);
                if (board[i][n - 1] == 'O') dfs(board, i, n - 1, m, n);
            }
        }
        // flip 'O's to 'X' and 'Y's to 'O'
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'Y') {
                    board[i][j] = 'O';
                }
                else {
                    board[i][j] = 'X';
                }
            }
        }
    }
    private void dfs(char[][] board, int i, int j, int m, int n) {
        if (i >= m || i < 0 || j >= n || j < 0 || board[i][j] == 'X' 
            || board[i][j] == 'Y') {
                return;
        }
        board[i][j] = 'Y';
        // StackOverflow
        dfs(board, i + 1, j, m, n);
        dfs(board, i - 1, j, m, n);
        dfs(board, i, j + 1, m, n);
        dfs(board, i, j - 1, m, n);
    }
}

class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0)
            return;
        int m = board.length;
        int n = board[0].length;
        // flip the regions connect to the edge to another marker 'Y'
        for (int i = 0; i < n; ++i) {
            if (board[0][i] == 'O')     dfs(board, 0, i, m, n);
            if (board[m - 1][i] == 'O') dfs(board, m - 1, i, m, n);
        }
        if (m > 2) {
            for (int i = 1; i < m - 1; ++i) {
                if (board[i][0] == 'O')     dfs(board, i, 0, m, n);
                if (board[i][n - 1] == 'O') dfs(board, i, n - 1, m, n);
            }
        }
        // flip 'O's to 'X' and 'Y's to 'O'
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'Y') {
                    board[i][j] = 'O';
                }
                else {
                    board[i][j] = 'X';
                }
            }
        }
    }
    private void dfs(char[][] board, int i, int j, int m, int n) {
        if (i >= m || i < 0 || j >= n || j < 0 || board[i][j] == 'X' 
            || board[i][j] == 'Y') {
                return;
        }
        board[i][j] = 'Y';
        if (i + 1 < m && board[i + 1][j] == 'O')   dfs(board, i + 1, j, m, n);
        if (i - 1 > 0 && board[i - 1][j] == 'O')   dfs(board, i - 1, j, m, n);
        if (j + 1 < n && board[i][j + 1] == 'O')   dfs(board, i, j + 1, m, n);
        if (j - 1 > 0 && board[i][j - 1] == 'O')   dfs(board, i, j - 1, m, n);
    }
}