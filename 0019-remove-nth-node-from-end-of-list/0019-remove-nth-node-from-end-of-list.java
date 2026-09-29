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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null) {
            return null;
        }

        int len = 0;
        ListNode temp = head;

        // total len
        while (temp != null) {
            len++;
            temp = temp.next;
        }

        // node to be deleted
        int node = len - n + 1;

        if (node == 1) {
            return head.next;
        }

        len = 0;
        temp = head;

        // go to node before that
        while (len != node - 2) {
            len++;
            temp = temp.next;
        }

        // delete connextion
        temp.next = temp.next.next;

        return head;
    }
}