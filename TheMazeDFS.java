//Time Complexity - O(m*n)
//Space Complexity - O(m*n)

class Solution {
     int[][]dirs;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze == null) return false;
        int m = maze.length; int n = maze[0].length;
        dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
       
       return dfs(maze,start,destination,m,n);
    }
    private boolean dfs(int[][] maze, int[] start, int[] destination, int m, int n) {
        //base
        if(start[0] == destination[0] && start[1] == destination[1]) {
            return true;
        }
        //logic
        //mark the starting point is visited
        maze[start[0]][start[1]] = 2;
        for(int[] dir : dirs) {
            int i = start[0];
            int j = start[1];
            //move untill ball hit the border wall or obastacle
            while(i < m && j < n && i >=0 && j >= 0 &&maze[i][j] !=1) {
                i += dir[0];
                j += dir[1];
            }
            //ball should stop before obastacle. Undo the extra step moved by ball
            i -= dir[0];
            j -= dir[1];
            //next starting point for ball
            int[] newStart = new int[]{i,j};
            if(maze[i][j] !=2 && dfs(maze,newStart,destination,m,n)) {
                return true;
            }
            
        }
        return false;
    }
}