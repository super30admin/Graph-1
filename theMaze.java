// Time Complexity : o k x (mxn)
// Space Complexity : o(mxn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Leetcode : 490
//Approach : DFS

class Solution {
    public int[][] dirs = {{0,1},{0,-1},{-1,0},{1,0}};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        if(maze == null || maze.length==0) return false;
        

        return DFS(maze, start, destination);  

    }
       
    public boolean DFS(int[][] maze, int[] start, int[] destination){
        //base
        if(start[0] == destination[0] && start[1]==destination[1]){
            return true;
        }
        if(maze[start[0]][start[1]]==2){
            return false;
        }
        
         maze[start[0]][start[1]]=2;
         for(int[] dir: dirs){
            int i = dir[0]+start[0];
            int j = dir[1]+start[1];
             while(i>=0 && j>=0 && i< maze.length && j< maze[0].length && maze[i][j]!=1){
                  i = i+ dir[0];
                  j = j+dir[1];
             }
             //bring back
             i =i- dir[0];
             j =j- dir[1];
             
             if(DFS(maze, new int[]{i,j}, destination)) return true;
        }
         return false;   
    }
   
}

// Time Complexity : o(k x m x n)
// Space Complexity : o(m x n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Leetcode : 490
//Approach : BFS


class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze == null || maze.length ==0 ) return false;
        
        int m = maze.length;
        int n = maze[0].length;
        
        Queue<int []> q = new LinkedList<>();
        
        q.add(start);
        maze[start[0]][start[1]] = 2;
        int[][] dirs = {{-1,0}, {1,0}, {0,1}, {0,-1}};
        while(!q.isEmpty()){
            int[] curr = q.poll();
            
            if(curr[0]== destination[0] && curr[1] == destination[1]) return true;
            for(int[] dir : dirs)
            {   
                int i = curr[0];
                int j = curr[1];
                while(i < m && j < n && i>=0 && j>=0 && maze[i][j] != 1){
                    i += dir[0];
                    j += dir[1];
                }
                
                //Go back to previous step
                i -= dir[0];
                j -= dir[1];
                
                //Add to queue and mark as visited if not visited
                if(maze[i][j] != 2){
                    
                    q.add(new int[] {i,j});
                    maze[i][j] = 2;
                }
               
            }
            
        }
        return false;
    }
}






