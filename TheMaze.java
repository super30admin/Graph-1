// Time Complexity : O(m*n)
// Space Complexity : O(m*n))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// We traverse all 4 directions from a point and add the stop points to a queue
// Pop from the queue and mark as visited and repeat to find further stop points
// If we stop at the destination return true else false

import java.util.Queue;

class Solution {
    int[][] dirs;
    int m,n;
    
    public boolean hasPathDFS(int[][] maze, int[] start, int[] destination) {
        this.dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        m = maze.length;
        n = maze[0].length;
        return dfs(maze, start, destination);
    }

    private boolean dfs(int[][] maze, int[] start, int[] destination){
        if(start[0] == destination[0] && start[1] == destination[1]) return true;

        maze[start[0]][start[1]] = 2;
        for(int[] dir:dirs){
            int r = start[0];
            int c = start[1];

            while(r>=0 && r<m && c>=0 && c<n && maze[r][c] != 1){
                r += dir[0];
                c += dir[1];
            }

            r -= dir[0];
            c -= dir[1];

            if(maze[r][c] != 2){
                if(dfs(maze, new int[]{r,c}, destination)) return true;
            }
        }

        return false;
    }


    public boolean hasPathBFS(int[][] maze, int[] start, int[] destination) {
        
        this.dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        m = maze.length;
        n = maze[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        maze[start[0]][start[1]] = 2;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            if(curr[0] == destination[0] && curr[1] == destination[1]) return true;

            for(int[] dir:dirs){
                int r = curr[0];
                int c = curr[1];

                while(r>=0 && r<m && c>=0 && c<n && maze[r][c] != 1){
                    r += dir[0];
                    c += dir[1];
                }

                r -= dir[0];
                c -= dir[1];

                if(r == destination[0] && c == destination[1]) return true;
                if(maze[r][c] != 2){
                    q.offer(new int[]{r,c});
                    maze[r][c] = 2;
                }
            }   
        }

        return false;
    }
}