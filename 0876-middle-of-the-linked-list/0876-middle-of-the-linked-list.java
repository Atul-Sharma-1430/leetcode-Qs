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

        // Optimla - slow fast pointr
        ListNode slow = head;
        ListNode fast = head;

        // as fast double traverl kr rha hai toh jab fast last me pahuchega tab slow half wale pe rhega 
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;








        // // Not optimal as traversing 2 times
        // // totl len
        // int len = 0;
        // ListNode temp = head;

        // while (temp != null) {
        //     temp = temp.next;
        //     len++;
        // }

        // // to reach mid
        // int mid = 0;
        // temp = head;

        // while (mid != (len / 2)) {
        //     mid++;
        //     temp = temp.next;
        // }

        // return temp;
    }
}