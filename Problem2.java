// Time Complexity : O(N^N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes, 4ms
// Any problem you faced while coding this :

/**
 *  Took the dfs approach and traverse in all the 4 directions, once you hit the wall, backtrack recursivelt to the
 * original position, and traverse again, till the destination is reached
 * 
 */

class Solution {
    
    int[] vertical = new int[]{-1,1,0,0};
    int[] horizontal = new int[]{0,0,-1,1};
    
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        
        return dfs(maze, start, destination);
    }
    
    private boolean dfs(int[][] maze, int[] pos, int[] dest){
        
        if(maze[pos[0]][pos[1]] == 2){
            return false;
        }
        
        if(pos[0] == dest[0] && pos[1] == dest[1]){
            return true;
        }
        
        maze[pos[0]][pos[1]] = 2;
        
        boolean reachedDest = false;
        
        for(int i = 0; i < horizontal.length; i++){
            
            int x = pos[0] + vertical[i];
            int y = pos[1] + horizontal[i];
            
            
        while(x >=0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] != 1){
            
            x += vertical[i];
            y += horizontal[i];
        }
            
        
          reachedDest =  reachedDest || dfs(maze, new int[]{x - vertical[i], y-horizontal[i]}, dest);
        }

        return reachedDest;
            
    }
}