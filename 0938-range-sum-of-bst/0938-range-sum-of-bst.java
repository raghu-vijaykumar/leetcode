/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        return rangeSumBSTH(root, low, high);
    }

    public int rangeSumBSTH(TreeNode root, int low, int high) {
        int rangeSum = 0;

        if (root == null)
            return rangeSum;

        if (low <= root.val && root.val <= high)
            rangeSum += root.val;

        rangeSum += rangeSumBSTH(root.left, low, high) + rangeSumBSTH(root.right, low, high);
        return rangeSum;
    }
}