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
    public boolean isPalindrome(ListNode head) {

        // calculate length first
        ListNode temp = head;
        int len = 0;

        while (temp != null) {
            temp = temp.next;
            len++;
        }

        if (len == 1) {
            return true;
        }

        // array to store half elements
        int[] array = new int[len / 2];

        // using slow fast ptr reach middle
        ListNode slow = head;
        ListNode fast = head;

        int i = 0;
        while (fast != null && fast.next != null) {
            array[i++] = slow.val;
            slow = slow.next;
            fast = fast.next.next;
        }

        // odd length mein middle element skip 
        if (len % 2 != 0) {
            slow = slow.next;
        }

        // i from last index of array
        i = array.length - 1;

        // compare elem from end of array with next nodes from middle
        while (slow != null) {
            if (slow.val != array[i--]) {
                return false;
            }
            slow = slow.next;
        }

        return true;
    }
}