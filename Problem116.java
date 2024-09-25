//TC: O(m*n)
//SC: O(m*n)
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] visited = new boolean[m][n]; // To mark visited cells
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // right, down, left, up
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currRow = current[0];
            int currCol = current[1];

            // If we reached the destination
            if (currRow == destination[0] && currCol == destination[1]) {
                return true;
            }

            // Explore all four directions
            for (int[] dir : directions) {
                int newRow = currRow;
                int newCol = currCol;

                // Roll the ball until it hits a wall or goes out of bounds
                while (newRow + dir[0] >= 0 && newRow + dir[0] < m && newCol + dir[1] >= 0 && newCol + dir[1] < n
                        && maze[newRow + dir[0]][newCol + dir[1]] == 0) {
                    newRow += dir[0];
                    newCol += dir[1];
                }

                // If the new position has not been visited yet, add it to the queue
                if (!visited[newRow][newCol]) {
                    visited[newRow][newCol] = true;
                    queue.add(new int[] {newRow, newCol});
                }
            }
        }
        return false; // No path found to the destination
    }
}
