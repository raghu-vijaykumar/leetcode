class Solution {
    public int[] sortedSquares(int[] nums) {
        // find the pivot
        int pivot = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < 0 && nums[i + 1] >= 0) {
                if (Math.abs(nums[i]) > Math.abs(nums[i + 1]))
                    pivot = i + 1;
                else
                    pivot = i;
            }
        }

        int[] sqrs = new int[nums.length];

        int l = pivot - 1;
        int r = pivot + 1;
        sqrs[0] = nums[pivot] * nums[pivot];
        int i = 1;
        while (true) {
            //System.out.println(l +"-"+ r);
            if (l >= 0 && r < nums.length && Math.abs(nums[l]) <= Math.abs(nums[r])) {
                sqrs[i++] = nums[l] * nums[l];
                l--;
            } else if (l >= 0 && r < nums.length && Math.abs(nums[l]) > Math.abs(nums[r])) {
                sqrs[i++] = nums[r] * nums[r];
                r++;
            } else {
                break;
            }
        }

        while(r<nums.length) {
            sqrs[i++] = nums[r] * nums[r];
            r++;
        }

        while(l>=0) {
            sqrs[i++] = nums[l] * nums[l];
            l--;
        }

        return sqrs;

    }
}