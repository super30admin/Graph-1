//TC O(m*n)
//SC O(max no of stops ,m*n)
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        return dfs(maze,destination,start[0],start[1]);
    }
    private int [][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
    private boolean dfs(int[][] maze, int[] dest, int i, int j){
        //if i & j indicates a visited node
        if( maze[i][j] == 2 )
            return false;
        
        if( i == dest[0] && j == dest[1] )
            return true;
        
        maze[i][j] = 2;//visited node
        
        for(int[] dir: dirs){
            int r = i;
            int c = j;
            while(r >= 0 && r < maze.length && c >= 0 && c < maze[0].length && maze[r][c] != 1)            
            {
                r = r + dir[0];
                c = c + dir[1]; 
            }
                r = r - dir[0];
                c = c - dir[1];
            if(dfs(maze, dest, r, c))
                return true;
        }
        
        return false;
    }
}