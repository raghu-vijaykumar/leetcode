class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>() {
            {
                put('I', 1);
                put('V', 5);
                put('X', 10);
                put('L', 50);
                put('C', 100);
                put('D', 500);
                put('M', 1000);
            }
        };

        int val = map.get(s.charAt(s.length() -1));
        for (int i = s.length() - 2; i >= 0; i--) {
            int c = map.get(s.charAt(i));
            if (map.get(s.charAt(i + 1)) > c)
                val -= c;
            else
                val += c;
        }
        return val;
    }
}