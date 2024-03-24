// TC: O(m * n)
// SC: O(m * n)

// Approach: DFS or BFS in the four directions till you hit a wall
// and do the same from there. Mark visited nodes and if you reach destination
// return true;

import java.util.LinkedList;
import java.util.Queue;

class BallInMaze {
    int[][] dirs;

    public boolean hasPathBFS(int[][] maze, int[] start, int[] destination) {
        dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { start[0], start[1] });

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            // visited
            maze[current[0]][current[1]] = 2;
            for (int[] dir : dirs) {
                int r = current[0] + dir[0];
                int c = current[1] + dir[1];

                while (r >= 0 && r < maze.length && c >= 0 && c < maze[0].length && maze[r][c] != 1) {
                    r += dir[0];
                    c += dir[1];
                }

                // one step back
                r -= dir[0];
                c -= dir[1];

                if (r == destination[0] && c == destination[1]) {
                    return true;
                }

                if (maze[r][c] != 2) {
                    queue.add(new int[] { r, c });
                }
            }
        }

        return false;
    }

    public boolean hasPathDFS(int[][] maze, int[] start, int[] destination) {
        if (start[0] == destination[0] && start[1] == destination[1]) {
            return true;
        }

        if (maze[start[0]][start[1]] == 2) {
            return false;
        }

        maze[start[0]][start[1]] = 2;

        for (int[] dir : dirs) {
            int r = start[0] + dir[0];
            int c = start[1] + dir[1];

            while (r >= 0 && r < maze.length && c >= 0 && c < maze[0].length && maze[r][c] != 1) {
                r += dir[0];
                c += dir[1];
            }

            // one step back
            r -= dir[0];
            c -= dir[1];

            if (hasPathDFS(maze, new int[] { r, c }, destination)) {
                return true;
            }
        }

        return false;
    }
}