// Time Complexity : O(m * n) because each stopping point is visited at most once
// Space Complexity : O(m * n) for recursion stack in the worst case
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// We use DFS to explore all reachable stopping points in the maze.
// From each position, the ball rolls in a direction until it hits a wall, and only the stopping position is explored further.
// We mark visited stopping points to avoid revisiting the same state and prevent infinite loops.

class Solution {
    int[][] dirs;
    int m;
    int n;

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        this.dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        this.m = maze.length;
        this.n = maze[0].length;

        return dfs(maze, start[0], start[1], destination);
    }

    private boolean dfs(int[][] maze, int i, int j, int[] destination) {

        // destination reached
        if(destination[0] == i && destination[1] == j) {
            return true;
        }

        // already visited
        if(maze[i][j] == -1) {
            return false;
        }

        maze[i][j] = -1;

        for(int[] dir : dirs) {

            int r = i + dir[0];
            int c = j + dir[1];

            // roll until wall
            while(r >= 0 && c >= 0 && r < m && c < n && maze[r][c] != 1) {
                r += dir[0];
                c += dir[1];
            }

            // move back to stopping point
            r -= dir[0];
            c -= dir[1];

            if(dfs(maze, r, c, destination)) {
                return true;
            }
        }

        return false;
    }
}
