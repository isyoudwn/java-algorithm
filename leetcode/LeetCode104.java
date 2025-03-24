/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {

        return bfs(root);
    }

    public int bfs(TreeNode start) {

        if (start == null) {
            return 0;
        }

        Deque<TreeNode> dq = new ArrayDeque<>();
        Map<TreeNode, Integer> dist = new HashMap<>();

        dq.add(start);
        dist.put(start, 1);

        while (!dq.isEmpty()) {
            TreeNode now = dq.removeFirst();

            if (now.left != null && !dist.containsKey(now.left)) {
                dq.add(now.left);
                dist.put(now.left, dist.get(now) + 1);
            }

            if (now.right != null && !dist.containsKey(now.right)) {
                dq.add(now.right);
                dist.put(now.right, dist.get(now) + 1);
            }
        }

        return Collections.max(dist.values());
    }
}