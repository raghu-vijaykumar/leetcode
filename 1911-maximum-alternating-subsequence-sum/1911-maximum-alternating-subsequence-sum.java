class Solution {
    HashMap<String, Long> memo = new HashMap<>();

    public long maxAlternatingSum(int[] nums) {
        return maxAlternatingSum(nums, 0, true);
    }

    public long maxAlternatingSum(int[] nums, int i, boolean even) {
        if (i > nums.length - 1)
            return 0;
        String key = i + "-" + even;
        if (memo.containsKey(key))
            return memo.get(key);
        int currSum = 0;
        if (even) {
            currSum += nums[i];
        } else {
            currSum -= nums[i];
        }

        memo.put(key, Math.max(currSum + maxAlternatingSum(nums, i + 1, !even), maxAlternatingSum(nums, i + 1, even)));
        return memo.get(key);
    }
}