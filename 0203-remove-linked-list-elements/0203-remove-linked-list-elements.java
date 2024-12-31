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
    public ListNode removeElements(ListNode head, int val) {
        ListNode prev = new ListNode(-1);
        prev.next = head;
        ListNode dummy = prev;

        ListNode curr = head;

        while (curr != null) {
            ListNode after = curr.next;
            if (curr.val == val) {
                prev.next = after;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }

        return dummy.next;

    }
}