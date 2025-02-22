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
    public List<Integer> inorderTraversal(TreeNode root) {
        Set<Integer> set = new LinkedHashSet<>();
        dfs(set, root);
        List<Integer> list = new ArrayList<>(set);
        return list;
    }
    public void dfs(Set<Integer> set, TreeNode node){
        if(node == null){
            return;
        }
        dfs(set, node.left);
        set.add(node.val);
        dfs(set, node.right);
    }
}