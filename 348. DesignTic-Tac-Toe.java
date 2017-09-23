class TicTacToe {
    int[] cols;
    int[] rows;
    int diagonal;
    int antidiagonal;
    int n;
    
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.n = n;
        cols = new int[n];
        rows = new int[n];
        diagonal = 0;
        antidiagonal = 0;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int mark = player == 1 ? 1 : player == 2 ? -1 : 0;
        rows[row] += mark;
        cols[col] += mark;
        diagonal += row == col ? mark : 0;
        antidiagonal += row + col == n - 1 ? mark : 0;
        if (rows[row] == n || cols[col] == n || diagonal == n || antidiagonal == n) {
            return 1;
        }
        else if (rows[row] == -n || cols[col] == -n || diagonal == -n || antidiagonal == -n) {
            return 2;
        }
        else {
            return 0;
        }
    }
}
