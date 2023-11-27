// Time Complexity :O(m*n*(m+n)
// Space Complexity : O(m*n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
     if (maze==null) return false;   
     int m = maze.length;
     int n = maze[0].length;
    if(start[0]== destination[0] && start[1]== destination[1]) return true;

     int[][] dirs = new int[][]{{-1,0},{0,1},{1,0},{0,-1}} ;  
     Queue<int[]> q = new LinkedList<>();
     q.add(start);
     maze[start[0]][start[1]]  =2;  
     while(!q.isEmpty()){
         int[] curr = q.poll();
         for(int[] dir: dirs){
         int r = curr[0];
         int c = curr[1];
         while(r <m && r>=0 && c <n && c >=0 && maze[r][c] !=1){
          r += dir[0];      
          c += dir[1];   
         }
         //step back
          r -= dir[0];      
          c -= dir[1]; 
        if(r== destination[0] && c== destination[1]) return true;
             
    if(maze[r][c] != 2){  
         q.add(new int[]{r,c});    
         maze[r][c] =2;
            
        }
     }    
        
    }
        return false;
 } 
}
