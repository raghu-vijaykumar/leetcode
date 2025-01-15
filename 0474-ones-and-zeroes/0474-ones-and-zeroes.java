import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        // Use a memoization map to cache results for specific states
        Map<String, Integer> memo = new HashMap<>();
        return findMaxFormHelper(strs, m, n, 0, memo);
    }

    private int findMaxFormHelper(String[] strs, int m, int n, int index, Map<String, Integer> memo) {
        if (index == strs.length) {
            return 0; // Base case: no more strings to process
        }

        // Create a unique key for the current state
        String key = m + "," + n + "," + index;

        // If the result is already computed, return it
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // Count the number of zeros and ones in the current string
        int zeros = 0, ones = 0;
        for (char c : strs[index].toCharArray()) {
            if (c == '0') zeros++;
            else ones++;
        }

        // Option 1: Skip the current string
        int skip = findMaxFormHelper(strs, m, n, index + 1, memo);

        // Option 2: Take the current string (if it fits)
        int take = 0;
        if (m >= zeros && n >= ones) {
            take = 1 + findMaxFormHelper(strs, m - zeros, n - ones, index + 1, memo);
        }

        // Store the result in the memo map and return the maximum
        int result = Math.max(skip, take);
        memo.put(key, result);

        return result;
    }
}
