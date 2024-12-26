class Solution {
    Integer[][] memo;
    int sum = 0;
    public int findTargetSumWays(int[] nums, int target) {
        sum = Arrays.stream(nums).sum();
        memo = new Integer[nums.length][2*sum + 1];
        return findTargetWays(nums, 0, target, 0);
    }

    public int findTargetWays(int[] nums, int i, int target, int current) {
        if (target == current && i == nums.length)
            return 1;

        if (i > nums.length - 1)
            return 0;

        if(memo[i][sum + current] != null) return memo[i][sum+current];

        int ways = findTargetWays(nums, i + 1, target, current - nums[i]) + findTargetWays(nums, i + 1, target, current + nums[i]);
        memo[i][sum + current] = ways;
        return ways;
    }
}