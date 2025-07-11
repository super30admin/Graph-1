// Approach :
// Use BFS to explore all positions the ball can stop at by rolling in each direction until it hits a wall, stepping back, and checking if it matches the destination.
// Mark visited positions to avoid cycles and redundant work during exploration.
// Repeat until the queue is empty or the destination is reached.

// Time Complexity (TC):
// O(m * n)
// where m = number of rows, n = number of columns, since each cell is visited at most once, and in each visit, you may traverse along the entire row or column while rolling, but overall it is bounded by the total cells.

// Space Complexity (SC):
// O(m * n)

public class Solution {
    /**
     * @param maze: the maze
     * @param start: the start
     * @param destination: the destination
     * @return: whether the ball could stop at the destination
     */
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        Queue<int[]> q = new LinkedList<>();
        int m = maze.length;
        int n = maze[0].length;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        q.add(new int[] {start[0], start[1]});
        maze[start[0]][start[1]] = 2; // mark as visited
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            for (int[] dir : dirs) {
                int r = curr[0];
                int c = curr[1];
                // Roll the ball until it hits a wall
                while (r >= 0 && r < m && c >= 0 && c < n && maze[r][c] != 1) {
                    r += dir[0];
                    c += dir[1];
                }
                // Step back to the last valid position
                r -= dir[0];
                c -= dir[1];
                
                if (r == destination[0] && c == destination[1]) {
                    return true;
                }
                
                if (maze[r][c] == 0) { // not visited
                    q.add(new int[] {r, c});
                    maze[r][c] = 2; // mark as visited
                }
            }
        }
        return false;
    }
}
