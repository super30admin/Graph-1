//TC - O(m*n)
//SC -O(1)
class Solution {
    int[][] directions;
    int m, n;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze == null || maze.length == 0)    return false;
        m = maze.length;
        n = maze[0].length;
        directions = new int[][]{ {0,1}, {0,-1}, {-1,0}, {1,0} }; 
        return dfs(maze, start, destination); 
    }
    
    
    public boolean dfs(int[][] maze, int[] curr, int[] destination){
        //Base 
        
        if(maze[curr[0]][curr[1]] == 2) return false;
        if(curr[0] == destination[0] && curr[1] == destination[1])  return true
        maze[curr[0]][curr[1]] = 2;
            
        for(int[] d : directions){
                int i = curr[0]; 
                int j = curr[1]; 
                
                while(i >= 0 && i < m && j >= 0 && j < n && maze[i][j] != 1){ 
                    i += d[0];
                    j += d[1];
                }
                i -= d[0];
                j -= d[1];
                
                if(dfs(maze, new int[]{i, j}, destination)) return true;
            }
        return false;  
    }

}
