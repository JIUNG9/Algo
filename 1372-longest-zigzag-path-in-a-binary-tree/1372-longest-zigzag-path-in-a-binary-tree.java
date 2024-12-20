class Solution {
    private int maxZigZag = 0;

    public int longestZigZag(TreeNode root) {
        dfs(root, -1, 0); // Start without any direction
        return maxZigZag;
    }

    private void dfs(TreeNode node, int direction, int length) {
        if (node == null) return;
        maxZigZag = Math.max(maxZigZag, length);
        
        if (direction != 0) { // If not coming from the left, go left
            dfs(node.left, 0, length + 1);
        } else {
            dfs(node.left, 0, 1); // Reset length when changing direction
        }
        
        if (direction != 1) { // If not coming from the right, go right
            dfs(node.right, 1, length + 1);
        } else {
            dfs(node.right, 1, 1); // Reset length when changing direction
        }
    }
}
