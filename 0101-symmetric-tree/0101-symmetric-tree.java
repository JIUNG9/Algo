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
    public boolean isSymmetric(TreeNode root) {
        List<Integer> firstList = new ArrayList<>();
        List<Integer> secondList = new ArrayList<>();
        preOrder(root, firstList);
        postOrder(root, secondList);

        return firstList.equals(secondList);

        
    }
    public void preOrder(TreeNode root, List<Integer> list){
        if(root == null) {
            list.add(-1000);
            return;
        }
        preOrder(root.left,list);
        list.add(root.val);
        preOrder(root.right,list);
        list.add(root.val);

    }
    public void postOrder(TreeNode root, List<Integer> list){
        if(root == null) {
            list.add(-1000);
            return;
        };
        postOrder(root.right,list);
        list.add(root.val);
        postOrder(root.left,list);
        list.add(root.val);
    }
}