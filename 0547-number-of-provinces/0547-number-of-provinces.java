class Solution {
    public int findCircleNum(int[][] isConnected) {
        int count = isConnected.length;
        for(int i = 0;i< isConnected.length;i++) {
            for(int j = i + 1;j< isConnected[0].length;j++) {
                if(isConnected[i][j] == 1)
                    count--;
            }
        }
        return count <= 0? 1: count;
    }
}