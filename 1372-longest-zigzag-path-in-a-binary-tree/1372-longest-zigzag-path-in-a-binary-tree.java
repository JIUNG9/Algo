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
    public int longestZigZag(TreeNode root) {
        int answer= 0;
        Queue<Node> q = new LinkedList<>();
        if(root.left !=null) q.add(new Node(Dir.left,1,root.left));
        if(root.right !=null)  q.add(new Node(Dir.right,1, root.right));

        while(!q.isEmpty()){
            Node n = q.poll();
            if(n.treeNode!=null){
                if(n.d.equals(Dir.left)){
                    if(n.treeNode.right !=null) q.offer(new Node(Dir.right,n.cnt+1,n.treeNode.right));
                    if(n.treeNode.left !=null) q.offer(new Node(Dir.left,1,n.treeNode.left));
                } 
                else {
                    if(n.treeNode.left !=null) q.offer(new Node(Dir.left,n.cnt+1,n.treeNode.left));
                    if(n.treeNode.right !=null) q.offer(new Node(Dir.right,1,n.treeNode.right));
  
                }
                answer = Math.max(n.cnt, answer);
            }

            }
        
        return answer;
        
    }
    class Node{
        private Dir d;
        private int cnt;
        private TreeNode treeNode;

        public Node(Dir d, int cnt, TreeNode treeNode){
            this.cnt = cnt;
            this.d = d;
            this.treeNode = treeNode;
        }
        @Override
        public String toString(){
            return d +", " +  cnt +", " + treeNode;
        }

    }

    enum Dir{
        left,right;
    }
}