class Solution {

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int count = 0;
        boolean[][] visited = new boolean[grid1.length][grid1[0].length];
        for (int i = 0; i < grid2.length; i++) {
            for (int j = 0; j < grid2[0].length; j++) {
                if (grid2[i][j] == 1 && !visited[i][j] && dfs(grid1, grid2, i, j, visited))
                    count++;
            }
        }
        return count;
    }

    public boolean dfs(int[][] grid1, int[][] grid2, int i, int j, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= grid1.length || j >= grid1[0].length || visited[i][j] || grid2[i][j] == 0) {
            return true; // Reached boundary or water in grid2
        }

        visited[i][j] = true;

        // Check if the current cell is not overlapping with land in grid1
        boolean isSubIsland = grid1[i][j] == 1;

        // Explore all 4 directions and combine results
        isSubIsland &= dfs(grid1, grid2, i + 1, j, visited);
        isSubIsland &= dfs(grid1, grid2, i - 1, j, visited);
        isSubIsland &= dfs(grid1, grid2, i, j + 1, visited);
        isSubIsland &= dfs(grid1, grid2, i, j - 1, visited);

        return isSubIsland;
    }
}