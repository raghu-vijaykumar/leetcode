/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode current = dummy.next;
        ListNode prev = dummy;

        while (current != null) {
            ListNode temp = current;
            current = current.next;
            if (set.contains(temp.val)) {
                temp.next = null;
                prev.next = current;
            } else {
                prev = prev.next;
            }
        }

        return dummy.next;
    }
}