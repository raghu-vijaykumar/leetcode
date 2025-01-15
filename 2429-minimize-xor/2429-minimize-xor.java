class Solution {
    public int minimizeXor(int num1, int num2) {
        int a = Integer.bitCount(num1), b = Integer.bitCount(num2), res = num1;
        //System.out.println(a+", "+ b);
        for (int i = 0; i < 32; ++i) {
            if (a > b && ((1 << i) & num1) > 0) {
                //System.out.println("1");
                res ^= 1 << i;
                a--;
            }
            if (a < b && ((1 << i) & num1) == 0) {
                //System.out.println("2");
                res ^= 1 << i;
                a++;
            }
        }
        return res;
    }
}