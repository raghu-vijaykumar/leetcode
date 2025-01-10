class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> result = new ArrayList<>();

        int[][] w1 = new int[words1.length][26];
        for (int i = 0; i < words1.length; i++) {
            for (char c : words1[i].toCharArray()) {
                w1[i][c - 'a']++;
            }
        }

        int[] w2 = new int[26];
        Arrays.fill(w2, -1);
        for (int i = 0; i < words2.length; i++) {
            int[] temp = counter(words2[i]);
            for (int j = 0; j < 26; j++) {
                w2[j] = Math.max(w2[j], temp[j]);
            }
        }
        //System.out.println(Arrays.toString(w2));

        for (int i = 0; i < w1.length; i++) {
            boolean contains = true;
            for (int k = 0; k < 26; k++) {
                if (w2[k] != -1 && w1[i][k] < w2[k] + 1) {
                    contains = false;
                    break;
                }
            }
            if (contains)
                result.add(words1[i]);
        }

        return result;

    }

    public int[] counter(String s) {
        int[] counter = new int[26];
        Arrays.fill(counter, -1);
        for (char c : s.toCharArray()) {
            counter[c - 'a']++;
        }
        return counter;
    }
}