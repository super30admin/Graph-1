/*
TC : O(m*n)
SC: O(m*n)
Explore all 4 dorections where its emoty and recurse along one path
 */
class Maze {
    int [][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    int m = 0;
    int n = 0;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze==null || maze.length==0 || maze[0].length==0){
            return false;
        }
        m = maze.length;
        n = maze[0].length;
        boolean [][] visited = new boolean[m][n];
        visited[start[0]][start[1]]=true;
        return dfs(maze, start[0], start[1], destination, visited);
    }
    public boolean dfs(int[][]maze,int r, int c, int [] destination,  boolean [][] visited){
        if(r==destination[0] && c==destination[1]){
            return true;
        }
        visited[r][c] = true;
        for(int [] dir : dirs){
            int nr = r;
            int nc = c;
            while(nr+dir[0]>=0 && nr+dir[0]<m && nc+dir[1]>=0 && nc+dir[1]<n && maze[nr+dir[0]][nc+dir[1]]==0){
                nr+=dir[0];
                nc+=dir[1];
            }
            if(!visited[nr][nc] && dfs(maze, nr, nc, destination, visited)) {
                return true;
            }
        }
        return false;
    }
}