import java.util.LinkedList;
import java.util.Queue;

public class TheMaze {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        // return hasPathRecursive(maze, start, destination);
        return hasPathIterative(maze, start, destination);
    }

    // TC: O(M * N * (M + N)) where M is number of rows and N is number of cols
    // SC: O(M * N) where M is number of rows and N is number of cols
    private boolean hasPathRecursive(int[][] maze, int[] start, int[] destination) {
        return helper(maze, start, destination);
    }

    private boolean helper(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        if (start[0] == destination[0] && start[1] == destination[1]) return true;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] d : dirs) {
            int i = start[0], j = start[1];
            while (i >= 0 && i < m && j >= 0 && j < n && maze[i][j] != 1) {
                i += d[0];
                j += d[1];
            }
            i -= d[0];
            j -= d[1];
            if (maze[i][j] != 2) {
                maze[i][j] = 2;
                if (helper(maze, new int[]{i, j}, destination)) {
                    return true;
                }
            }
        }
        return false;
    }

    // TC: O(M * N * (M + N)) where M is number of rows and N is number of cols
    // SC: O(M * N) where M is number of rows and N is number of cols
    private boolean hasPathIterative(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        maze[start[0]][start[1]] = 2;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int[] d : dirs) {
                int i = curr[0], j = curr[1];
                while (i >= 0 && i < m && j >= 0 && j < n && maze[i][j] != 1) {
                    i += d[0];
                    j += d[1];
                }
                i -= d[0];
                j -= d[1];
                if (destination[0] == i && destination[1] == j) {
                    return true;
                }
                if (maze[i][j] != 2) {
                    maze[i][j] = 2;
                    queue.add(new int[]{i, j});
                }
            }
        }
        return false;
    }
}
