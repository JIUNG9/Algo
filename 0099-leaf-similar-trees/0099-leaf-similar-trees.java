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
    private List<Integer> list1;
    private List<Integer> list2;
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        list1 = new ArrayList<>(); list2 = new ArrayList<>();
        similarHelper(root1,list1);
        similarHelper(root2,list2);
        return list1.equals(list2);

    }
    //Move the Node, until just right before reach to the null
    //at that moment add the value at the list
    public void similarHelper(TreeNode node, List<Integer> list){
        if(node == null) return;
        if(node.left == null && node.right == null) {
            list.add(node.val);
            return;
        }
        similarHelper(node.left, list);
        similarHelper(node.right, list);

    }
}