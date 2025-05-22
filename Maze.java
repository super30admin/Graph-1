//Time Complexity: O(m* n)
//Space Complexity: O(m* n)
// https://leetcode.com/problems/the-maze/


/**
 * Performs BFS to explore all reachable cells where the ball stops after rolling.  
 * Simulates rolling in each direction until hitting a wall, then backtracks one step to enqueue the stop point.  
 * Marks visited cells directly in the maze to ensure constant revisit checks with O(m*n) time and space.  
 */

public class Maze {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length; 
        int n = maze[0].length; 
        int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};

        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        
        while(!q.isEmpty()) {
            int[] curr = q.poll(); 

            if(curr[0] == destination[0] && curr[1] == destination[1]) {
                return true;
            }

            for(int[] dir : dirs) {
                int r = curr[0] + dir[0];
                int c = curr[1] + dir[1];
                // Move the ball in the chosen direction until it can.
                while(r >= 0 && c>=0 && r < m && c < n && maze[r][c] != 1) {
                    r += dir[0];
                    c += dir[1];
                }
                // Revert the last move to get the cell to which the ball rolls.
                r -= dir[0];
                c -= dir[1];
                if(maze[r][c] != -1) {
                    q.offer(new int[]{r,c});
                    maze[r][c] = -1; //mark it visited
                }
            }
        }
        return false;
    }
}
