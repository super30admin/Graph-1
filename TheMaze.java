// TC - O(m*n), SC - O(m+n)

// LC - 490

class Solution {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
		// call dfs function
        return dfs(maze, start[0], start[1], destination);
    }
    
    private boolean dfs(int[][] maze, int i, int j, int[] destination){
        // if current position is 2, this position is already checked and need not explore more
        if(maze[i][j] == 2){
            return false;
        }
        // Destination position
        if(i == destination[0] && j == destination[1]){
            return true;
        }
        // change position to 2 so that we will not visit again
        maze[i][j] = 2;
        // Iterating over dirs array
        for(int[] dir : dirs){
            int newRow = i + dir[0];
            int newCol = j + dir[1];
            
            while(newRow >= 0 && newRow < maze.length && newCol >= 0 && newCol < maze[0].length && maze[newRow][newCol] != 1){
                newRow += dir[0];
                newCol += dir[1];
            }
            
            newRow = newRow - dir[0];
            newCol = newCol - dir[1];
            // call dfs function again
            if(dfs(maze, newRow, newCol, destination)){
                return true;
            }
            
        }
        
        return false;
        
        
    }
}