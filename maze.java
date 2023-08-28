// Time Complexity : O(mn) where m is the number of rows and n is the number of columns
// Space Complexity : O(mn) where m is the number of rows and n is the number of columns
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * 1. Use BFS to traverse the maze.
 * 2. For each cell, traverse in all four directions until you hit a wall or the boundary and add the cell to the queue where the wall or boundary is hit.
 * 3. If the destination is reached, return true.
 * 4. If the queue is empty, return false.
 */

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        int[][] dirs = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] vis = new boolean[m][n];
        queue.offer(start);
        vis[start[0]][start[1]] = true;

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            for(int[] dir : dirs){
                int r = curr[0];
                int c = curr[1];
                while(r >= 0 && c >= 0 && r < m && c < n && maze[r][c] != 1){
                    r += dir[0];
                    c += dir[1];
                }
                r -= dir[0];
                c -= dir[1];
                
                if(vis[r][c])
                    continue;
                
                if(r == destination[0] && c == destination[1]){
                    return true;
                }

                vis[r][c] = true;
                queue.offer(new int[]{r,c});
            }
        }

        return false;
    }
}