import java.util.LinkedList;
import java.util.Queue;
//Approach: BFS
//1. We can do normal BFS but the ball has to be rolling hence the children are not the nearest neighbors but the position where the ball stops when keep rolling in a particualr direction.
//2. We keep rolling the ball meanwhile marking the visited elements if at all the destination is reached we return true. 
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze == null || maze.length == 0)return true;
        int m = maze.length, n = maze[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start[0], start[1]});
        maze[start[0]][start[1]] = 2;
        while(!queue.isEmpty())
        {
            int[] curr = queue.poll();
            
            if(curr[0] == destination[0] && curr[1] == destination[1])
            {
                return true;
            }
            int[][] directions = {{0,-1},{-1,0},{1,0},{0,1}};
            for(int[] dir: directions)
            {
                int r = curr[0];
                int c = curr[1];
                while( r >= 0 && c >= 0 && c < n  && r < m && maze[r][c] != 1 )
                {
                    r += dir[0];
                    c += dir[1];
                }
                r -= dir[0];
                c -= dir[1];
                
                if(maze[r][c] != 2)
                {
                    queue.add(new int[]{r,c});
                }
                maze[r][c] = 2;
            }
        }
        return false;
    }
}
//Time Complexity : O(m * n) 
//Space Complexity : O(m * n) 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this :
