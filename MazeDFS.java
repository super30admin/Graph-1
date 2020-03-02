//TC : O(mn), where m is the number of rows,n is number of cols
//SC : O(1)
class Solution {
    int m,n;
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze.length == 0 || maze == null)
            return false;
        
        m = maze.length;
        n = maze[0].length;
        
        return helper(maze,start,destination);
    }
    
    private boolean helper(int[][] maze,int []start,int[] destination){
        int i = start[0],j = start[1];
        //base case
        if(i == destination[0] && j == destination[1]) return true;
          
        //logic
        
        maze[i][j] = 2;
        for(int[] dir : dirs){
            //Save the starting row and column because you have to come back to this position
            //if you dont reach destination
            int r=i,c=j;
            
            //Travel in one direction
            while(r>=0 && r<m && c>=0 && c<n && maze[r][c]!=1){
                 r = r+dir[0];
                 c = c+dir[1];
            }
            
            //Since you overshoot, go back by one step
            r-=dir[0]; c-=dir[1];
            
            //If that node is not already visited, check if you can reach the destination from there
            //If yes, return true
            if(maze[r][c]!=2 && helper(maze,new int[]{r,c},destination)) return true;
        }
        
        return false;
    }
}