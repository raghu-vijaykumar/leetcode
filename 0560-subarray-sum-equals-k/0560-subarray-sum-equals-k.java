class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] ps = new int[nums.length + 1];
        ps[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            ps[i + 1] = ps[i] + nums[i];
        }

        System.out.println(Arrays.toString(ps));

        int count = 0;
        for (int m =1 ; m < ps.length; m++) {
            for (int n = m; n < ps.length; n++) {
                //System.out.println(ps[n-m] + "-" + ps[n] +"=" +  (ps[n] - ps[n - m]));
                if (ps[n] - ps[n-m] == k)
                    count++;
            }
        }

        return count;
    }
}