// S30 Big N Problem #114 {Medium}
// 490. The Maze
// Time Complexity :O(m*n)
// Space Complexity :O(m*n) recursive stack to store stoping indices 
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
// DFS Solution
class Solution {
    int m; int n;
    int [][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
    
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze.length==0 || maze==null) return false;
        m=maze.length;
        n=maze[0].length;
        return dfs(maze, start, destination);
    }
    
    private boolean dfs(int [][] maze, int[] start, int[] destination){
        int r=start[0]; int c=start[1];
        
        //base case
        if(r==destination[0] && c==destination[1]) return true;
        
        //logic
        maze[r][c]=2;
        for(int[] dir:dirs){
            int i=r; int j=c;
            
            while(i>=0 && i<m && j>=0 && j<n && maze[i][j] !=1){
                i+=dir[0];
                j+=dir[1];
            }
            
            //bring back to the stoping point
            i-=dir[0];
            j-=dir[1];
            
            
            if(maze[i][j] !=2 && dfs(maze,new int[] {i,j}, destination)) return true;     
        }
        return false;
    }
}