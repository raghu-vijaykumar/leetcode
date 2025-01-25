class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int[] originalNums = nums.clone();
        Arrays.sort(nums);
        List<Queue<Integer>> q = new ArrayList<>();
        q.add(new LinkedList<Integer>());
        int index = 0;
        q.get(index).offer(nums[0]);
        HashMap<Integer, Integer> qMap = new HashMap<>();
        qMap.put(nums[0], index);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] > limit) {
                index++;
                q.add(new LinkedList<Integer>());
            }

            q.get(index).offer(nums[i]);
            qMap.put(nums[i], index);
        }

        //System.out.println(qMap);

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = q.get(qMap.get(originalNums[i])).poll();
        }

        return res;
    }
}