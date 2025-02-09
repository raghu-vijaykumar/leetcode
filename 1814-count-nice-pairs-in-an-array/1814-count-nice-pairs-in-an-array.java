class Solution {
    public int countNicePairs(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int MOD = 1_000_000_007;

        for (int num : nums) {
            int revNum = reverse(num);
            int diff = num - revNum;

            count = (count + map.getOrDefault(diff, 0)) % MOD;
            map.put(diff, (map.getOrDefault(diff, 0) + 1) % MOD);
        }

        return count;
    }

    private int reverse(int num) {
        int rev = 0;
        while (num > 0) {
            rev = rev * 10 + num % 10;
            num /= 10;
        }
        return rev;
    }
}
