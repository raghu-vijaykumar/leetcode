class Solution {
    public boolean backspaceCompare(String s, String t) {
        return convert(s).equals(convert(t));
    }

    private List<Character> convert(String s) {
        List<Character> res = new ArrayList<>();
        int backspace = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '#') {
                backspace++;
            } else if (backspace > 0) {
                backspace--;
            } else {
                res.add(s.charAt(i));
            }
        }
        return res;
    }
}