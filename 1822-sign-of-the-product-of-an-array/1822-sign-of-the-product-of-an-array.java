class Solution {
    public int arraySign(int[] nums) {
        int signCount = 0;
        for (int n : nums) {
            if (n < 0)
                signCount++;
            if (n == 0)
                return 0;
        }
        return signFunc(signCount);
    }

    public int signFunc(int x) {
        return x % 2 == 0 ? 1 : -1;
    }
}