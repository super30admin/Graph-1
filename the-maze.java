// Time and Space O(MN), O(MN)
// DFS
class Solution {
    int m,n;
    int[][] dirs;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze == null || maze.length == 0) {
            return false;
        }
        
        dirs = new int[][]{{0,-1},{0,1},{1,0},{-1,0}};
        
        
        m = maze.length;
        n = maze.length;
        
        
        
        return helper(maze, start, destination);
    }
    
    private boolean helper(int[][] maze, int[] start, int[] destination) {
        
        if(start[0] == destination[0] && start[1] == destination[1]) {
            return true;
        }
        
        if(maze[start[0]][start[1]] == 2) {
            return false;
        }
        
        maze[start[0]][start[1]] = 2;
        for(int[] dir :dirs) {
            int i = start[0]; 
            int j = start[1];
            while(i>=0&&j>=0&&i<m&&j<n&&maze[i][j]!=1){
                i=i+dir[0];
                j=j+dir[1];
            }
            i=i-dir[0];
            j=j-dir[1];
            
            if(helper(maze, new int[] {i,j}, destination)) {
                return true;
            }
        }
        
        return false;
    }
}
