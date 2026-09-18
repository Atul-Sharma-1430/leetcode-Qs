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

        // Soltuion 1 
        // TC : O(n)
        // SC : O(ansLL.size)

        // for khali list
        if (head == null) {
            return null;
        }

        // for hd only
        if (head.next == null) {
            return head;
        }

        ListNode temp = head;

        // since array is sorted so we can use prev variable to track prev value;
        int prev = temp.val;

        // ans list
        ListNode ans = new ListNode(temp.val);
        // to trck ans LL
        ListNode temp2 = ans;

        while (temp != null) {

            // agar value already present hai toh duplicate hai, isliye skip karo
            if (temp.val == prev) {
                prev = temp.val;
                temp = temp.next;
                continue;
            }

            prev = temp.val;

            // make new node and add too ans
            ListNode newNode = new ListNode(temp.val);
            temp2.next = newNode;
            temp = temp.next;
            temp2 = temp2.next;
        }

        return ans;






        // Soltuion 1 
        // TC : O(n)
        // SC : O(201) + O(ansLL.size)

        // // for khali list
        // if (head == null) {
        //     return null;
        // }

        // // for hd only
        // if (head.next == null) {
        //     return head;
        // }

        // // values -100 se 100 tak ho sakti hain isliye index ke liye +100 kiya
        // boolean[] wasPresent = new boolean[201];

        // ListNode temp = head;

        // // mark that head is alrady prsnt cz vo anyhow rhega hi
        // wasPresent[temp.val + 100] = true;

        // // ans list
        // ListNode ans = new ListNode(temp.val);
        // // to trck ans LL
        // ListNode temp2 = ans;

        // while (temp != null) {

        //     // agar value already present hai toh duplicate hai, isliye skip karo
        //     if (wasPresent[temp.val + 100]) {
        //         temp = temp.next;
        //         continue;
        //     }

        //     // value ko present mark karo
        //     wasPresent[temp.val + 100] = true;

        //     // make new node and add too ans
        //     ListNode newNode = new ListNode(temp.val);
        //     temp2.next = newNode;
        //     temp = temp.next;
        //     temp2 = temp2.next;
        // }

        // return ans;
    }
}