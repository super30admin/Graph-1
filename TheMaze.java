import java.util.LinkedList;
import java.util.Queue;

/**
 * Time Complexity: O(m*n) * O(m+n)
 * Space Complexity: O(m+n)
 * Did this code successfully run on Leetcode: Yes
 * Any problem you faced while coding this: None

 * Approach:
 * Can use BFS/DFS to go over and find the boundaries/walls
 */

public class TheMaze {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int[][] dirs = new int[][] {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        int m = maze.length;
        int n = maze[0].length;

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[] {start[0], start[1]});
        maze[start[0]][start[1]] = 2;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            if (curr[0] == destination[0] && curr[1] == destination[1]) {
                    return true;
                }
            for (int[] dir: dirs) {
                int nr = curr[0];
                int nc = curr[1];

                while (nr >= 0 && nr < m && nc >= 0 && nc < n && maze[nr][nc] != 1) {
                    nr += dir[0];
                    nc += dir[1];
                }

                nr -= dir[0];
                nc -= dir[1];
                if(maze[nr][nc] != 2) {
                    q.add(new int[] { nr, nc});
                    maze[nr][nc] = 2;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        // Your code here
    }
}