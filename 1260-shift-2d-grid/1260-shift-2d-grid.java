class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        k = k % (m * n);

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < m; i++)
            res.add(new ArrayList<>(Collections.nCopies(n, 0)));

        int l = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int row = ((l + k) / n) % m;
                int col = (l + k) % n;
                //System.out.println(l + "-" + row + "-" + col);
                res.get(row).set(col, grid[i][j]);
                l++;
            }
        }
       // System.out.println(res);
        return res;
    }
}