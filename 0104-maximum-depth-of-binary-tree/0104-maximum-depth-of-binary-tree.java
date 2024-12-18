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
    private int max = 0;
    public int maxDepth(TreeNode root) {
        maxDepthHelper(root,0);
        return max;
    }
    public void maxDepthHelper(TreeNode node, int depth){
        if(node == null) {max = Math.max(depth,max); return;}
        maxDepthHelper(node.left, depth+1);
        maxDepthHelper(node.right, depth+1);
    }
}