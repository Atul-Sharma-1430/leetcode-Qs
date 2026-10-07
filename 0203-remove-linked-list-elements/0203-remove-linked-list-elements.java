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
    public ListNode removeElements(ListNode head, int val) {

        if (head == null) {
            return null;
        }

        ListNode temp = head;

        while (temp != null) {

            // Agar head ki value val ke equal hai
            if (temp == head && temp.val == val) {
                // Head ko aage
                head = temp.next;

                // Temp ko bhi aage
                temp = temp.next;

                continue;
            }

            // Agar next node ki value same hhai
            if (temp.next != null && temp.next.val == val) {

                //toh usko skip kr do
                temp.next = temp.next.next;

                // agar ek baar uper skip kr diye toh niche dubra nhi skip krna 
                continue;
            }

            temp = temp.next;
        }

        return head;
    }
}
