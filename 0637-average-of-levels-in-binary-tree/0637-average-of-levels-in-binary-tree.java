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
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<NodeInfo> q = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        List<Double> answer = new ArrayList<>();
        q.add(new NodeInfo(0,root));

        while(!q.isEmpty()){
            NodeInfo node =q.poll();

            int depth = node.depth;
            TreeNode n = node.root;

            if(list.size() <= depth) list.add(depth, new ArrayList<>());
            list.get(depth).add(n.val);
          
            if(n.left != null )q.add(new NodeInfo(depth + 1 , n.left));
            if(n.right != null ) q.add(new NodeInfo(depth + 1 , n.right));
        }

        for(List<Integer> l : list){
            int count = l.size();
            double num = 0;
            for(Integer i : l){
                num+=((double)i/count);
            }
            answer.add(num);
        }

        return answer;

    }
    class NodeInfo{
        private int depth;
        private TreeNode root;
        public NodeInfo(int depth, TreeNode root){
            this.depth = depth;
            this.root = root;
        }
    }
}