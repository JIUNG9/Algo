/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> list1 = new ArrayList<>();
        List<TreeNode> list2 = new ArrayList<>(); 
        TreeNode rootCache1 = root;
        TreeNode rootCache2 = root;

        findHelper(false, list1, rootCache1, p.val);
        findHelper(false, list2, rootCache2, q.val);

        for(TreeNode node : list1){
            System.out.println("node1.val: " + node.val);
            if(list2.contains(node)) return node;
        }
        
        // for(TreeNode node : list2){
        //     System.out.println("node2.val: " + node.val);
        //     // if(list2.contains(node)) return node;
        // }
        return null;
        
    }
    public boolean findHelper(boolean flag, List<TreeNode> list, TreeNode node, int target){
        if(node == null) return false;
        else if(node.val == target) {
            list.add(node);
            return true;
        }
        else{
            if(findHelper(flag, list, node.left,target)) {list.add(node);return true;}
            if(findHelper(flag, list, node.right, target)) {list.add(node); return true;}
        }
        
        return false;
    }
}