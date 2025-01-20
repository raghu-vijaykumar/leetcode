class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] map = new int[(m + 1) * (n + 1)][2];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                map[mat[i][j]] = new int[] { i, j };
            }
        }

        int[] rowFrequency = new int[m];
        int[] columnFrequency = new int[n];
        for (int k = 0; k < arr.length; k++) {
            int i = map[arr[k]][0];
            int j = map[arr[k]][1];
            rowFrequency[i]++;
            columnFrequency[j]++;
            if (rowFrequency[i] == n || columnFrequency[j] == m)
                return k;
        }
        return -1;
    }
}