class Solution {
    public long mostPoints(int[][] questions) {
        Long[] memo = new Long[questions.length];
        return mostPoints(questions, 0, memo);
    }

    public long mostPoints(int[][] questions, int i, Long[] memo) {
        if (i > questions.length - 1)
            return 0;

        if (memo[i] != null)
            return memo[i];

        long take = questions[i][0] + mostPoints(questions, i + 1 + questions[i][1], memo);
        long skip = mostPoints(questions, i + 1, memo);
        memo[i] = Math.max(take, skip);
        return memo[i];
    }
}