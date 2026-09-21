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
        // Soln 1 
        // TC : O(n)
        // SC : O(n) --> using freq arrayu

        // for khali list
        if (head == null) {
            return null;
        }

        // for head only
        if (head.next == null) {
            return head;
        }

        // sinze range is -100 to 100
        int[] freq = new int[201];

        // ye original LL ko traverse krne ke liye
        ListNode temp = head;

        // har value ki frequency count karo
        while (temp != null) {
            freq[temp.val + 100]++;
            temp = temp.next;
        }

        // dummy node banaya final answer LL ke liye
        ListNode newHead = new ListNode(0);

        // ye answer LL ko vo karne ke liye
        temp = newHead;

        // frequency array ko traverse karo
        for (int i = 0; i < freq.length; i++) {
            
            // agar value sirf ek baar present hai toh usko answer LL mein add karo
            if (freq[i] == 1) {
                // index se original value nikalo
                ListNode newNode = new ListNode(i - 100);

                // new node ko answer LL mein add karo
                temp.next = newNode;

                // temp ko newly added node pe move karo
                temp = temp.next;
            }
        }

        // dummy node ko skip karke actual answer return karo
        return newHead.next;
    }
}