// Time Complexity : O((m*n) + (m+n)) both the terms are complimentary.
// Space Complexity : O(m*n)for queue.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.*;
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        int[][] dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        Queue<int[]> que = new LinkedList<>();
        maze[start[0]][start[1]] = 2;
        que.offer(start);

        while(!que.isEmpty())
        {
            int[] node = que.poll();

            for(int i=0; i<dirs.length; i++)
            {
                int nr = node[0];
                int nc = node[1];
                if(nr == destination[0] && nc == destination[1])
                    return true;

                while(nr >=0 && nr<m && nc>=0 && nc <n && maze[nr][nc] != 1)
                {
                    nr +=dirs[i][0];
                    nc += dirs[i][1];
                }

                nr -= dirs[i][0];
                nc -= dirs[i][1];

                if(nr >=0 && nr<m && nc>=0 && nc <n && maze[nr][nc] != 2)
                {
                    maze[nr][nc] = 2;
                    que.offer(new int[]{nr, nc});
                }
                    
            }
        }
        return false;
    }
}