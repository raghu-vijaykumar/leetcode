class Solution {
    public int numOfSubarrays(int[] arr) {
        long[] osc = new long[arr.length];
        long[] esc = new long[arr.length];

        if (arr[0] % 2 == 0)
            esc[0] = 1;
        else
            osc[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                esc[i] = (esc[i - 1] + 1);
                osc[i] = osc[i - 1];
            } else {
                /// odd
                esc[i] = osc[i - 1];
                osc[i] = (esc[i - 1] + 1);
            }
        }
        return (int)(Arrays.stream(osc).sum() % 1_000_000_007);
    }
}
