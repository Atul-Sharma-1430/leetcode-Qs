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
    public ListNode deleteDuplicates(ListNode head) {

        // Soln 2
        // TC : O(n)
        // SC : O(1)
        if (head == null) {
            return null;
        }

        // dummy head rhega cz we need a st pt
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode temp = dummy; // to traverse

        while (head != null && head.next != null) {

            // agar duplicate mila
            if (head.val == head.next.val) {

                int duplicate = head.val; // duplicate value stored
                // jab tak same value hai skip krt rho
                while (head != null && head.val == duplicate) {
                    head = head.next;
                }

                // temp ko duplicate ke baad wale node pe point kr do
                temp.next = head;

            } else {
                // agar duplicate nahi hai toh dono ko move kro
                temp = temp.next;
                head = head.next;
            }
        }

        return dummy.next;















        // // Soln 1 
        // // TC : O(n)
        // // SC : O(n) --> using freq arrayu

        // // for khali list
        // if (head == null) {
        //     return null;
        // }

        // // for head only
        // if (head.next == null) {
        //     return head;
        // }

        // // sinze range is -100 to 100
        // int[] freq = new int[201];

        // // ye original LL ko traverse krne ke liye
        // ListNode temp = head;

        // // har value ki frequency count karo
        // while (temp != null) {
        //     freq[temp.val + 100]++;
        //     temp = temp.next;
        // }

        // // dummy node banaya final answer LL ke liye
        // ListNode newHead = new ListNode(0);

        // // ye answer LL ko build karne ke liye
        // temp = newHead;

        // // frequency array ko traverse karo
        // for (int i = 0; i < freq.length; i++) {

        //     // agar value sirf ek baar present hai toh usko answer LL mein add karo
        //     if (freq[i] == 1) {

        //         // index se original value nikalo
        //         ListNode newNode = new ListNode(i - 100);

        //         // new node ko answer LL mein add karo
        //         temp.next = newNode;

        //         // temp ko newly added node pe move karo
        //         temp = temp.next;
        //     }
        // }

        // // dummy node ko skip karke actual answer return karo
        // return newHead.next;
    }
}