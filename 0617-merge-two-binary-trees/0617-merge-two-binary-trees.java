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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return mergeTreesH(root1, root2);
    }

    public TreeNode mergeTreesH(TreeNode node1, TreeNode node2) {
        TreeNode node = null;
        if (node1 != null && node2 != null) {
            node = new TreeNode(node1.val + node2.val);
            node.left = mergeTreesH(node1.left, node2.left);
            node.right = mergeTreesH(node1.right, node2.right);
        }
        else if (node1 != null && node2 == null) {
            node = new TreeNode(node1.val);
            node.left = mergeTreesH(node1.left, null);
            node.right = mergeTreesH(node1.right, null);
        }
        else if (node1 == null && node2 != null) {
            node = new TreeNode(node2.val);
            node.left = mergeTreesH(null, node2.left);
            node.right = mergeTreesH(null, node2.right);
        }
        
        return node;

    }
}