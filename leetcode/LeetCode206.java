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
        
        ListNode prev = null;

        while (head != null) {
            ListNode temp = head.next;   

            if (temp == null) {
                head.next = prev;
                return head;
            }
            
            if (prev == null) {
                prev = head;
                head.next = null;
                head = temp;
            }

            else {
                head.next = prev;
                prev = head;
                head = temp;
            }
        }

        return head;
    }
}
