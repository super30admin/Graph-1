// Time Complexity : O(mn)
// Space Complexity :O(mn)
// Did this code successfully run on Leetcode : no
// Any problem you faced while coding this : checking stopping condition 

// Your code here along with comments explaining your approach
// idea is to do a dfs and see if destination can be reached
// then need to evaluate stopping condition, if ball can be stopped there, is it end of dfs
// need to write stopping condition correctly

class Solution {
    boolean canBeReached;
    boolean[][] visited;
    
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        visited = new boolean[maze.length][maze[0].length];
        dfs(maze, start[0], start[1], destination[0], destination[1]);
        
        return canBeReached;
    }
    
    private void dfs(int[][] maze, int r, int c, int dr, int dc){
        if(r<0 || r>=maze.length || c<0 || c>=maze[0].length || visited[r][c]==true || maze[r][c]==1){
            return;
        }
        
        visited[r][c] = true;
        if(r==dr && c==dc && (r-1==-1 || c-1==-1 || r+1==maze.length || c+1==maze[0].length || maze[r-1][c]==1 || maze[r+1][c]==1 || maze[r][c-1]==1 || maze[r][c+1]==1)){
            canBeReached = true;
            return;
        }
        
        dfs(maze, r-1, c, dr, dc);
        dfs(maze, r+1, c, dr, dc);
        dfs(maze, r, c-1, dr, dc);
        dfs(maze, r, c+1, dr, dc);
    }
}