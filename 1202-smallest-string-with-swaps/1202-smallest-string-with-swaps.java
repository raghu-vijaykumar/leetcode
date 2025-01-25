class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if (pairs.size() == 0)
            return s;
        List<List<Integer>> connectedComponets = new ArrayList<>();
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        for (List<Integer> pair : pairs) {
            adjList.computeIfAbsent(pair.get(0), x -> new ArrayList<>()).add(pair.get(1));
            adjList.computeIfAbsent(pair.get(1), x -> new ArrayList<>()).add(pair.get(0));
        }

        HashSet<Integer> visited = new HashSet<>();
        for (int node : adjList.keySet()) {
            if (!visited.contains(node)) {
                List<Integer> connected = new ArrayList<>();
                dfs(adjList, node, connected, visited);
                connectedComponets.add(connected);
            }
        }

        adjList.clear();
        //System.out.println(connectedComponets);

        List<ArrayDeque<Character>> qs = new ArrayList<>();
        HashMap<String, Integer> qsMap = new HashMap<>();
        for (int i = 0; i < connectedComponets.size(); i++) {
            List<Character> c = new ArrayList<>();
            for (int n : connectedComponets.get(i)) {
                c.add(s.charAt(n));
                qsMap.put(s.charAt(n) + "-" + n, i);
            }
            Collections.sort(c);
            qs.add(new ArrayDeque(c));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            Integer index = qsMap.get(s.charAt(i) + "-" + i);
            if (index != null)
                sb.append(qs.get(index).pop());
            else
                sb.append(s.charAt(i));
        }

        return sb.toString();
    }

    public void dfs(HashMap<Integer, List<Integer>> adjList, int node, List<Integer> connected,
            HashSet<Integer> visited) {
        if (visited.contains(node))
            return;
        visited.add(node);
        connected.add(node);
        for (int nei : adjList.getOrDefault(node, Collections.emptyList())) {
            dfs(adjList, nei, connected, visited);
        }
    }
}