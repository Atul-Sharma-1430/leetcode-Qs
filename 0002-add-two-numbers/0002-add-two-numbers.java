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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int carry = 0;

        // ans node answer linked list ke liye
        // isme ans head nhi rhega ans.next head rhega kyuki abhi koi data add nhi kiye but ek node bna diye hain
        ListNode ans = new ListNode();

        // temp traverse krne ke liye
        ListNode temp = ans;

        // Jab tak dono lists mein nodes khtm na ho jaaye
        while (l1 != null || l2 != null) {

            // ye dono ko bahar hi initial;ize krna padega kyuki if ke andar krenge toh bahar use nhi kr payenge
            int data1 = 0;
            int data2 = 0;

            // Agar l1 mein node hai toh uska data lenge
            if (l1 != null) {
                data1 = l1.val;
            }

            // Agar l2 mein node hai toh uska data lenge
            if (l2 != null) {
                data2 = l2.val;
            }

            // Dono data aur previous carry ko add karenge
            int sum = data1 + data2 + carry;

            // Current digit nikalenge
            int val = sum % 10;

            // Next addition ke liye carry nikalenge
            carry = sum / 10;

            // Answer list mein current value ka node add karenge
            temp.next = new ListNode(val);

            // Temp ko newly created node par move karenge
            temp = temp.next;

            // Agar l1 khtm nhi hua hai toh l1 ko next node par move karenge
            if (l1 != null) {
                l1 = l1.next;
            }

            // Agar l2 khtm nhi hua hai toh l2 ko next node par move karenge
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        // Agar last me dono num ko jodne pe carry generate hua toh usko bhi add krna padega 
        if (carry != 0) {
            temp.next = new ListNode(carry);
        }

        // ans.next ko as head bhejenge kyuki first wala node null rhega
        return ans.next;
    }
}