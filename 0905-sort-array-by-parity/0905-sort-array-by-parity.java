class Solution {
    public int[] sortArrayByParity(int[] nums) {
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();

        for (int n : nums) {
            if (n % 2 == 0)
                even.add(n);
            else
                odd.add(n);
        }

        int i = 0;
        int e = even.size();
        int o = odd.size();
        while (i < e) {
            nums[i] = even.get(i);
            i++;
        }

        i = 0;
        while (i < o) {
            nums[e + i] = odd.get(i);
            i++;
        }

        return nums;
    }
}