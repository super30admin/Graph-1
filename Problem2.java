//Time = O(mn), where m and n are the dimensions of the maze grid
//Space = O(mn)

class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        
        // Use a boolean array to keep track of visited cells
        boolean[][] visited = new boolean[m][n];
        
        // Initialize the queue with the starting cell
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        visited[start[0]][start[1]] = true;
        
        // Define possible directions of movement
        int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        
        // Keep exploring the maze until the queue is empty
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            // If the current cell is the destination, return true
            if (curr[0] == destination[0] && curr[1] == destination[1]) {
                return true;
            }
            
            // Try moving in each direction
            for (int[] dir : dirs) {
                int x = curr[0] + dir[0];
                int y = curr[1] + dir[1];
                
                // Continue in the same direction until a wall is reached
                while (x >= 0 && y >= 0 && x < m && y < n && maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];
                }
                
                // Go back one step to get the last valid position
                x -= dir[0];
                y -= dir[1];
                
                // If this cell has not been visited yet, add it to the queue and mark it as visited
                if (!visited[x][y]) {
                    queue.offer(new int[]{x,y});
                    visited[x][y] = true;
                }
            }
        }
        
        // If the queue becomes empty without reaching the destination, return false
        return false;
    }
}
