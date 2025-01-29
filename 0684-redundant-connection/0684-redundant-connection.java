class Solution {

    class DisjointSet {

        int[] parent;
        int[] rank;

        public DisjointSet(int n) {
            parent = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }

        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY)
                return;

            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootY] > rank[rootX]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }

        }

        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        // in a disjoint Set if both already belong to the same root then its redundan
        // connection
        DisjointSet ds = new DisjointSet(1001);
        for (int[] edge : edges) {
            if (ds.connected(edge[0], edge[1]))
                return edge;
            else {
                ds.union(edge[0], edge[1]);
            }
        }
        return new int[2];
    }
}