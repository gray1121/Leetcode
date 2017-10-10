class Solution {
    private int[][] dirs = {{1, 0},{0, 1},{-1, 0},{0, -1}};
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) { return 0; }
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j, m, n);
                }
            }
        }
        return count;
    }
    
    private void dfs(char[][] grid, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != '1') { return; }
        grid[i][j] = '0';
        for (int[] dir : dirs) {
            dfs(grid, i + dir[0], j + dir[1], m, n);
        }
    }
}