class Solution {
    int res = 0;

    public int subsetXORSum(int[] nums) {
        List<Integer> step = new ArrayList<>();
        dfs(nums, step, 0);
        return res;
    }

    public void dfs(int[] nums, List<Integer> step, int i) {
        if (i > nums.length - 1) {
            //System.out.println(step);
            if (step.size() > 0) {
                int xor = step.get(0);
                for (int j = 1; j < step.size(); j++)
                    xor ^= step.get(j);
                res += xor;
            }
            return;
        }

        dfs(nums, new ArrayList<>(step), i + 1);
        step.add(nums[i]);
        dfs(nums, new ArrayList<>(step), i + 1);
    }
}