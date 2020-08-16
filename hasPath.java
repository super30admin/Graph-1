// Time Complexity : O(m*n)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze==null || maze.length==0) return false;
        
        int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
        
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        maze[start[0]][start[1]]=2;
        
        while(!q.isEmpty()){
            int[] curr = q.remove();
            
                
            
            for(int[] dir : dirs)
            {     
                int row = curr[0];
                int col = curr[1];
                
            if(row==destination[0] && col==destination[1])
                        return true;
                while(row>=0 && col>=0 && row<maze.length && col<maze[0].length && (maze[row][col]==0 || maze[row][col]==2)){
                        row+=dir[0];
                        col+=dir[1];
                    }
                    //go back one step
                    row-=dir[0];
                    col-=dir[1];

                    if(maze[row][col]!=2){
                        maze[row][col]=2;

                        q.add(new int[]{row,col});
                    }
            }
        }
        return false;
    }
}