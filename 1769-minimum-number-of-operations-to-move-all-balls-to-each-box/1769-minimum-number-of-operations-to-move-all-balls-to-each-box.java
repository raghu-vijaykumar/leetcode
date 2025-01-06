class Solution {
    public int[] minOperations(String boxes) {
        char[] boxesArr = boxes.toCharArray();
        int len = boxesArr.length;

        int[] lps = new int[len];
        lps[0] = 0;
        int numballs = boxesArr[0] == '1' ? 1 : 0;
        for (int i = 1; i < len; i++) {
            lps[i] = lps[i - 1] + numballs;
            if (boxesArr[i] == '1')
                numballs++;
        }
        //System.out.println(Arrays.toString(lps));

        int[] rps = new int[len];
        rps[len - 1] = 0;
        numballs = boxesArr[len - 1] == '1' ? 1 : 0;
        for (int i = len - 2; i >= 0; i--) {
            rps[i] = rps[i + 1] + numballs;
            if (boxesArr[i] == '1')
                numballs++;
        }
        //System.out.println(Arrays.toString(rps));
        int[] result = new int[len];
        IntStream.range(0, len)
                .forEach(i -> result[i] = lps[i] + rps[i]);
        return result;
    }
}