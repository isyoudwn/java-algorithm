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
    int longest = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return longest;
    }

    public int dfs(TreeNode now) {
        if (now == null) {
            return -1;
        }

        int left = dfs(now.left);
        int right = dfs(now.right);

        // 2를 더하는 이유 : 왼쪽의 거리 + 오른쪽이 거리이기 떄문에
        longest = Math.max(longest, left + right + 2);
        return Math.max(left, right) + 1;
    }
}