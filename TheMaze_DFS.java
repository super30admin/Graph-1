// TC: O(mn)
// SC: O(mn)
class Solution {
    int[][] dirs;
    int m; int n;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze == null || maze.length == 0) return false;
        dirs  = new int[][] {{-1,0}, {1,0}, {0,-1}, {0,1}};
        m = maze.length; n = maze[0].length;
        return dfs(maze, start, destination);
        
    }
    
    public boolean dfs(int[][] maze, int[] start, int[] destination){
        //base
        if(start[0] == destination[0] && start[1] == destination[1] ) return true;
        if(maze[start[0]][start[1]] == 2) return false; //all nodes visited 
        
        //logic
        //mark visited
        maze[start[0]][start[1]] = 2;
        for(int[] dir: dirs){
            int row = start[0];
            int col = start[1];
            
            while(row >= 0 && row < m && col >= 0 && col < n && maze[row][col] != 1){
                row += dir[0];
                col += dir[1];
            }
            //step back
            row -= dir[0];
            col -= dir[1];
            
            if(dfs (maze, new int[] {row,col}, destination)) return true;
        }
        return false;
    }
}