//Solution without modifying input

//Time: O(m * n)
//Space: O(m * n)

class Solution {
  boolean ispath = false;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
      int i=start[0]; int j=start[1];
      boolean[][] visited = new boolean[maze.length][maze[0].length];
  
      return dfs(maze,start[0],start[1],destination,visited); 
      
    }
  
    public boolean dfs(int[][] maze, int i,int j, int[] dest, boolean[][] visited){
     int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
      
      int m = maze.length;
      int n = maze[0].length;
      
      //Base cases
      if(visited[i][j] == true){
        ispath = false;
        return false;
      }
      
      if(i == dest[0] && j == dest[1]){
        ispath = true;
        return true;
      }
      
      visited[i][j] = true;
     
      for(int k=0;k<dirs.length;k++){
        int row = i;
        int col = j;
        // Keep rolling the ball till hit the wall
        while(row >=0 && row < m  && col >= 0 && col < n  && maze[row][col] != 1){
          // even if it is visited, its okay, can just roll over those cells
          row+= dirs[k][0];
          col+= dirs[k][1];
        }
        
        row -= dirs[k][0];
        col -= dirs[k][1];
   
        if(row >= m) row = m-1;
        if(row < 0) row = 0;
        if(col >= n) col = n-1;
        if(col < 0) col = 0;
        
        if(dfs(maze,row,col,dest,visited)){
          return true;
        }
        
        
      }
      
      return false;
    }
  
}

