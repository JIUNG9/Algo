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
    private int answer = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        if(root == null) return answer;
        dfsRight(root, root.left);
        dfsLeft(root, root.right);
        getMinimumDifference(root.left);
        getMinimumDifference(root.right);
        return answer;
        
    }
    public void dfsRight(TreeNode root, TreeNode pointer){
        if(pointer == null) return;
        answer = Math.min(answer, Math.abs(root.val - pointer.val));
        dfsRight(root, pointer.right);
    }
     public void dfsLeft(TreeNode root, TreeNode pointer){
        if(pointer == null) return;
        answer = Math.min(answer, Math.abs(root.val - pointer.val));
        dfsLeft(root, pointer.left);
    }
    

}