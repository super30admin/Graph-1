// Problem 490. The Maze
// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
// DFS
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        // Directions array for moving up, down, left, right
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        return dfs(maze, start, destination, dirs, m, n);
    }
    private boolean dfs(int[][] maze, int[] start, int[] destination, int[][] dirs, int m, int n) {
        // Base case: If we reach the destination, return true
        if (start[0] == destination[0] && start[1] == destination[1]) {
            return true;
        }
        if (maze[start[0]][start[1]] != 0) {
            return false;
        }
        // Mark the current cell as visited (using 2 as visited flag)
        maze[start[0]][start[1]] = 2;
        // Explore all four directions
        for (int[] dir : dirs) {
            int r = start[0];
            int c = start[1];
            // Keep rolling the ball in the current direction until it hits a wall
            while (r >= 0 && r < m && c >= 0 && c < n && maze[r][c] != 1) {
                r += dir[0];
                c += dir[1];
            }
            // Step back to the last valid position
            r -= dir[0];
            c -= dir[1];
            // If the position is not visited, perform DFS from this new position
            if (dfs(maze, new int[]{r, c}, destination, dirs, m, n)) {
                return true;
            }
        }
        return false;
    }
}
