// Time complexity: O(m * n)
// Space complexity: O(m * n)

// Intuition: We can use depth-first search (DFS) to explore all possible paths in the maze.
// Let the ball roll until it hits a wall, then we can change direction and continue rolling until we reach the destination.
// When we reach the destination, we return true
// If we exhaust all possibilities without reaching the destination, we return false.

public class Maze {
    int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } }; // right, down, left, up

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int r = maze.length, c = maze[0].length;
        boolean[][] visited = new boolean[r][c];
        return dfs(maze, start, destination, visited);
    }

    private boolean dfs(int[][] maze, int[] start, int[] dest, boolean[][] visited) {
        if (visited[start[0]][start[1]])
            return false;
        if (start[0] == dest[0] && start[1] == dest[1])
            return true;

        visited[start[0]][start[1]] = true;

        for (int[] dir : dirs) {
            int x = start[0], y = start[1];

            // Roll the ball until it hits a wall
            while (x + dir[0] >= 0 && x + dir[0] < maze.length &&
                    y + dir[1] >= 0 && y + dir[1] < maze[0].length &&
                    maze[x + dir[0]][y + dir[1]] == 0) {
                x += dir[0];
                y += dir[1];
            }

            if (dfs(maze, new int[] { x, y }, dest, visited))
                return true;
        }

        return false;
    }
}
