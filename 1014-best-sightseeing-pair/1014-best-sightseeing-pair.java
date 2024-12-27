class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int prev_max = values[0] + 0;
        int res = prev_max + values[1] - 1;
        for (int j = 1; j < values.length; j++) {
            res = Math.max(prev_max + values[j] - j, res);
            prev_max = Math.max(values[j] + j, prev_max);
        }
        return res;
    }
}