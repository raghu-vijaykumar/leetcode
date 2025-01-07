class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] sh = new int[nums.length];
        int mid = nums.length / 2 - 1;
        int j = 0;
        for (int i = 0; i < nums.length - 1; i += 2) {
            sh[i] = nums[j++];
            sh[i + 1] = nums[j + mid];
        }
        return sh;
    }
}