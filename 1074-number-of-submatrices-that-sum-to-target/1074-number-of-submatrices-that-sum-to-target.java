class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int count = 0;
        int[][] ps = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int top = i - 1 >= 0 ? ps[i - 1][j] : 0;
                int left = j - 1 >= 0 ? ps[i][j - 1] : 0;
                int top_left = j - 1 >= 0 && i - 1 >= 0 ? ps[i - 1][j - 1] : 0;
                ps[i][j] = matrix[i][j] + top + left - top_left;
            }
            //System.out.println(Arrays.toString(ps[i]));
        }

        // Iterate over all starting points (top-left corner)
        for (int startRow = 0; startRow < m; startRow++) {
            for (int startCol = 0; startCol < n; startCol++) {

                // Iterate over all ending points (bottom-right corner)
                for (int endRow = startRow; endRow < m; endRow++) {
                    for (int endCol = startCol; endCol < n; endCol++) {

                        // Print the submatrix defined by (startRow, startCol) and (endRow, endCol)
                        //System.out.println(                                "Submatrix:[" + startRow + "," + startCol + "], [" + endRow + "," + endCol + "]");
                        int top = startRow - 1 >= 0 ? ps[startRow - 1][endCol] : 0;
                        int left = startCol - 1 >= 0 ? ps[endRow][startCol - 1] : 0;
                        int top_left = startRow - 1 >= 0 && startCol - 1 >= 0 ? ps[startRow - 1][startCol - 1] : 0;
                        int sub_sum = ps[endRow][endCol] - top - left + top_left;

                        if (sub_sum == target)
                            count++;
                        //System.out.println(); // Separate submatrices
                    }
                }
            }
        }
        return count;
    }
}