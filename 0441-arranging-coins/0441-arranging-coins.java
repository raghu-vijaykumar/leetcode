class Solution {
    public int arrangeCoins(int n) {
        long l = 0;
        long r = (long) Math.sqrt(2.0 * Integer.MAX_VALUE) - 1;
        while (l <= r) {
            long m = l + (r - l) / 2;
            long coins = m * (m + 1) / 2;
            if (coins == n)
                return (int) m;
            else if (coins < n)
                l = m + 1;
            else
                r = m - 1;
        }
        return (int) l - 1;
    }
}