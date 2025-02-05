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
    private List<List<Integer>> answerList;
    public List<List<Integer>> levelOrder(TreeNode root) {
        answerList = new ArrayList<>();
        dfs(root, 0);
        return answerList;
    }
    public void dfs(TreeNode node, int depth){
        if(node ==null) return;
        if(answerList.size() <= depth) answerList.add(depth,new ArrayList<>());
        answerList.get(depth).add(node.val);

        dfs(node.left, depth+1);
        dfs(node.right, depth+1);
    }
}