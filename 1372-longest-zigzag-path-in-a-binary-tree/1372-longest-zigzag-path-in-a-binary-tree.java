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
    public int longestZigZag(TreeNode root) {
        dfs(root.left, Dir.left, 1);
        dfs(root.right, Dir.right, 1);
        return answer;
    }
    public void dfs(TreeNode node, Dir dir, int depth){
        if(node == null) { answer = Math.max(depth - 1, answer); return;}
        if(dir.equals(Dir.left)){
            dfs(node.right, Dir.right, depth +1);
            dfs(node.left, Dir.left, 1);
        }
        else{
            dfs(node.left, Dir.left, depth +1);
            dfs(node.right, Dir.right, 1);
        }
    }
}
enum Dir{
    left,right;
}