class Solution {
    Integer[] memo;
    public int countGoodStrings(int low, int high, int zero, int one) {
        memo = new Integer[high+1];
        return countGoodStrings(low, high, zero, one, 0);
    }

    public int countGoodStrings(int low, int high, int zero, int one, int currLen) {
        if (currLen > high)
            return 0;

        if(memo[currLen] != null) 
            return memo[currLen];

        int ways = 0;
        if (currLen >= low && currLen <= high)
            ways += 1;

        ways += countGoodStrings(low, high, zero, one, currLen + zero)
                + countGoodStrings(low, high, zero, one, currLen + one);

        memo[currLen] = ways % 1000000007;
        return memo[currLen];
    }
}