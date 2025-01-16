class Solution {
    public int integerReplacement(int n) {
        return (int) integerReplacementHelper((long) n);
    }

    public long integerReplacementHelper(long n) {
        if (n == 1)
            return 0;
        long minOps = 0;
        if (n % 2 == 0)
            minOps = 1 + integerReplacementHelper(n / 2);
        else
            minOps = 2 + Math.min(integerReplacementHelper((n + 1) / 2), integerReplacementHelper((n - 1) / 2));
        return minOps;
    }

}