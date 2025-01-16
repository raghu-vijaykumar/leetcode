class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int res = 0;
        if (nums1.length % 2 == 1) {
            for (int i = 0; i < nums2.length; i++) {
                res ^= nums2[i];
            }
        }
        if (nums2.length % 2 == 1) {
            for (int j = 0; j < nums1.length; j++) {
                res ^= nums1[j];
            }
        }
        return res;
    }
}