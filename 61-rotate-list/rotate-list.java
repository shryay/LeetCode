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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        int len = 1;
        ListNode temp = head;
        while (temp.next != null) {
            len++;
            temp = temp.next;
        }
        k = k % len;
        if (k == 0)
        return head;
        ListNode t = head;
        for (int i = 0; i < len - k - 1; i++) {
            t = t.next;
        }
        ListNode newhead = t.next;
        t.next = null;
        temp.next = head;
        return newhead;
    }
}
// 1 2 3 4 5
// 0 1 2 3 4 
