class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] charOrder = new int[26];
        for (int i = 0; i < order.length(); i++) {
            charOrder[order.charAt(i) - 'a'] = i;
        }

        for (int j = 1; j < words.length; j++) {
            int k = 0;
            String first = words[j - 1];
            String second = words[j];
            while (true) {
                if (k >= first.length()) break;

                if (k >= second.length()) return false;

                if (charOrder[first.charAt(k) - 'a'] < charOrder[second.charAt(k) - 'a']) break;

                else if (charOrder[first.charAt(k) - 'a'] > charOrder[second.charAt(k) - 'a']) return false;
                else k++;

            }

        }

        return true;
    }
}