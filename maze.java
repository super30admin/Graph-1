//Tc O(N*M)
//SC O(1)
class Solution {
    
    int[][] directions = {{0,1},{0,-1},{-1,0},{1,0}};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        
        if(start[0] == destination[0] && start[1] == destination[1])
                return true;
        
        int row = maze.length;
        int col = maze[0].length;
        
        boolean flag = false;
        
        flag = dfs(start[0],start[1],destination,maze);
        
        return flag;
    }
    
    public boolean dfs(int i, int j, int[] destination,int[][] maze){
       
        if(i < 0 || j < 0 || i >= maze.length || j >= maze[0].length || maze[i][j] == 3){
            return false;
        }
        
        if(i == destination[0] && j == destination[1]) return true;
        
        
        maze[i][j] = 3;
        
        for(int[] direction : directions){
            
            int adjX = i + direction[0];
            int adjY = j + direction[1];
            
            
            while(isValid(adjX,adjY,maze) && maze[adjX][adjY] != 1){
                
                 adjX = adjX + direction[0];
                 adjY = adjY + direction[1];
            }
            
            adjX = adjX - direction[0];
            adjY = adjY - direction[1];
            
            if(maze[adjX][adjY] != 3 && dfs(adjX,adjY,destination,maze)){
                return true;
            }
            
        }
       
        
        return false;
    }
    
    
    public boolean isValid(int i, int j, int[][] maze){
         if(i < 0 || j < 0 || i >= maze.length || j >= maze[0].length){
            return false;
        }
        return true;
    }
}