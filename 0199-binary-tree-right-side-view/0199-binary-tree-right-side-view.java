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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if(root == null) return list;
        else q.add(root);
        
        while(!q.isEmpty()){
            TreeNode rightMost = q.poll();
            Queue<TreeNode> temp = new LinkedList<>();
            list.add(rightMost.val);
            if(rightMost.right!=null) temp.add(rightMost.right);
            if(rightMost.left!=null) temp.add(rightMost.left);

            while(!q.isEmpty()){
                TreeNode t = q.poll();
                if(t.right!=null) temp.add(t.right);
                if(t.left!=null) temp.add(t.left);
            }
            q = temp;
        }
        return list;
    }
}