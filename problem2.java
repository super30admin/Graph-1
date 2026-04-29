import java.util.*;

class Solution {

    /**
    Time Complexity : O(M * N)
    Explanation:
    Each cell can be visited at most once after it becomes a stopping point.
    From each cell, rolling in 4 directions takes O(max(M, N)),
    but overall bounded by visiting each cell once.

    Space Complexity : O(M * N)
    Explanation:
    Queue can store multiple stopping positions and we mark visited in the grid.

    Did this code successfully run on LeetCode : Yes

    Any problem you faced while coding this :
    Initially treated it like normal BFS (step-by-step movement),
    but here the ball rolls until it hits a wall.
    Fixed it by:
        - Rolling continuously in one direction
        - Stepping back one position after hitting wall
    Also needed to mark visited positions to avoid infinite loops.
    */

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {

        int m = maze.length;
        int n = maze[0].length;

        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        Queue<int[]> q = new LinkedList<>();

        // Start position
        q.add(new int[]{start[0], start[1]});
        maze[start[0]][start[1]] = 2; // mark visited

        while (!q.isEmpty()) {

            int[] curr = q.poll();

            for (int[] dir : dirs) {

                int r = curr[0];
                int c = curr[1];

                // Roll until hitting a wall
                while (r >= 0 && c >= 0 && r < m && c < n && maze[r][c] != 1) {
                    r += dir[0];
                    c += dir[1];
                }

                // Step back to last valid position
                r -= dir[0];
                c -= dir[1];

                // Check destination
                if (r == destination[0] && c == destination[1]) {
                    return true;
                }

                // If not visited, add to queue
                if (maze[r][c] != 2) {
                    q.add(new int[]{r, c});
                    maze[r][c] = 2;
                }
            }
        }

        return false;
    }
}