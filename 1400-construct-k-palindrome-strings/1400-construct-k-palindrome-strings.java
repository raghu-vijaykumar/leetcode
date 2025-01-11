class Solution {
    public boolean canConstruct(String s, int k) {
        if(s.length() < k) return false; 
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        //System.out.println(map);
        int numOfOddChars = 0;
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            if (e.getValue() % 2 == 1)
                numOfOddChars++;
        }

        return numOfOddChars <= k;
    }
}