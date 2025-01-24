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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> firstList = new ArrayList<>();
        List<Integer> secondList = new ArrayList<>();
        getLeafNodes(root1, firstList);
        getLeafNodes(root2, secondList);
        return firstList.equals(secondList);


    }
    public void getLeafNodes(TreeNode node, List<Integer> list){   
        if(node == null) return;
        else if(node.left == null && node.right == null) list.add(node.val);
        else{
            getLeafNodes(node.left, list);
            getLeafNodes(node.right, list);
        }
    }
}