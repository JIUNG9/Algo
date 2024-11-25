class Solution {
    public int slidingPuzzle(int[][] board) {
            // Convert the board to a string representation
        StringBuilder startBuilder = new StringBuilder();
        for (int[] row : board) {
            for (int num : row) {
                startBuilder.append(num);
            }
        }
        String start = startBuilder.toString();
        String target = "123450";

        // Adjacency list defining valid moves for each position
        int[][] neighbors = {
            {1, 3},       // 0 can swap with 1 and 3
            {0, 2, 4},    // 1 can swap with 0, 2, and 4
            {1, 5},       // 2 can swap with 1 and 5
            {0, 4},       // 3 can swap with 0 and 4
            {1, 3, 5},    // 4 can swap with 1, 3, and 5
            {2, 4}        // 5 can swap with 2 and 4
        };

        // BFS setup
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);

        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();

                // Check if we've reached the target state
                if (current.equals(target)) {
                    return moves;
                }

                // Find the index of the empty tile (0)
                int zeroIndex = current.indexOf('0');

                // Try all possible moves
                for (int neighbor : neighbors[zeroIndex]) {
                    char[] newState = current.toCharArray();
                    // Swap the zero with its neighbor
                    newState[zeroIndex] = newState[neighbor];
                    newState[neighbor] = '0';
                    String newStateString = new String(newState);

                    // Add the new state to the queue if not already visited
                    if (!visited.contains(newStateString)) {
                        visited.add(newStateString);
                        queue.offer(newStateString);
                    }
                }
            }
            moves++;
        }

        // If the target state is not reachable
        return -1;
    }
}