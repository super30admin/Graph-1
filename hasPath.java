class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int [][]dirs=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        int n = maze.length;
        int m=maze[0].length;
        maze[start[0]][start[1]]=2;
        return dfs(start[0],start[1],destination[0],destination[1],n,m,maze,dirs);
    }
    private boolean dfs(int i, int j, int ei, int ej, int n, int m, int[][]maze, int[][]dirs){
        if(i==ei && j==ej) return true;
        for(int[] dir:dirs){
            int nr=i+dir[0];
            int nc=j+dir[1];
            while(nr>=0 && nc>=0 && nr<n && nc<m && maze[nr][nc]!=1){
                nr+=dir[0];
                nc+=dir[1];
            }
            nr-=dir[0];
            nc-=dir[1];
            if(maze[nr][nc]!=2){
                maze[nr][nc]=2;
                if(dfs(nr,nc,ei,ej,n,m,maze,dirs)){
                    return true;
                }
            }
        }
        return false;
    }
}
