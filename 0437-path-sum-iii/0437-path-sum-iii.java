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
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;
        dfs(root,0,targetSum);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        return answer;
    }
    public void dfs(TreeNode node , long sum, int target){
        if(node == null) return;
        if((sum + node.val) == target) answer++;

        dfs(node.left, sum + node.val, target);
        dfs(node.right, sum + node.val, target);
    }
}