class Solution {
    int count = 0;

    public int findMaxFish(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                if (grid[i][j] > 0)
                    count = Math.max(dfs(grid, i, j, visited), count);
        return count;
    }

    public int dfs(int[][] grid, int i, int j, boolean[][] visited) {
        if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1 || visited[i][j] || grid[i][j] == 0)
            return 0;

        visited[i][j] = true;

        int count = grid[i][j] + dfs(grid, i + 1, j, visited) +
                dfs(grid, i - 1, j, visited) +
                dfs(grid, i, j + 1, visited) +
                dfs(grid, i, j - 1, visited);
        return count;
    }
}