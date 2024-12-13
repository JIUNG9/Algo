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
    private TreeNode cache;
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null) return null;
        if(root.val == val) {
            cache = root;
        }
        searchBST(root.left,val);
        searchBST(root.right,val);
        return cache;
    }
    }