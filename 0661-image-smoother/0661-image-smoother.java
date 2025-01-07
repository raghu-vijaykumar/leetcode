class Solution {
    public int[][] imageSmoother(int[][] img) {
        int[][] smoothened = new int[img.length][img[0].length];
        for (int i = 0; i < img.length; i++) {
            for (int j = 0; j < img[0].length; j++) {
                smoothened[i][j] = helper(img, i, j);
            }
        }
        return smoothened;
    }

    public int helper(int[][] img, int x, int y) {
        int smooth = 0;
        int items = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int nx = x + i;
                int ny = y + j;
                if (nx >= 0 && nx < img.length && ny >= 0 && ny < img[0].length) {
                    smooth += img[nx][ny];
                    items++;
                }
            }
        }
        // System.out.println(x+"-"+y+"-"+smooth+"-"+ items);

        return smooth  / items;
    }
}