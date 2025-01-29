class Solution {
    int[] parent;
    int[] rank;

    public int makeConnected(int n, int[][] connections) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;

        int connectedComponetCount = n;
        int extraConnections = 0;
        for (int i = 0; i < connections.length; i++) {
            if (isConnected(connections[i][0], connections[i][1]))
                extraConnections++;
            else {
                union(connections[i][0], connections[i][1]);
                connectedComponetCount--;
            }
        }

        return connectedComponetCount - 1 > extraConnections ? -1 : connectedComponetCount - 1;

    }

    public int find(int a) {
        if (parent[a] != a)
            parent[a] = find(parent[a]);
        return parent[a];
    }

    public boolean isConnected(int a, int b) {
        return find(a) == find(b);
    }

    public void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rank[rootA] < rank[rootB]) {
            parent[rootA] = rootB;
        } else if (rank[rootA] > rank[rootB]) {
            parent[rootB] = rootA;
        } else {
            parent[rootB] = rootA;
            rank[rootA]++;
        }
    }
}