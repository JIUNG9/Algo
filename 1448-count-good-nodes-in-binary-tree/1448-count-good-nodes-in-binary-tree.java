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
    private int answer =0;
    public int goodNodes(TreeNode root) {
        dfs(root.val, root);
        return answer;
    }
    public void dfs(int routeMax, TreeNode node){
        if(node == null) return;
        if(routeMax <= node.val) answer++;
        dfs(Math.max(node.val, routeMax), node.left);
        dfs(Math.max(node.val, routeMax), node.right);
    }
}