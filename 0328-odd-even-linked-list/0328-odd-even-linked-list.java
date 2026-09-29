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
    public ListNode oddEvenList(ListNode head) {

        // ans LL
        ListNode ans = new ListNode(0);

        ListNode temp = head; // traverse original LL
        ListNode temp2 = ans; // traverse ans LL

        int count = 1; // determines the position

        // Odd position nodes
        while (temp != null) {

            if (count % 2 == 1) {
                int data = temp.val;

                ListNode newNode = new ListNode(data);
                temp2.next = newNode;
                temp2 = temp2.next;
            }

            count++;
            temp = temp.next;
        }

        temp = head;
        count = 1;

        // Even position nodes
        while (temp != null) {

            if (count % 2 == 0) {
                int data = temp.val;

                ListNode newNode = new ListNode(data);
                temp2.next = newNode;
                temp2 = temp2.next;
            }

            count++;
            temp = temp.next;
        }

        return ans.next;
    }
}