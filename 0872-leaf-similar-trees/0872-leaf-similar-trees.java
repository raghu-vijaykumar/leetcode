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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> res1 = dfs(root1, new ArrayList<>());
        List<Integer> res2 = dfs(root2, new ArrayList<>());
        return res1.equals(res2);
    }

    public List<Integer> dfs(TreeNode node, List<Integer> result) {
        if (node == null)
            return result;
        if (node.left == null && node.right == null)
            result.add(node.val);

        dfs(node.left, result);
        dfs(node.right, result);
        return result;
    }
}