/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        // idea : Current node mein next node ka data copy karo, phir next node ko skip kar do.
        // Next node ki value current node mein copy karenge
        node.val = node.next.val;

        // Next node ko skip kar denge
        node.next = node.next.next;
    }
}