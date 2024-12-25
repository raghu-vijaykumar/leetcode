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
    public List<Integer> largestValues(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        PriorityQueue<TreeNode> pq = new PriorityQueue<>((a, b) -> Long.compare(b.val, a.val));
        List<Integer> result = new ArrayList<>();
        pq.add(root);
        while (!pq.isEmpty()) {
            int size = pq.size();
            result.add(pq.peek().val);
            List<TreeNode> nodeToAdd = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = pq.poll();
                if (node.left != null)
                    nodeToAdd.add(node.left);
                if (node.right != null)
                    nodeToAdd.add(node.right);
            }
            pq.addAll(nodeToAdd);
        }

        return result;

    }
}