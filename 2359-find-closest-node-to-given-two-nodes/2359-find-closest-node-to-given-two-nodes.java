class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();

        int dest = edges[node1];
        int distance = 0;
        map1.put(node1, 0);
        while (dest != -1) {
            map1.put(dest, ++distance);
            dest = edges[dest];
            if (map1.containsKey(dest))
                break;
        }

        dest = edges[node2];
        distance = 0;
        map2.put(node2, 0);
        while (dest != -1) {
            map2.put(dest, ++distance);

            dest = edges[dest];
            if (map2.containsKey(dest))
                break;
        }

        //System.out.println(map1);
        //System.out.println(map2);

        int minDistance = Integer.MAX_VALUE;
        int minNode = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> e1 : map1.entrySet()) {
            if (map2.containsKey(e1.getKey())) {
                int dis = Math.max(e1.getValue(), map2.get(e1.getKey()));
                if (dis == minDistance)
                    minNode = Math.min(minNode, e1.getKey());

                if (dis < minDistance) {
                    minNode = e1.getKey();
                    minDistance = dis;
                }
            }
        }

        return minNode;
    }
}