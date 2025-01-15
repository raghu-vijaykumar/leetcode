class Solution {
    int min = Integer.MAX_VALUE;

    public int minScore(int n, int[][] roads) {
        HashMap<Integer, List<Integer[]>> map = new HashMap<>();

        for (int[] r : roads) {
            map.computeIfAbsent(r[0], x -> new ArrayList<Integer[]>()).add(new Integer[] { r[1], r[2] });
            map.computeIfAbsent(r[1], x -> new ArrayList<Integer[]>()).add(new Integer[] { r[0], r[2] });
        }
        boolean[] visited = new boolean[n + 1];
        dfs(1, map, visited);
        return min;
    }

    public void dfs(int node, HashMap<Integer, List<Integer[]>> map, boolean[] visited) {
        if (visited[node])
            return;

        visited[node] = true;

        for (Integer[] e : map.get(node)) {
            min = Math.min(min, e[1]);
            dfs(e[0], map, visited);
        }

    }
}