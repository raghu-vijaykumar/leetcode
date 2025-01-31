class Solution {
    int[] parent;
    int[] rank;

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;
        HashMap<String, Integer> emailMap = new HashMap<>();
        int k = 0;
        for (List<String> account : accounts) {
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                if (emailMap.containsKey(email)) {
                    int acc = emailMap.get(email);
                    if (!isConnected(acc, k))
                        union(acc, k);
                } else {
                    emailMap.put(email, k);
                }
            }
            k++;
        }
        //System.out.println(emailMap);

        HashMap<Integer, List<String>> accMap = new HashMap<>();
        for (Map.Entry<String, Integer> e : emailMap.entrySet()) {
            accMap.computeIfAbsent(find(e.getValue()), x -> new ArrayList<>()).add(e.getKey());
        }
        //System.out.println(accMap);
        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> e : accMap.entrySet()) {
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(e.getKey()).get(0));
            Collections.sort(e.getValue());
            temp.addAll(e.getValue());
            res.add(temp);
        }
        return res;
    }

    public int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }

    public void union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);

        if (rank[parentX] > rank[parentY])
            parent[parentY] = parentX;
        else if (rank[parentX] < rank[parentY])
            parent[parentX] = parentY;
        else {
            parent[parentX] = parentY;
            rank[parentY]++;
        }
    }
}