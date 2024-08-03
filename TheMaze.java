//TC - O(m * n)(m + n)
//SC - O(m * n)
class Solution {
    int[][] dirs;
    int m, n;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze == null || maze.length == 0)
        {
            return false;
        }
        m = maze.length;
        n = maze[0].length;
        dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        return dfs(maze,start,destination);


        
    }
    private boolean dfs(int[][] maze, int[] start, int[] dest){
        if(start[0] == dest[0] && start[1] == dest[1]){
            return true;
        }
        //logic
        maze[start[0]][start[1]] = 2;
        for(int[] dir : dirs){
            int nr = start[0];
            int nc = start[1];
            while(nr >= 0 && nr < m && nc >= 0 && nc < n && maze[nr][nc] != 1){
                nr = nr + dir[0];
                nc = nc + dir[1];
            }
            nr = nr - dir[0];
            nc = nc - dir[1];
            if(maze[nr][nc] != 2){
                if(dfs(maze, new int[]{nr,nc}, dest)){
                    return true;
                }
            }

        }
        return false;
    } 
}
