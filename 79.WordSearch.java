class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || word == null) { return false; }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // DFS the position with the start of the word
                if (board[i][j] == word.charAt(0) && search(board, word, i, j, 0)) { return true; }
            }
        }
        return false;
    }
    public boolean search(char[][] board, String word, int i, int j, int pos) {
        if (pos == word.length()) { return true; }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length 
            || board[i][j] == '#' || board[i][j] != word.charAt(pos)) { return false; }
        // backtrack
        board[i][j] = '#';
        boolean s = search(board, word, i + 1, j, pos + 1) || search(board, word, i - 1, j, pos + 1)
            || search(board, word, i, j + 1, pos + 1) || search(board, word, i, j - 1, pos + 1);
        board[i][j] = word.charAt(pos);
        return s;
    }
}