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
    private int answer = 0;
    public int maxDepth(TreeNode root) {
        dfs(root, 0);
        return answer;
    }
    public void dfs(TreeNode node, int depth){
        if(node == null) {answer =Math.max(depth, answer); return;}
        dfs(node.left, depth+1);
        dfs(node.right, depth+1);
    }
}