// Time Complexity : O(m*n)*(m+n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : NO (premium prob)
// Any problem you faced while coding this : No

// dfs : TC O(m*n)(m+n) +  SC: O(m*n)
class Solution{
    int m,n;
    int[][]dirs;

    public boolean hasPath(int[][] maze, int[] start, int[] destination){
        if(maze == null || maze.length == 0){
            return false;
        }

        m = maze.length;
        n = maze[0].length;
        dirs = new int {{-1,0}, {1, 0}, {0,-1}, {0,1}} // U D L R 
        return dfs(maze, start, destination)
    }
    private boolean dfs(int[][] maze, int[] start, int[] destination){
        // base
        if(star[0] == destination[0] && start[1] == destination[1]){
            return true;
        }

        //logic
        maze[start[0]][start[1]] = 2;
        for(int [] dir: dirs){
            int nr = start[0];
            int nc = start[1];

            while(nr>=0 && nr < m && nc >=0 && nc < n && maze[nr][nc] !=1){
                nr = nr + dir[0];
                nc = nc + dir[1];
            }

            // rewind it back by 1 step
            nr = nr - dir[0];
            nc = nc - dir[1];
            if(maze[nr][nc] != 2){
                if(dfs(maze, new int [] {nr, nc}, destination)){
                    return true;
                }
            }
        }

    }
}