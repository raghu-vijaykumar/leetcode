class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int[] res = new int[s.length() + 1];

        for (int[] shift : shifts) {
            res[shift[1] + 1] = shift[2] == 1 ? res[shift[1] + 1] + 1 : res[shift[1] + 1] - 1;
            res[shift[0]] = shift[2] == 1 ? res[shift[0]] - 1 : res[shift[0]] + 1;
        }

        //System.out.println(Arrays.toString(res));

        int diff = (res[res.length - 1] + 26) % 26;
        StringBuilder sb = new StringBuilder();
        for (int i = res.length - 2; i >= 0; i--) {
            sb.append((char) ('a' + (s.charAt(i) - 'a' + diff) % 26));
            diff += (res[i] + 26) % 26;
        }

        return sb.reverse().toString();
    }
}