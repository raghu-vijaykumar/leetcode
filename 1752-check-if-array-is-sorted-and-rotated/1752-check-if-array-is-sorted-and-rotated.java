class Solution {
    public boolean check(int[] nums) {
        int dip = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[(i + 1) % nums.length]) {
                dip += 1;
            }
        }
        return dip > 1 ? false : true;
    }
}