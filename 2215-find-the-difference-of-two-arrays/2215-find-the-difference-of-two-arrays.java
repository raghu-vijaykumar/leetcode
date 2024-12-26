class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        return Arrays.asList(new ArrayList<>(arrayDiff(nums1, nums2)), new ArrayList<>(arrayDiff(nums2, nums1)));
    }

    public HashSet<Integer> arrayDiff(int[] nums1, int[] nums2) {
        HashSet<Integer> n2Set = new HashSet<>();
        HashSet<Integer> diff = new HashSet<>();
        for (int n : nums2) {
            n2Set.add(n);
        }

        for (int n : nums1) {
            if (!n2Set.contains(n))
                diff.add(n);
        }

        return diff;
    }
}