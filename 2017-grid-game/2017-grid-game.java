class Solution {
    public long gridGame(int[][] grid) {
        int n = grid[0].length;
        int[][] ps = new int[2][n];

        ps[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            ps[0][i] = ps[0][i - 1] + grid[0][i];
        }

        ps[1][n - 1] = grid[1][n - 1];
        for (int i = n - 2; i >= 0; i--) {
            ps[1][i] = ps[1][i + 1] + grid[1][i];
        }

        int minimized = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int val = Math.max(ps[0][n - 1] - ps[0][i], ps[1][0] - ps[1][i]);
            if (val < minimized) {
                minimized = val;
            }
        }
        return minimized;
    }
}