// BFS
// Time Complexity: O(mn * max(m, n)) = O(mn * constant) = O(mn)
// Space Complexity: O(mn)
import java.util.*;
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        // null
        if(maze == null) return false;
        int m = maze.length, n = maze[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        maze[start[0]][start[1]] = 2;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; // right, left, bottom, top
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            for(int[] dir: dirs) {
                int row = curr[0];
                int col = curr[1];
                // hit the wall
                while(row >= 0 && col >= 0 && row < m && col < n && maze[row][col] != 1) {
                    row = row + dir[0];
                    col = col + dir[1];
                }
                // come back one step
                row = row - dir[0];
                col = col - dir[1];
                // wherever it stops
                if(maze[row][col] == 0) {
                    if(row == destination[0] && col == destination[1])
                        return true;
                    maze[row][col] = 2;
                    q.add(new int[]{row, col});
                }
            }
        }
        return false;
    }
}