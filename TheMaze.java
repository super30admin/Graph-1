package Graph1;

import java.util.LinkedList;
import java.util.Queue;

/*S30 FAANG Problem #115 {Medium} - https://www.youtube.com/watch?v=R6S8SjdbWYk
    There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall.
     When the ball stops, it could choose the next direction.

    Given the ball's start position, the destination and the maze, determine whether the ball could stop at the destination.

    The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You may assume that the borders of the maze are all walls.
     The start and destination coordinates are represented by row and column indexes.

    Example 1:

    Input 1: a maze represented by a 2D array

    0 0 1 0 0
    0 0 0 0 0
    0 0 0 1 0
    1 1 0 1 1
    0 0 0 0 0

    Input 2: start coordinate (rowStart, colStart) = (0, 4)
    Input 3: destination coordinate (rowDest, colDest) = (4, 4)

    Output: true

    Explanation: One possible way is : left -> down -> left -> down -> right -> down -> right.

    Example 2:

    Input 1: a maze represented by a 2D array

    0 0 1 0 0
    0 0 0 0 0
    0 0 0 1 0
    1 1 0 1 1
    0 0 0 0 0

    Input 2: start coordinate (rowStart, colStart) = (0, 4)
    Input 3: destination coordinate (rowDest, colDest) = (3, 2)

    Output: false

    Explanation: There is no way for the ball to stop at the destination.

    Note:

    There is only one ball and one destination in the maze.
    Both the ball and the destination exist on an empty space, and they will not be at the same position initially.
    The given maze does not contain border (like the red rectangle in the example pictures), but you could assume the border of the maze are all walls.
    The maze contains at least 2 empty spaces, and both the width and height of the maze won't exceed 100.
    Source Link: https://leetcode.com/problems/the-maze/
        
-------------------------------------------------------------------------------------------------------
Time complexity :O(MN) 
space complexity:O(MN) 
Approach:
Did this code run successfully in leetcode : yes
problems faces : no
*/
public class TheMaze {
    
    public boolean hasPathBfs(int[][] maze, int[] start, int[] destination) {
        
        if(maze == null || maze.length== 0) return true;
        
        int m = maze.length;
        int n= maze[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start[0],start[1]});
        maze[start[0]][start[1]] = 2;
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        
        while(!q.isEmpty())
        {
            int[] curr = q.poll();
            
            for(int[] dir : dirs)
            {
                int i = curr[0];
                int j = curr[1];
                while(i>=0 && i<m && j>=0 && j<n && maze[i][j] != 1)
                {
                    i = i+ dir[0];
                    j = j+ dir[1];
                }
                i=i-dir[0];
                j=j-dir[1];
                
                if(i == destination[0] && j == destination[1])
                {
                    return true;
                }
                else if( maze[i][j] != 2)
                {
                    maze[i][j] = 2;
                    q.add(new int[]{i,j});
                    
                }
          }
        }
        
        return false;
    }
    
   /* -------------------------------------------------------------------------------------------------------
    Time complexity :O(MN) 
    space complexity:O(MN) 
    Approach:
    Did this code run successfully in leetcode : yes
    problems faces : no
    */
 public boolean hasPathDfs(int[][] maze, int[] start, int[] destination) {
        
        if(maze == null || maze.length== 0) return true;
        return dfs(maze,start[0],start[1],destination);
    }
 
     private boolean dfs(int[][] maze,int r, int c,int[] destination)
     {
         //base
         if(r == destination[0] && c == destination[1]) return true;
         if(maze[r][c] == 2 ) return false;
         
         //
         maze[r][c] =2;
         int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
         for(int[] dir : dirs)
         {
             int i = r;
             int j = c;
             
             while(i>=0 && i<maze.length && j>=0 && j<maze[0].length && maze[i][j] != 1)
             {
                 i = i+dir[0];
                 j = j+dir[1];
             }
             //bring ball to stopage
             i = i-dir[0];
             j = j-dir[1];
            
             if(dfs(maze,i,j,destination)) return true;
                     
         }
         
         return false;
     }

}
