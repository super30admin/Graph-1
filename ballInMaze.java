// Time Complexity :O(m*n) where m is the number of rows and n is the number of columns
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
      
      return dfs(maze,destination,start[0],start[1]);
        
    }
  
    private boolean dfs(int[][] maze,int[] destination,int i,int j)
    {
      //if already visited
      if(maze[i][j]==2)
      {
        return false;
      }
      //reached destination
      if(i == destination[0] && j == destination[1])
      {
        return true;
      }
      //mark as visitied
      maze[i][j]=2;
      
      for(int[] dir : dirs)
      {
        int r = i;
        int c = j;
        //until going out of bound or we see a ball keep rolling the ball
        while(r >= 0 && r < maze.length && c>= 0 && c < maze[0].length && maze[r][c]!=1)
        {
          r = r + dir[0];
          c = c + dir[1];
        }
        //bring the ball one step back because of the way we have the while loop
        r = r - dir[0];
        c = c - dir[1];
        //if we have reached the destination dfs would return us true and we can return true to the method
        if(dfs(maze,destination,r,c))
        {
          return true;
        }
      }
      return false;
    }
      
    
}