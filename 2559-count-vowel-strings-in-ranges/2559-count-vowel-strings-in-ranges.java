class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        HashSet<Character> vowels = new HashSet<>();
        vowels.addAll(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        int[] prefix = new int[words.length + 1];
        prefix[0] = 0;
        for (int i = 0; i < words.length; i++) {
            prefix[i + 1] = vowels.contains(words[i].charAt(0))
                    && vowels.contains(words[i].charAt(words[i].length() - 1))
                            ? prefix[i] + 1
                            : prefix[i];
        }

        //System.out.println(Arrays.toString(prefix));

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = prefix[queries[i][1] + 1] - prefix[queries[i][0]];
        }
        return ans;
    }
}