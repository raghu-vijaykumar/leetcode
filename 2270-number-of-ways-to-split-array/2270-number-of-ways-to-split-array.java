class Solution {
    public int waysToSplitArray(int[] nums) {
        long[] lps = new long[nums.length];
        lps[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            lps[i] = lps[i - 1] + nums[i];
        }

        long[] rps = new long[nums.length];
        rps[nums.length - 1] = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            rps[i - 1] = rps[i] + nums[i];
        }

        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (lps[i] >= rps[i])
                count++;
        }

        return count;

    }
}