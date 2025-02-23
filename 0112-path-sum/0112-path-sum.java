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
    private boolean answer = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
     if(root == null) return false;
       dfs(root, 0,targetSum);
       return answer;
    }
    public void dfs(TreeNode root, int crntSum, int targetSum){
        if(root == null) return;
        if(root!= null && root.left == null && root.right == null){
            if(crntSum + root.val == targetSum) answer = true;
        }
        dfs(root.left, crntSum+root.val, targetSum);
        dfs(root.right, crntSum+root.val, targetSum);
    }
}