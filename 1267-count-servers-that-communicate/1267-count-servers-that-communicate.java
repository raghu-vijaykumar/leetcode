class Solution {
    public int countServers(int[][] grid) {
        HashMap<Integer, Integer> row = new HashMap<>();
        HashMap<Integer, Integer> col = new HashMap<>();

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    count++;
                    row.put(i, row.getOrDefault(i, 0) + 1);
                    col.put(j, col.getOrDefault(j, 0) + 1);
                }
            }
        }
        // System.out.println(row);
        // System.out.println(col);

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && row.get(i) < 2 && col.get(j) < 2)
                    count--;
            }
        }

        return count;
    }
}