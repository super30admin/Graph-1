// Time Complexity : O(m*n)  -> (m*n)(m+n)  -> m*n goes high then m+n goes down and viceversa.
// So asymptotically its m*n
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes

import java.util.LinkedList;
import java.util.Queue;

public class TheMazeUsingBFS {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        maze[start[0]][start[1]] = 2;
        q.add(start);
        while(!q.isEmpty())
        {
            int[] curr = q.poll();
            for(int[] dir: dirs)
            {
                int r = curr[0] + dir[0];
                int c = curr[1] + dir[1];

                while(r>=0 && r<m && c>=0 && c<n && maze[r][c]!=1)
                {
                    r = r + dir[0];
                    c = c + dir[1];
                }

                r = r - dir[0];
                c = c - dir[1];

                if(r == destination[0] && c == destination[1]) return true;
                if(maze[r][c]!=2)
                {
                    maze[r][c] = 2;
                    q.add(new int[]{r,c});
                }
            }
        }
        return false;
    }
}
