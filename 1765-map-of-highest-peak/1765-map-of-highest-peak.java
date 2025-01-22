class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;
        int[][] res = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    q.add(new int[] { i, j });
                } else
                    res[i][j] = -1;
            }
        }

        int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        while (!q.isEmpty()) {
            int[] arr = q.poll();
            int r = arr[0];
            int c = arr[1];

            for (int[] d : dir) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nc >= 0 && nr >= 0 && nr < m && nc < n && res[nr][nc] == -1) {
                    res[nr][nc] = res[r][c] + 1;
                    q.add(new int[] { nr, nc });
                }
            }
        }
        return res;
    }
}