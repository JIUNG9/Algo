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
public class Solution {
    private int ans = 0; // Variable to keep count of good nodes

    // Public method that starts the depth-first search and returns the number of good nodes
    public int goodNodes(TreeNode root) {
        dfsHelper(root, Integer.MIN_VALUE);
        return ans;
    }

    // Helper method that performs a depth-first search on the tree
    private void dfsHelper(TreeNode node, int maxSoFar) {
        if (node == null) {
            return; // Base case: if the node is null, return
        }
        if (maxSoFar <= node.val) {
            // If the current value is greater than or equal to the maximum value so far,
            // it is a good node, so increment the counter and update the maximum value
            ans++;
            maxSoFar = node.val;
        }
        dfsHelper(node.left, maxSoFar); // Recursively call helper for left subtree
        dfsHelper(node.right, maxSoFar); // Recursively call helper for right subtree
    }
}