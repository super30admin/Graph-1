// Problem2 The Maze (https://leetcode.com/problems/the-maze/)

// Time Complexity : O(mxn) 
// Space Complexity : O(mxn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, start with given start array if start place is 2 then add it to queue. While q is not empty take the top array and move in directions of
 * dirs array for each direction move until you find 1 and check if found row is equal to row of destination and col is equal to col of destination.
 * If yes return true. If not make that box as 2 and add to queue.
 */
// 1
class Solution{
    public boolean theMaze(int [][]maze, int []start, int[]destination){
        int m = maze.length;
        int n = maze[0].length;
        Queue<int []> q = new LinkedList<>();
        int row = start[0];
        int col = start[1];
        int [][]dirs = {{1,0}, { -1,0}, {0,1}, {0,-1}};
        maze[row][col] = 2;
        q.add(start);
        while(!q.isEmpty()){
            int []curr = q.poll();
            for(int[] dir: dirs){
                int nr = curr[0];
                int nc = curr[1];
                while(nr>=0 && nc>=0 && nr<m && nc<n && maze[nr][nc]!=1){
                    nr += dir[0];
                    nc += dir[1];
                }
                nr -= dir[0];
                nc -= dir[1];
                if(nr == destination[0] && nc == destination[1]){
                    return true;
                }
                if(maze[nr][nc]==0){
                    maze[nr][nc] = 2;
                    q.add(new int[]{nr,nc});
                }
                
            }
        }
        return false;
    }
}
// 2
class Solution{
    int [][]dirs = {{1,0}, { -1,0}, {0,1}, {0,-1}};
    public boolean theMaze(int [][]maze, int []start, int[]destination){
        int m = maze.length;
        int n = maze[0].length;
        return helper(maze, start, destination, m, n);
    }
    
    private boolean helper(int [][]maze, int []start, int[]destination, int m, int n){
        // base
        if(start[0] == destination[0] && start[1] == destination[1]) return true;
        if(maze[start[0]][start[1]] == 2) return false;
         
        //logic
        maze[start[0]][start[1]] = 2;
        for(int []dir: dirs){
            int nr = start[0];
            int nc = start[1];
            while(nr>=0 && nc>=0 && nr<m && nc<n && maze[nr][nc]!=1){
                nr += dir[0];
                nc += dir[1];
                }
            nr -= dir[0];
            nc -= dir[1];
            if(maze[nr][nc] !=2 && helper(maze, new int[]{nr,nc}, destination, m,n)){
                return true;
            }
            
        }
        return false;
    }
}