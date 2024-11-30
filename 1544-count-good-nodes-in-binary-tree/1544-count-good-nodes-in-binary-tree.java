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
    private int answer = 0;
    public int goodNodes(TreeNode root) {
        //현재 노드에서 모든 것을 탐색하고(최단 거리가 아니라서 -> DFS 사용 모든 것을 탐색) 이때, 현재 노드보다, 같거나 큰 노드로 이동했다면 정답을 하나 증가시키고, 해당 정답 값을 반환한다.
        //root to X -> there are no nodes with the value greater than X
        dfs(null, root,root.val);
        return answer;
    }

    public void dfs(TreeNode prev, TreeNode crnt, int biggest){
        //모든 노드를 방문하는데, 이전에 방문했던 것보다 값이 크거나 같다면 정답 크기를 하나 증가 -> ㅇ
        if(prev == null || biggest <= crnt.val) {
            answer++;
        }
        if(crnt.left!=null) dfs(crnt, crnt.left, biggest >= crnt.left.val ? biggest : crnt.left.val);
        if(crnt.right!=null) dfs(crnt, crnt.right, biggest >= crnt.right.val ? biggest : crnt.right.val);
    }


}