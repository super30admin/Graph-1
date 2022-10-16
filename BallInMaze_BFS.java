import java.util.LinkedList;
import java.util.Queue;

/*
## Problem 2: The Maze (https://leetcode.com/problems/the-maze/)

Time Complexity :   O (m*n) 
Space Complexity :  O (m*n)
Did this code successfully run on Leetcode :    Yes (490. The Maze)
Any problem you faced while coding this :       No
 */
// Input: maze = [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]], start = [0,4], destination = [4,4]
// Output: true

// BFS Approach
class BallInMaze_BFS {
    int[][] dirs;
    int m, n;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        m = maze.length;
        n = maze[0].length;
        
        // null case
        if(maze == null || maze.length == 0)
            return false;
        
        dirs = new int[][]{{-1,0}, {1,0}, {0, 1}, {0, -1}};
        
        Queue<int[]> q = new LinkedList<>();
        
        // add start in queue and mark it visited
        q.add(start);
        maze[start[0]][start[1]] = 2;
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            
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
                
                // if the cell is not visited
                if(maze[i][j] != 2){
                    // if found desination, return true
                    if(i == destination[0] && j == destination[1])
                        return true;
                    
                    // add into queue and marked that cell to visited
                    q.add(new int[]{i, j});
                    maze[i][j] = 2;
                }
            }
        }
        return false;    
    }
}