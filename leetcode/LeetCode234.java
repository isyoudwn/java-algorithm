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
        // 100000 0(n)
        Deque<Integer> deque = new ArrayDeque<>();
        ListNode nextNode = head;
        
        while (true) {
            if (nextNode == null) {
                break;
            }
            deque.add(nextNode.val);
            nextNode = nextNode.next;
        }

        while (deque.size() > 1) {
            int front = deque.removeFirst();
            int back = deque.removeLast();

            if (front != back) {
                return false;
            }
        }

        return true;
    }
}
