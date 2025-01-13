class Solution {
    public int minimumLength(String s) {
        if (s.length() < 3)
            return s.length();

        int[] map = new int[26];
        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }
        //System.out.println(Arrays.toString(map));
        int minLength = 0;
        for (int i = 0; i < 26; i++) {
            if (map[i] >= 3) {
                minLength += map[i] % 2 == 0 ? 2 : 1;
            } else {
                minLength += map[i];
            }
        }
        return minLength;
    }
}