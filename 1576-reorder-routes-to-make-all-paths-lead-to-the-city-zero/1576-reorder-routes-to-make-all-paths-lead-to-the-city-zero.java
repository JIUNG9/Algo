class Solution {
    private int answer = 0;
    private boolean[] visited;

    public int minReorder(int n, int[][] c) {
        visited = new boolean[n]; // Fix: Visited array size is n, not c.length

        // Step 1: Build adjacency list
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] conn : c) {
            graph.get(conn[0]).add(new int[]{conn[1], 1}); // Forward edge
            graph.get(conn[1]).add(new int[]{conn[0], 0}); // Reverse edge
        }

        dfs(0, graph);
        return answer;
    }

    private void dfs(int from, List<List<int[]>> graph) {
        visited[from] = true;
        for (int[] neighbor : graph.get(from)) {
            int to = neighbor[0], isOriginalDirection = neighbor[1];
            if (!visited[to]) {
                answer += isOriginalDirection; // Count forward edges that need reversal
                dfs(to, graph);
            }
        }
    }
}
