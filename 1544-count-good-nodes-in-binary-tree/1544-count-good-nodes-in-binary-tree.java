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
        dfs(root,root.val);
        return answer;
    }

    public void dfs(TreeNode crnt, int biggest){
        if(crnt == null) return;
        if(biggest <= crnt.val) {
            answer++;
            biggest = crnt.val;
        }

        dfs(crnt.left, biggest);
        dfs(crnt.right, biggest);
    }


}