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
    public ListNode reverseList(ListNode head) {

        // agar list empty hai toh null return karo
        if (head == null) {
            return null;
        }

        // agar sirf ek node hai toh wahi reverse list hogi
        if (head.next == null) {
            return head;
        }

        int count = 1;
        ListNode temp = head;

        // cnt total nodes in LL
        while (temp.next != null) {
            count++;
            temp = temp.next;
        }

        // to store data of each nod
        int[] array = new int[count];

        temp = head;
        int i = 0;

        // storing vals of LL in arry
        while (temp != null) {
            array[i++] = temp.val;
            temp = temp.next;
        }

        // travrsing arry from back and making a new node for each data
        i = array.length - 1;

        ListNode newHead = new ListNode(array[i--]);
        ListNode newTemp = newHead;

        for (int j = i; j >= 0; j--) {
            ListNode newNode = new ListNode(array[j]);
            newTemp.next = newNode;
            newTemp = newNode;
        }

        return newHead;
    }
}