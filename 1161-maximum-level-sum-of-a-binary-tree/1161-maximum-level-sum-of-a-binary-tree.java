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
    public int maxLevelSum(TreeNode root) {
        Queue<Node> q= new LinkedList<>();
        q.add(new Node(1, root));
        int currentLevel = 1;
        int maxLevel = 1;
        int max = Integer.MIN_VALUE;

        while(!q.isEmpty()){
            int sum = 0;
            Queue<Node> tempQ = new LinkedList<>();
            while(!q.isEmpty()){
                Node polled =q.poll();
                sum += polled.getValue();
                if(polled.node.left!=null) tempQ.offer(new Node(polled.level + 1, polled.node.left));
                if(polled.node.right!=null) tempQ.offer(new Node(polled.level + 1, polled.node.right));
            }
            q = tempQ;


            if(max < sum){
                maxLevel = currentLevel;
                max = sum;
            }
            currentLevel++;

        }
        return maxLevel;
    }


    class Node{
        private int level;
        private TreeNode node;

        public Node(int level, TreeNode node){
            this.level = level;
            this.node =  node;
        }
        public int getValue(){
            return this.node.val;
        }
    }
}