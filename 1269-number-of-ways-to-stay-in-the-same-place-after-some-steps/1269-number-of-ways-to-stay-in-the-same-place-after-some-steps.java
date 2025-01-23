class Solution {
    private static final int MOD = 1000000007;
    private Long[][] memo;

    public int numWays(int steps, int arrLen) {
        int maxPos = Math.min(steps / 2 + 1, arrLen);
        memo = new Long[steps + 1][maxPos + 1];
        return (int) (dfs(steps, maxPos, 0) % MOD);
    }

    private long dfs(int steps, int arrLen, int pos) {
        if (steps == 0) {
            return pos == 0 ? 1 : 0;
        }
        if (pos < 0 || pos >= arrLen) {
            return 0;
        }
        if (memo[steps][pos] != null) {
            return memo[steps][pos];
        }

        long ways = (dfs(steps - 1, arrLen, pos) + dfs(steps - 1, arrLen, pos - 1) + dfs(steps - 1, arrLen, pos + 1))
                % MOD; // Move right

        memo[steps][pos] = ways;
        return ways;
    }
}