package Dec20;

import java.util.LinkedList;
import java.util.Queue;

class TheMaze {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        
        /*
        Time complexity: O(mn) where mn is the no.of cells in the maze. Worst case, we will have to traverse through all mn elements of the maze.
        Space complexity: O(mn) where mn is the no.of cells in the maze. The extra space taken by queue will be almost tending to mn number of elements. One element popped from queue will add almost 4 neighbors to the queue and each of those 4 will their 4 neighbors each to the queue.
        
        Approach: BFS performed using queue.
        
        */
        
        // edge
        if (maze == null || maze[0].length == 0 || start == null || start.length == 0 || destination == null || destination.length == 0) {
            return false;
        }
        
        int m = maze.length;
        int n = maze[0].length;
        
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        
        maze[start[0]][start[1]] = 2;
        
        // Perform BFS. Add start position coordinates to queue.
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start[0], start[1]});        
        
        // In while loop for BFS, poll an element from queue. 
        while (!queue.isEmpty()) {
            
            int[] curr = queue.poll();
            
            // breaking condition: when current cell is destination cell- return true
            if (curr[0] == destination[0] && curr[1] == destination[1]) {
                return true;
            }
            
             // For this polled element, which will be a pair of x,y coordinates of a cell in the maze, check neighbors in all 4 directions one by one. A cell for currently in process cell(polled element) will be considered neighbor only when it hits the boundary wall or an obstruction in the maze.
            for (int[] dir: dirs) {
                
                int x = curr[0];
                int y = curr[1];
                
                // keep moving in one 'dir' from current cell till we hit a wall/obstruction(cell with value 1)   
                while (x >= 0 && y >= 0 && x < m && y < n && maze[x][y] != 1) {
                    x = x + dir[0];
                    y = y + dir[1];
                }
                
                // bring back x and y to the position before obstruction as in the previous while loop, the values of x and y would have reached the obstruction/wall cell.
                 x = x - dir[0];
                 y = y - dir[1];
                
                // Mark each neighbor as visited if it is not already visited.
                // Add the marked neighbor to the queue.
                if (maze[x][y] != 2 && maze[x][y] != 1) {
                    queue.add(new int[]{x,y});
                }
                maze[x][y] = 2;
            }  
        }
       return false;
    }
}   