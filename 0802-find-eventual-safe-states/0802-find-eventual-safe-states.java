class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        HashMap<Integer, Boolean> safe = new HashMap<Integer, Boolean>();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (dfs(graph, i, safe))
                res.add(i);
        }
        return res;
    }

    public boolean dfs(int[][] graph, int i, HashMap<Integer, Boolean> safe) {

        if (safe.containsKey(i))
            return safe.get(i);
        safe.put(i, false);

        for (int nei : graph[i]) {
            if (!dfs(graph, nei, safe)) {
                return safe.get(i);
            }
        }

        safe.put(i, true);
        return safe.get(i);

    }
}