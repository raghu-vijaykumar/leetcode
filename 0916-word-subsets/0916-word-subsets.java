class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> result = new ArrayList<>();

        int[][] w1 = new int[words1.length][26];
        for (int i = 0; i < words1.length; i++) {
            for (char c : words1[i].toCharArray()) {
                w1[i][c - 'a']++;
            }
        }

        int[][] w2 = new int[words2.length][26];
        for (int i = 0; i < words2.length; i++) {
            Arrays.fill(w2[i], -1);
            for (char c : words2[i].toCharArray()) {
                w2[i][c - 'a']++;
            }
            //System.out.println(Arrays.toString(w2[i]));
        }

        for (int i = 0; i < w1.length; i++) {
            boolean contains = true;
            for (int j = 0; j < w2.length && contains; j++) {
                for (int k = 0; k < 26; k++) {
                    if (w2[j][k] != -1 && w1[i][k] < w2[j][k] + 1) {
                        contains = false;
                        break;
                    }
                }
            }
            if (contains)
                result.add(words1[i]);
        }

        return result;

    }
}