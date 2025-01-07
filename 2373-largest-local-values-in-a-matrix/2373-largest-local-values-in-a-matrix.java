class Solution {
    public int[][] largestLocal(int[][] grid) {
        int[][] maxLocal = new int[grid.length - 2][grid[0].length - 2];
        for (int i = 0; i < maxLocal.length; i++) {
            for (int j = 0; j < maxLocal[0].length; j++) {
                maxLocal[i][j] = helper(grid, i+1, j+1);
            }
        }
        return maxLocal;
    }

    public int helper(int[][] img, int x, int y) {
        int max = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int nx = x + i;
                int ny = y + j;
                if (nx >= 0 && nx < img.length && ny >= 0 && ny < img[0].length) {
                    max = Math.max(max, img[nx][ny]);
                }
            }
        }
        // System.out.println(x+"-"+y+"-"+smooth+"-"+ items);

        return max;
    }
}