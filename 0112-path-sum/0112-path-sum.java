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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return hasPathSum(root, targetSum, 0);
    }

    public boolean hasPathSum(TreeNode root, int targetSum, int currentSum) {
        if (root == null)
            return false;

        if (targetSum == currentSum + root.val && root.left == null && root.right == null)
            return true;

        boolean flag = false;

        flag = hasPathSum(root.left, targetSum, currentSum + root.val);
        if (flag)
            return true;
        flag = hasPathSum(root.right, targetSum, currentSum + root.val);
        if (flag)
            return true;

        return false;
    }
}