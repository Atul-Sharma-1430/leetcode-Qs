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
    public ListNode deleteMiddle(ListNode head) {

        // if only head
        if (head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = head; // ye slow ke just ek pahle rhega cz slow mid pe point krehga but humko uske pahle wale ko slow ke next pe connect krna h

        // same concept as slow and fast pointer to reach middle
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // mid ke prev ko mid ke next pe connect kr do
        prev.next = slow.next;

        return head;
    }
}