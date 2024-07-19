//time O(m*n)
//space O(m*n)

class Solution {
    boolean flag = false;
    int m = 0;
    int n = 0;
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        m = maze.length;
        n = maze[0].length;
        int row = start[0];
        int col = start[1];
        dfs(maze, row, col, destination); 
        return flag;
    }
    
    private void dfs(int[][] maze, int r, int c, int[] destination) {
        //base
        if(r == destination[0] && c == destination[1]) {
            flag = true;
            return;
        }
        
        //logic
        maze[r][c] = -1;
        for(int[] dir: dirs) {
            int nr = r;
            int nc = c;
            while(nr >= 0 && nc >= 0 && nr < m && nc < n && maze[nr][nc] != 1) {
                nr += dir[0];
                nc += dir[1];
            }
            nr -= dir[0];
            nc -= dir[1];
            if(maze[nr][nc] != -1) {
                dfs(maze, nr, nc, destination);
            }
            
        }
        
    } 
}
