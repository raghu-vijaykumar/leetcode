/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Integer> inOrder = new ArrayList<>();
    public int minDiffInBST(TreeNode root) {
        inOrder(root);
        //System.out.println(inOrder);
        int min = Integer.MAX_VALUE;
        for(int i = 1;i<inOrder.size();i++) {
            min = Math.min(inOrder.get(i) - inOrder.get(i-1), min);
        }
        return min;

    }

    public void inOrder(TreeNode node) {
        if(node == null) return;
        inOrder(node.left);
        inOrder.add(node.val);
        inOrder(node.right);
    }
}