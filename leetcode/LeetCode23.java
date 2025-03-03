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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.val, o2.val));

        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }

        ListNode root = new ListNode(0);
        ListNode tail = root;
        
        while (!queue.isEmpty()) {
            ListNode minNode = queue.poll();
            tail.next = minNode; 
            tail = minNode;
            
            if (minNode.next != null) {
                queue.add(minNode.next);
            }
        }
        
        return root.next;
    }
}
