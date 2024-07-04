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
    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode newListTail = dummy;
        ListNode curr = head.next;
        int sum = 0;
        while (curr != null) {
            if (curr.val != 0) {
                sum += curr.val;
            }
            else {
                newListTail.next = new ListNode(sum);
                newListTail = newListTail.next;
                sum = 0;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}