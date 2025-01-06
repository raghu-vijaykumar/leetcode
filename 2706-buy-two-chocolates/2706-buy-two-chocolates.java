class Solution {
    public int buyChoco(int[] prices, int money) {
        int p1 = Integer.MAX_VALUE;
        int p2 = Integer.MAX_VALUE;

        for (int p : prices) {
            if (p < p1) {
                p2 = p1;
                p1 = p;

            } else {
                p2 = Math.min(p2, p);
            }
        }

        int rem = money - p1 - p2;
        return rem >= 0 ? rem : money;

    }
}