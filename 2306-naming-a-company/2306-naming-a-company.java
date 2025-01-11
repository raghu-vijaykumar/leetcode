class Solution {
    public long distinctNames(String[] ideas) {
        HashMap<Character, HashSet<String>> map = new HashMap<>();
        for (String idea : ideas) {
            map.computeIfAbsent(idea.charAt(0), x -> new HashSet()).add(idea.substring(1));
        }

        long count = 0;
        for (Map.Entry<Character, HashSet<String>> e1 : map.entrySet()) {
            for (Map.Entry<Character, HashSet<String>> e2 : map.entrySet()) {
                if (e1.getKey() != e2.getKey()) {
                    HashSet<String> s1 = e1.getValue();
                    HashSet<String> s2 = e2.getValue();
                    HashSet<String> s3 = new HashSet<>(s1);
                    s3.retainAll(s2);
                    //System.out.println(s3);
                    count += (s1.size() - s3.size()) * (s2.size() - s3.size());
                }
            }
        }
        return count;
    }
}