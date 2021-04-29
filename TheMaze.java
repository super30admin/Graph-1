class Solution {
    int[][] dirs = {{1,0},{-1,0},{0,1},{0, -1}};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        return path(maze, start[0], start[1], destination);
    }
    
    private boolean path(int[][] maze, int row, int col, int[] destination){
        //base comditions
        if(maze[row][col] == 2){
            return false;
        }
        
        if(row == destination[0] && col == destination[1]){
            return true;
        }
        
        //marking node as visited
        maze[row][col] = 2;
        
        //trying to move in all possible directions to reach the destination
        for(int[] dir : dirs){
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            
            while(newRow >= 0 && newRow < maze.length && newCol >= 0 && newCol <maze[0].length && maze[newRow][newCol] != 1){
                newRow = newRow + dir[0];
                newCol = newCol + dir[1];
            }
            newRow = newRow - dir[0];
            newCol = newCol - dir[1];
            
            if(path(maze, newRow, newCol, destination)){
                return true;
            }
        }
        return false;
    }
}

// Time Complexity: O(mn)
// Space Complexity: O(1)