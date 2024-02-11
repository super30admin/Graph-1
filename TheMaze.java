// Time complexity : O(m*n)
// Space complexity : O(m*n)

import java.util.*;

public class TheMaze {
    public static void main(String[] args) {
        int[][] maze = { { 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 1, 0 }, { 1, 1, 0, 1, 1 },
                { 0, 0, 0, 0, 0 } };
        int[] start = { 0, 4 };
        boolean pathExists = hasPath(maze, start, destination);
        System.out.println(pathExists);
    }

    private static boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze == null)
            return false;
        if (start[0] == destination[0] && start[1] == destination[1])
            return true;
        int m = maze.length;
        int n = maze[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        queue.add(start);
        maze[start[0]][start[1]] = 2;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int[] dir : dirs) {
                int i = curr[0];
                int j = curr[1];
                while (i < m && j < n && i >= 0 && j >= 0 && maze[i][j] != 1) {
                    i += dir[0];
                    j += dir[1];
                }
                i -= dir[0];
                j -= dir[1];
                if (maze[i][j] != 2) {
                    if (i == destination[0] && j == destination[1])
                        return true;
                    queue.add(new int[] { i, j });
                    maze[i][j] = 2;
                }

            }
        }
        return false;

    }
}
