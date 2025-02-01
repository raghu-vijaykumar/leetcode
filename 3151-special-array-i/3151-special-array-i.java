class Solution {
    public boolean isArraySpecial(int[] nums) {
        boolean parity = nums[0] % 2 == 0;
        for (int i = 1; i < nums.length; i++) {
            boolean newParity = nums[i] % 2 == 0;
            if (newParity == parity)
                return false;
            else
                parity = newParity;
        }
        return true;
    }
}