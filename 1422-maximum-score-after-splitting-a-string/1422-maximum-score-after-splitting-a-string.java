class Solution {
    public int maxScore(String s) {
        int[] l = new int[s.length()];
        int[] r = new int[s.length()];
        l[0] = s.charAt(0) == '0' ? 1 : 0;
        for (int i = 1; i < s.length(); i++) {
            l[i] = s.charAt(i) == '0' ? l[i - 1] + 1 : l[i - 1];
        }

        r[s.length() - 1] = s.charAt(s.length() - 1) == '1' ? 1 : 0;
        for (int i = s.length() - 2; i >= 0; i--) {
            r[i] = s.charAt(i) == '1' ? r[i + 1] + 1 : r[i + 1];
        }

        int max = 0;
        //System.out.println(Arrays.toString(l));
        for (int i = 0; i < s.length()-1; i++) {
            max = Math.max(max, l[i] + r[i+1]);
        }
        return max;
    }
}