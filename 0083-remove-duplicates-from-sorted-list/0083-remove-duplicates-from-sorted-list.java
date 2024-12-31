/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        prev.next  = head;
        ListNode curr = head;

        while(curr != null) {
            if(prev.val != curr.val) {
                prev = prev.next;
                curr = curr.next;
            } else {
                curr = curr.next;
                prev.next = curr;
            }
        }

        return dummy.next;
    }
}