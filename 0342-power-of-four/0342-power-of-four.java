class Solution {
    public boolean isPowerOfFour(int n) {
        return (Math.log(n)/Math.log(4) * 10) % 10 == 0;
    }
}