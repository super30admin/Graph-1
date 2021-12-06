class Solution{
  public boolean haspath(int[][] maze, int[] start, int[] destination){
      if(maze == null || maze.length == 0) return true;
      int m = maze.length;
      int n = maze[0].length;
     return dfs(maze, start[0], start[1], destination, m, n);
  }
  
  private boolean dfs(int[][] maze, int r, int c, int[] destination, int m, int n){
      //base
      if(destination[0] == r && destination[1] == c) return true;
      if(maze[r][c] == z) return false;
      
    
      //logic
      maze[r][c] = 2;
      int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    
      for(int [] dir: dirs){
        int i = r;
        int j = c;
        while(i >= 0 && i < m && j >= 0 && j < n && maze[i][j] != 1){
            i += dir[0];
            j += dir[1];
        }
        
        i -= dir[0];
        j -= dir[1];
        
        if(dfs(maze, i, j, destination, m, n) return true;
           }
           return false;
           
           }
           }
           
   //TC: O(M*N)
   //SC: O(N)
