// Time Complexity: O(m * n) * max( m, n)
// Space Complexity: O(m * n)
// Did this code successfully run on Leetcode: YES
// Any problem you faced while coding this: NO

class Solution {
    int[][] dirs;
    int m, n;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze == null || maze.length == 0) return false;
        
        m = maze.length;
        n = maze[0].length;
        dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        return dfs(maze, start, destination);
    }
    
    private boolean dfs(int[][] maze, int[] start, int[] destination){
        //base
        if(start[0] == destination[0] && start[1] == destination[1]){
            return true;
        }
        
        //logic
        maze[start[0]][start[1]] = 2;
        for(int[] dir : dirs){
            int i = start[0];
            int j = start[1];
            while(i < m && i >= 0 && j < n && j >= 0 && maze[i][j] != 1){
                i = i + dir[0];
                j = j + dir[1];
            }
            i = i - dir[0];
            j = j - dir[1];
            if(maze[i][j] != 2 && dfs(maze, new int[] {i, j}, destination)){
                return true;
            }
        }
        return false;
    }
}