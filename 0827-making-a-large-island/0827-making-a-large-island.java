import java.util.*;

class Solution {
    public int largestIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] componentId = new int[m][n];
        Map<Integer, Integer> componentSize = new HashMap<>();
        int componentIndex = 2; // Start from 2 to differentiate from 0 and 1
        int maxSize = 0;

        // Step 1: Find all components and store their sizes
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && componentId[i][j] == 0) {
                    int size = dfs(grid, i, j, componentId, componentIndex);
                    componentSize.put(componentIndex, size);
                    maxSize = Math.max(maxSize, size);
                    componentIndex++;
                }
            }
        }

        // Step 2: Check each '0' and compute max possible island size
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> seen = new HashSet<>();
                    int newSize = 1;

                    // Check all 4 neighbors
                    for (int[] d : new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } }) {
                        int ni = i + d[0], nj = j + d[1];
                        if (ni >= 0 && nj >= 0 && ni < m && nj < n && componentId[ni][nj] > 1) {
                            seen.add(componentId[ni][nj]);
                        }
                    }

                    for (int id : seen) {
                        newSize += componentSize.get(id);
                    }

                    maxSize = Math.max(maxSize, newSize);
                }
            }
        }

        return maxSize;
    }

    private int dfs(int[][] grid, int i, int j, int[][] componentId, int index) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0 || componentId[i][j] > 0)
            return 0;

        componentId[i][j] = index;
        int size = 1;

        for (int[] d : new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } }) {
            size += dfs(grid, i + d[0], j + d[1], componentId, index);
        }

        return size;
    }
}
