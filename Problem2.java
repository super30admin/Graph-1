package Graph-1;
//TC : O(m*n)
//SC : O(m*n)
public class Problem2 {
    int[][] dirs;
    int m,n;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        this.m = maze.length;
        this.n = maze[0].length;
        this.dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        if(start[0]==destination[0] && start[1]==destination[1]) return true;
        return dfs(maze, start[0], start[1], destination);
    }

    private boolean dfs(int[][] maze, int i, int j, int[] destination){
        //base condition
        if(destination[0]==i && destination[1]==j) return true;
        if(maze[i][j]==2) return false;

        //logic
        maze[i][j]=2;
        for(int[] dir: dirs){
            int r = i+dir[0];
            int c = j+dir[1];
            while(r>=0&&c>=0 && r<m&&c<n && maze[r][c]!=1){
                r+=dir[0];
                c+=dir[1];
            }
            r-=dir[0];
            c-=dir[1];
            if(dfs(maze,r,c,destination)){
                return true;
            }
        }

        return false;
    }
    
}
