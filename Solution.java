class Solution {
    int [][] dirs;
    int m;
    int n;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze==null|| maze.length==0) return false;
        
        
        m= maze.length;
         n= maze[0].length;
        
        
        
        
        dirs= new int [][] {{0,1},{0,-1},{1,0},{-1,0}};
        
        
        
        return dfs(maze, start,destination);
        
    }
    
    
    
    private boolean dfs(int [] [] maze, int [] start, int [] destination){
        
        //base
        if(maze[start[0]][start[1]]==2) return false;
        
        if(start[0]==destination[0]&&start[1]==destination[1]) return true;
        
        
        
        
        
        
        
        
        //main
        
        maze[start[0]][start[1]]=2;
        
        for(int [] dir :dirs){
            int i=start[0];
            int j=start[1];
            
            
            
            while(i>=0&&j>=0&& i<m && j<n && maze[i][j]!=1){
                i=i+dir[0];
                j=j+dir[1];
            }
            
            
            
            
            i=i-dir[0];
            j=j-dir[1];
            
        
            
            if(dfs(maze, new int [] {i,j},destination)) return true;
            
            
            
        }
        
         return false;
        
        
        
        
    }
    
   
    
    
}
