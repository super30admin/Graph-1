// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class theMaze {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(start[0]==destination[0] && start[1]==destination[1])
            return true;
        maze[start[0]][start[1]] = -1;
        
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        
        for(int[] dir:dirs){
            int nr = start[0]+dir[0];
            int nc = start[1]+dir[1];
            while(nr>=0 && nr<maze.length && nc>=0 && nc<maze[0].length &&
                 maze[nr][nc]!=1){
                nr += dir[0];
                nc += dir[1];
            }
            if(maze[nr-dir[0]][nc-dir[1]] != -1 && hasPath(maze,new int[]{nr-dir[0],nc-dir[1]},destination))
                return true;   
        }
        return false;
    }
}
