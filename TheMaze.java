class Solution {
    int[][] dirs;
    int m,n;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        this.m=maze.length;
        this.n=maze[0].length;
        this.dirs=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        
        if(start[0] == destination[0] && start[1]==destination[1]) return true;
         return dfs(maze, start[0],start[1],destination);
        
    }
    
    private boolean dfs(int[][] maze, int i, int j, int[] destination){
        
        if(i==destination[0] && j==destination[1]){
            return true;
        }
        
        if(maze[i][j]==2) return false;
        maze[i][j]=2;
        
        for(int[] dir:dirs){
            int r= dir[0]+i;
            int c= dir[1]+j;
            while(r>=0 && c>=0 && r<m && c<n && maze[r][c]!=1){
                r+=dir[0];
                c+=dir[1];
            }
            r-=dir[0];
            c-=dir[1];
            
            if(dfs(maze,r ,c, destination)) return true;
        }
        return false;
    }
}