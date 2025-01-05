class Solution {
    public int findJudge(int n, int[][] trust) {
        if (n == 1)
            return 1;

        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] t : trust) {
            adjList.computeIfAbsent(t[1], x -> new ArrayList<>()).add(t[0]);
        }

        for (Map.Entry<Integer, List<Integer>> e : adjList.entrySet()) {
            if (e.getValue().size() == n - 1) {
                boolean found = true;
                for (Map.Entry<Integer, List<Integer>> e1 : adjList.entrySet()) {
                    if (e1.getKey() != e.getKey() && e1.getValue().contains(e.getKey()))
                        found = false;
                }
                if (found)
                    return e.getKey();
            }
        }

        return -1;
    }
}