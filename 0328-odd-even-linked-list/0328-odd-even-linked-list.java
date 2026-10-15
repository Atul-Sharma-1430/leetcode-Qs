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
        // agar kuch nhi hua toh
        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = head; // odd indexs ko connect kregi
        ListNode oddHead = odd; // odd index ka head ans return krne ke liye
        ListNode even = head.next; // even indexes ko connect kregi
        ListNode evenHead = even; // last wale odd index ko even ke first index se connect krne ke liye

        while (even != null && even.next != null) {
            // 1st ko 3rd se connect kro
            odd.next = odd.next.next;
            // 2nd ko 4th se 
            even.next = even.next.next;

            // then odd and even uske new next pe move honge
            odd = odd.next;
            even = even.next;
        }

        // last odd ko even ke head se connect
        odd.next = evenHead;

        return oddHead;



















        // // ans LL
        // ListNode ans = new ListNode(0);

        // ListNode temp = head; // traverse original LL
        // ListNode temp2 = ans; // traverse ans LL

        // int count = 1; // determines the position

        // // Odd position nodes
        // while (temp != null) {

        //     if (count % 2 == 1) {
        //         int data = temp.val;

        //         ListNode newNode = new ListNode(data);
        //         temp2.next = newNode;
        //         temp2 = temp2.next;
        //     }

        //     count++;
        //     temp = temp.next;
        // }

        // temp = head;
        // count = 1;

        // // Even position nodes
        // while (temp != null) {

        //     if (count % 2 == 0) {
        //         int data = temp.val;

        //         ListNode newNode = new ListNode(data);
        //         temp2.next = newNode;
        //         temp2 = temp2.next;
        //     }

        //     count++;
        //     temp = temp.next;
        // }

        // return ans.next;
    }
}