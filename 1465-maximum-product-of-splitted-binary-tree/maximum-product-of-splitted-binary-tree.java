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
    private static final int MOD = 1_000_000_007;
    long totalSum = 0;
    long maxProduct = 0;
    public int maxProduct(TreeNode root) {
        totalSum = treeSum(root);
        dfs(root);
        return (int) (maxProduct % MOD);
    }
    private long treeSum(TreeNode node) {
        if (node == null) return 0;
        return node.val + treeSum(node.left) + treeSum(node.right);
    }
    private long dfs(TreeNode node) {
        if (node == null) return 0;
        long left = dfs(node.left);
        long right = dfs(node.right);
        long subSum = node.val + left + right;
        long product = subSum * (totalSum - subSum);
        maxProduct = Math.max(maxProduct, product);
        return subSum;
    }
}