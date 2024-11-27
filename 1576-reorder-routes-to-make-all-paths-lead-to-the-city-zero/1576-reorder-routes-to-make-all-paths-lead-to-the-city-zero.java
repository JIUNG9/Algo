class Solution {
    private int change = 0; // Global variable to track the number of changes

    private void dfs(List<List<Integer>> al, boolean[] visited, int from) {
        visited[from] = true;
        for (var to : al.get(from)) {
            if (!visited[Math.abs(to)]) {
                if (to > 0) change++; // Increment for forward roads
                dfs(al, visited, Math.abs(to)); // Recurse to neighbor
            }
        }
    }

    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> al = new ArrayList<>();
        for (int i = 0; i < n; ++i)
            al.add(new ArrayList<>());
        for (var c : connections) {
            al.get(c[0]).add(c[1]);  // Add forward direction
            al.get(c[1]).add(-c[0]); // Add reverse direction
        }
        dfs(al, new boolean[n], 0);
        return change;
    }
}
