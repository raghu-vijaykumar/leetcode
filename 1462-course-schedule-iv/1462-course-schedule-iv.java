class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();

        for (int[] p : prerequisites) {
            adjList.computeIfAbsent(p[1], x -> new ArrayList<>()).add(p[0]);
        }

        //System.out.println(adjList);
        HashMap<Integer, HashSet<Integer>> prereqList = new HashMap<>();
        for (int i = 0; i <= numCourses; i++) {
            HashSet<Integer> set = new HashSet<>();
            dfs(adjList, i, set);
            prereqList.put(i, set);
        }

        //System.out.println(prereqList);

        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            res.add(prereqList.get(queries[i][1]).contains(queries[i][0]));
        }

        return res;
    }

    public void dfs(HashMap<Integer, List<Integer>> adjList, Integer i, HashSet<Integer> preq) {
        for (int nei : adjList.getOrDefault(i, Collections.emptyList())) {
            preq.add(nei);
            dfs(adjList, nei, preq);
        }
    }
}