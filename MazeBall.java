/*
 * Time complexity : O(m*n)
 * Space complexity : O(1)
 */
class Solution {
    
    int m, n;
    int dirs[][] = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
    
        if(maze == null || maze.length == 0){
            return false;
        }
        
        m = maze.length;
        n = maze[0].length;
        
        return dfs(maze, start, destination);
    }
    
    private boolean dfs(int[][] maze, int[] start, int[] dest){
        
        int i = start[0];
        int j = start[1];
        
        //base case
        if(i == dest[0] && j == dest[1]){
            return true;
        }
        
        
        //logic
        maze[i][j] = 2;
        for(int[] dir : dirs){
            
            int r = i;
            int c = j;
            
            while( r >= 0  && r < m && c >= 0 && c < n && (maze[r][c] == 2 || maze[r][c] == 0)){
                r = r + dir[0];
                c = c + dir[1];
            }
            
            r = r - dir[0];
            c = c - dir[1];
            
            if(maze[r][c] != 2 && dfs(maze, new int[]{r, c}, dest)){
                return true;
            }
            
        }
        
        return false;
    }
}