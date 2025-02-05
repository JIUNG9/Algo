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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        answerList = new ArrayList<>();
        Queue<NodeInfo> q = new LinkedList<>();
        q.add(new NodeInfo(root, 0));

        while(!q.isEmpty()){
            NodeInfo ni = q.poll();
            int depth = ni.depth;
            TreeNode node = ni.node;

            if(node == null) continue;
            if(answerList.size() <= depth) answerList.add(new ArrayList<>());

            List<Integer> targetList = answerList.get(depth);

            if(depth % 2 == 1) targetList.add(0,node.val);
            else targetList.add(node.val);

            q.add(new NodeInfo(node.left,depth + 1));
            q.add(new NodeInfo(node.right,depth + 1));
        }
        return answerList;
}
    class NodeInfo{
        private TreeNode node;
        private int depth;
        public NodeInfo(TreeNode node, int depth){
            this.node = node;
            this.depth = depth;
        }
    }
}