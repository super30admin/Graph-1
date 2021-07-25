
/**
 * TC: O(M*N * Max(M,N)), M * N for each cell in the matrix, Max(M,N) to find the wall from a cell 
 * SC O(M*N)
 * Approach: Perform a BFS or DFS on the matrix from start and traverse in the 4 directons.
             Continue traversing until the traversal reaches the destination or the traversal ends.
             Move in each direction until the traversal hits a wall, then backup in the direction opposite to traversal
             Check if that position has been visited or not, if yes then skip and if not then add that cell for traversal.
             Mark a cell as visited when it is added to the queue to avoid the wall bouncing endlessly between the walls.
 */
// BFS
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        
        // base case
        if(maze == null || maze.length == 0 || maze[0].length == 0) {
            return false;
        }
        
        // intialize variables
        int rows = maze.length, cols = maze[0].length;
        int[][] directions = new int[][] {{0,1}, {1,0}, {0, -1}, {-1, 0}};
        Queue<int[]> q = new LinkedList<>();
        
        // start traversal from start
        q.add(start);
        maze[start[0]][start[1]] = 2;
        
        // execute the traversal
        while(!q.isEmpty()) {
            // remove the grid position from the queue
            int[] currentPosition = q.poll();
            
            // get row position and col position
            int currentRowPosition = currentPosition[0], currentColPosition = currentPosition[1];
            
            // check if the traversal reached the destination
            if(currentRowPosition == destination[0] && currentColPosition == destination[1]) {
                return true;
            }
            
            // ➡ ⬇ ⬅ ⬆
            for(int[] direction : directions) {
                
                // get next row and col position in the current direction 
                int nextRowPosition = currentRowPosition + direction[0], nextColPosition = currentColPosition + direction[1];
                
                // find the wall in the current direction
                while(withinMaze(nextRowPosition, nextColPosition, rows, cols) && maze[nextRowPosition][nextColPosition] != 1) {
                    nextRowPosition += direction[0];
                    nextColPosition += direction[1];
                }
                
                // backup in the direction to go from wall to a valid empty grid position in the maze
                nextRowPosition -= direction[0];
                nextColPosition -= direction[1];
  
                // if this position has not been visited yet then mark it as visited and enqueue it
                if(maze[nextRowPosition][nextColPosition] != 2) {
                    maze[nextRowPosition][nextColPosition] = 2;
                    q.add(new int[]{nextRowPosition, nextColPosition});
                }
            }
        }
        
        // destination is unreachable
        return false;
    }
    
    // helper function to check if (row, col) is within maze dimensions
    private boolean withinMaze(int row, int col, int rows, int cols) {
        
        return (row >= 0 && col >= 0 && row < rows && col < cols);
    }
}

// DFS
class Solution {
    int[][] directions;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        
        // base case
        if(maze == null || maze.length == 0 || maze[0].length == 0) {
            return false;
        }
        
        // intialize variables
        directions = new int[][] {{0,1}, {1,0}, {0, -1}, {-1, 0}};
        
        // execute the traversal
        return dfs(maze, start, destination);        
    }
    
    private boolean dfs(int[][] maze, int[] start, int[] destination) {
        // base case
        if(start[0] == destination[0] && start[1] == destination[1]) {
            return true;
        }
        
        // if current cell is visited then return false
        if(maze[start[0]][start[1]] == 2) {
            return false;
        }
        
        // logic
        // mark current cell as visited
        maze[start[0]][start[1]] = 2;
        
        // ➡ ⬇ ⬅ ⬆
        for(int[] direction : directions) {
            // get next row and col position in the current direction 
            int nextRowPosition = start[0] + direction[0], nextColPosition = start[1] + direction[1];
            
            // find the wall in the current direction
            while(withinMaze(nextRowPosition, nextColPosition, maze.length, maze[0].length) && maze[nextRowPosition][nextColPosition] != 1) {
                 nextRowPosition += direction[0];
                 nextColPosition += direction[1];
            }
            
            // backup in the direction to go from wall to a valid empty grid position in the maze
            nextRowPosition -= direction[0];
            nextColPosition -= direction[1];
  
            // traverse this new cell
            if(dfs(maze, new int[] {nextRowPosition, nextColPosition}, destination)) {
                return true;
            }
            
        }
        
        return false;
    }
    
    // helper function to check if (row, col) is within maze dimensions
    private boolean withinMaze(int row, int col, int rows, int cols) {
        
        return (row >= 0 && col >= 0 && row < rows && col < cols);
    }
}
