// Time Complexity : O(MN)
// Space Complexity : O(MN)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

public class TheMaze {

    int[][] dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
    
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        
        if(start[0] == destination[0] && start[1] == destination[1]) return true;
        if(maze == null || maze.length == 0) return false;
        
        return helper(maze, start, destination, maze.length, maze[0].length, start[0], start[1]);
    }
    
    private boolean helper(int[][] maze, int[] start, int[] destination, int m, int n, int r, int c){
        // base case
        // If the current row and col index is equal to destinations row and col index, then return true.
        if(r == destination[0] && c == destination[1]) return true;
        // If the current position is already visited return false
        if(maze[r][c] == 2) return false;
        
        // logic
        //marking the node as visited.
        maze[r][c] = 2;
        // Fetch the new stopping point for ball in each direction.
        for(int[] dir: dirs){
            int i = r; int j = c;
            
            // In the selected direction traverse the array until the boundary is hit or a wall is hit.
            while(i >= 0 && i < m && j >=0 && j < n && maze[i][j] != 1){
                i += dir[0];
                j += dir[1];
            }
            // When a boundary or wall is hit, take 1 step back in that direction.
            // We do this because, in the previous loop we have iterated until we hit the stopping point.
            // so the row and col index are exactly on the wall or boundary.
            // Now we need to move 1 step back to move out of the wall and into the maze.
            i -= dir[0];
            j -= dir[1];
            
            // If my dfs at current location returns true, then return true.
            if(helper(maze, start, destination, m, n, i, j)) return true;
        }
        
        // Finally, if the destination is not met in any scenario, then we return false.
        return false;
    }
    
}
