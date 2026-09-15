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
    // TC : O(N * M)
    // SC : O(1)
class Solution {
    public int numComponents(ListNode head, int[] nums) {

        // Linked List ko traverse karne ke liye
        ListNode temp = head;
        // Starting 0
        int count = 0;
        // Ye batayega ki hum already kisi connected component ke andar hain ya nahi
        boolean connected = false;

        while (temp != null) {

            // Current node ka data lenge
            int data = temp.val;
            // Current data arr me hai ki nhi ye uske liye
            boolean present = false;

            // Checking in array
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == data) {
                    // Data nums mein mil gaya
                    present = true;
                    break;
                }
            }

            // Agar present hai
            if (present) {
                // Aur pehle se connected nahi the toh naya component start hua
                if (!connected) {
                    count += 1;
                }

                // Current node connection ke part me aa jaayega
                connected = true;

            } else {
                // Agar current data nums mein nahi hai toh connection break ho jayega
                connected = false;
            }

            // Next node par move karenge
            temp = temp.next;
        }

        return count;
    }
}