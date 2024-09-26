// Time Complexity :O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach

class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
       int m = maze.length;
       int n = maze[0].length;
        
       boolean[][] visited = new boolean[m][n];
       int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
       return dfs(maze, visited, start, destination, dirs);
    }
    
    public boolean dfs(int[][] maze, boolean[][] visited, int[] start, int[] destination, int[][] dirs){
        //base case
        if(start[0]==destination[0] && start[1]==destination[1]){
            return true;
        }
        
        visited[start[0]][start[1]]=true;
        for(int[] dir : dirs){
            
            int r = start[0];
            int c = start[1];
            
            while(r+dir[0]>=0 && r+dir[0]<maze.length && c+dir[1]>=0 &&
                  c+dir[1] <maze[0].length && maze[r+dir[0]][c+dir[1]]==0){
                r+=dir[0];
                c+=dir[1];
            }
            if(!visited[r][c] && dfs(maze, visited, new int[] {r, c}, destination, dirs))
            {
                return true;
            }
        }
        
        return false;
    }
}