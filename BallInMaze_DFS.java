/*
## Problem 2: The Maze (https://leetcode.com/problems/the-maze/)

Time Complexity :   O (m*n) 
Space Complexity :  O (m*n)
Did this code successfully run on Leetcode :    Yes (490. The Maze)
Any problem you faced while coding this :       No
 */
// Input: maze = [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]], start = [0,4], destination = [4,4]
// Output: true

// DFS Approach
class BallInMaze_DFS {
    int[][] dirs;
    int m, n;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        m = maze.length;
        n = maze[0].length;
        
        // null case
        if(maze == null || maze.length == 0)
            return false;
        
        dirs = new int[][]{{-1,0}, {1,0}, {0, 1}, {0, -1}};
        return dfs(maze, start, destination);
    }
    private boolean dfs(int[][] maze, int[] curr, int[] destination) {
        // base
        if(maze[curr[0]][curr[1]] == 2)
            return false;
        if(curr[0] == destination[0] && curr[1] == destination[1])
            return true;
        
        // mark it visited
        maze[curr[0]][curr[1]] = 2;
            
        for(int[] dir: dirs){
            int i = curr[0];
            int j = curr[1];

            // travel until wall cell
            while(i>=0 && j>= 0 && i< m && j<n && maze[i][j] != 1){
                i += dir[0];
                j += dir[1];
            }

            // go back 1 previous empty cell
            i -= dir[0];
            j -= dir[1];
            
            if(dfs(maze, new int[]{i, j} , destination))
                return true;
        }
        return false;
    }
}