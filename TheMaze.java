// LC 490
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : while deciding how to proceed with directions array for an obstacle hit


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * There is a ball in a maze with empty spaces (represented as 0) and walls (represented as 1). The ball can go through the empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.
 *
 * Given the m x n maze, the ball's start position and the destination, where start = [startrow, startcol] and destination = [destinationrow, destinationcol], return true if the ball can stop at the destination, otherwise return false.
 *
 * You may assume that the borders of the maze are all walls (see examples).
 *
 *
 *
 * Example 1:
 * Input: maze = [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]], start = [0,4], destination = [4,4]
 * Output: true
 * Explanation: One possible way is : left -> down -> left -> down -> right -> down -> right.
 *
 * Example 2:
 * Input: maze = [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]], start = [0,4], destination = [3,2]
 * Output: false
 * Explanation: There is no way for the ball to stop at the destination. Notice that you can pass through the destination but you cannot stop there.
 *
 * Example 3:
 * Input: maze = [[0,0,0,0,0],[1,1,0,0,1],[0,0,0,0,0],[0,1,0,0,1],[0,1,0,0,0]], start = [4,3], destination = [0,1]
 * Output: false
 *
 * Constraints:
 *
 * m == maze.length
 * n == maze[i].length
 * 1 <= m, n <= 100
 * maze[i][j] is 0 or 1.
 * start.length == 2
 * destination.length == 2
 * 0 <= startrow, destinationrow < m
 * 0 <= startcol, destinationcol < n
 * Both the ball and the destination exist in an empty space, and they will not be in the same position initially.
 * The maze contains at least 2 empty spaces.
 */

public class TheMaze {

    /**
     * TC: O(m * n * (m + n))
     * SC: O(m * n) for a visited array
     * @param maze
     * @param start
     * @param end
     * @return
     */
    public boolean hasPath_bfs(int[][] maze, int[] start, int[] end) {
        int m = maze.length;
        int n = maze[0].length;

        int[] dirs = {0, 1, 0, -1, 0};

        /**
         * BFS == Efficient Algo for best case
         *
         * start with source
         */
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{start[0], start[1]});
        // 2 == mark as visited
        maze[start[0]][start[1]] = 2;

        /**
         * TC: O(m * n)
         */
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int currRow = curr[0];
            int currCol = curr[1];

            /**
             * TC: O(m + n)
             *
             * move in 4 directions
             */
            for (int i = 1; i < dirs.length; i++) {
                int r = currRow;
                int c = currCol;
                // keep on rolling till the ball hits an obstacle or goes out of bounds
                while (r >= 0 && r < m && c >= 0 && c < n && maze[r][c] != 1) {
                    r = r + dirs[i - 1];
                    c = c + dirs[i];
                }
                // now, we come out of the while loop, when we hit an invalid position
                // so undo the last step
                // i.e. step back
                r = r - dirs[i - 1];
                c = c - dirs[i];

                // now check if the current valid position is unvisited or not
                if (maze[r][c] != 2) {
                    maze[r][c] = 2;
                    q.offer(new int[]{r, c});
                }
                if (r == end[0] && c == end[1]) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasPath_dfs(int[][] maze, int[] start, int[] end) {
        int[] dirs = {0, 1, 0, -1, 0};

        /**
         * TC: O(m * n * (m + n))
         * SC: O(m * n)
         */
        return dfs(maze, start, end, dirs);
    }

    private boolean dfs(int[][] maze, int[] start, int[] end, int[] dirs) {
        int m = maze.length;
        int n = maze[0].length;
        int row = start[0];
        int col = start[1];
        // mark as visited
        maze[row][col] = 2;
        // base
        if (row == end[0] && col == end[1]) {
            return true;
        }
        /**
         * TC: O(m + n)
         */
        // action
        for (int i = 1; i < dirs.length; i++) {
            int r = row;
            int c = col;
            // keep on rolling till the ball hits an obstacle or goes out of bounds
            while (r >= 0 && r < m && c >= 0 && c < n && maze[r][c] != 1) {
                r = r + dirs[i - 1];
                c = c + dirs[i];
            }
            // now, we come out of the while loop, when we hit an invalid position
            // so undo the last step
            // i.e. step back
            r = r - dirs[i - 1];
            c = c - dirs[i];

            // now check if the current valid position is unvisited or not
            if (maze[r][c] != 2) {
                boolean dfs = dfs(maze, new int[]{r, c}, end, dirs);
                if (dfs) {
                    return true;
                }
            }
        }
        return false;
    }

}
