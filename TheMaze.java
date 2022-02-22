package graph1;

import java.util.LinkedList;
import java.util.Queue;

public class TheMaze {
	//DFS
	//Time Complexity : O(m*n)
	//Space Complexity : O(m*n), for recursion stack
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        // null
        if(maze == null || maze.length == 0)
            return false;
        
        return dfs(maze, start, destination);
    }
    
    private boolean dfs(int[][] maze, int[] start, int[] destination) {
        // base
        if(start[0] == destination[0] && start[1] == destination[1])
            return true;
        
        //logic
        for(int[] dir: dirs) {
            int r = start[0];
            int c = start[1];
            
            while(r >= 0 && c >= 0 && r < maze.length && c < maze[0].length && maze[r][c] != 1) {
                r += dir[0];
                c += dir[1];
            }
            
            // one step back
            r -= dir[0];
            c -= dir[1];
            
            if(maze[r][c] != 2) {
                maze[r][c] = 2;
                if(dfs(maze, new int[] {r, c}, destination))
                    return true;
            }
        }
        
        return false;
    }
    
	//BFS
    //Time Complexity : O(m*n)
  	//Space Complexity : O(m*n), for queue
  	//Did this code successfully run on Leetcode : Yes
  	//Any problem you faced while coding this : No
	public boolean hasPath1(int[][] maze, int[] start, int[] destination) {
        // null
        if(maze == null || maze.length == 0)
            return false;
        if(start[0] == destination[0] && start[1] == destination[1])
            return true;
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            for(int[] dir: dirs) {
                int r = curr[0];
                int c = curr[1];
                
                while(r >= 0 && c >= 0 && r < maze.length && c < maze[0].length && maze[r][c] != 1) {
                    r += dir[0];
                    c += dir[1];
                }
                
                // one step back
                r -= dir[0];
                c -= dir[1];
                
                if(r == destination[0] && c == destination[1])
                    return true;
                
                if(maze[r][c] != 2) {
                    maze[r][c] = 2;
                    q.offer(new int[] {r, c});
                }
            }
        }
        return false;
    }
}
