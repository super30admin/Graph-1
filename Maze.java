// Time Complexity : O(nm)
// Space Complexity : O(nm)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
// BFS
class Solution {
   
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
       if(maze==null || maze.length==0 || maze[0].length==0)
           return false;
        
        int n = maze.length;
        int m = maze[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        int x= start[0];
        int y= start[1]; 
        q.add(new int[]{x,y});
        
        boolean[][] visited = new boolean[n][m];
        visited[x][y] = true;
        
        int directions[][] = {{1,0}, {-1, 0}, {0,1}, {0,-1}};
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            
            if(curr[0]==destination[0] && curr[1]==destination[1]){
                return true;
            }
            for(int[] dir: directions){
                int i = curr[0] + dir[0];
                int j = curr[1] + dir[1];
                
                if(dir[0]==0){
                    while(j>=0 && j< m  && maze[i][j]==0){
                        j += dir[1]; 
                    }
                    j -= dir[1];
                }else if(dir[1]==0){
                    while(i>=0 && i<n && maze[i][j]==0){
                        i += dir[0];
                    }
                    i -= dir[0];
                }
                
                if(!visited[i][j]){
                    q.add(new int[]{i,j});
                    visited[i][j] = true;
                }         
            }
        }
        return false;
    }
}