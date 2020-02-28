// Time Complexity : O(m*n) where m and n are the dimensions of the maze
// Space Complexity : O(m*n) where m and n are the dimensions of the maze
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class theMaze_DFS {
    int[][] dirs = {{0,1}, {1,0}, {-1,0}, {0, -1}};
    int m, n;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0) return false;
        m = maze.length;
        n = maze[0].length;
        return dfs(maze, start, destination);
    }
    private boolean dfs(int[][] maze, int[] start, int[] destination) {
        int i = start[0], j = start[1];
        // base case
        if (i == destination[0] && j == destination[1]) return true;
        // logic
        maze[i][j] = 2; // mark as visited in place
        for (int[] dir : dirs) {
            int r = i, c = j;
            while (r >= 0 && r < m && c >= 0 && c < n && maze[r][c] != 1) {
                r += dir[0];
                c += dir[1];
            }
            r -= dir[0];
            c -= dir[1];
            if (maze[r][c] != 2 && dfs(maze, new int[] {r, c}, destination)) {
                return true;
            }
        }
        return false;
    }
}