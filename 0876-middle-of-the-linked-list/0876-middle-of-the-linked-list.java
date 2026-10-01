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
    public ListNode middleNode(ListNode head) {

        // Not optimal as traversing 2 times
        // totl len
        int len = 0;
        ListNode temp = head;

        while (temp != null) {
            temp = temp.next;
            len++;
        }

        // to reach mid
        int mid = 0;
        temp = head;

        while (mid != (len / 2)) {
            mid++;
            temp = temp.next;
        }

        return temp;
    }
}