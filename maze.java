
//bfs solution
//tc is O(mxn)
//sc is O(mxn) 
import java.util.*;

class Solution {

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze == null || start == null || destination == null)
            return false;

        // breath first search
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { start[0], start[1] });
        maze[start[0]][start[1]] = 2;
        int m = maze.length;
        int n = maze[0].length;

        int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            // now we go UDLR

            for (int[] dir : dirs) {
                int r = curr[0];
                int c = curr[1];

                while (r >= 0 && r < m && c >= 0 && c < n && maze[r][c] != 1) {
                    r = r + dir[0];
                    c = c + dir[1];
                }

                r = r - dir[0];
                c = c - dir[1];

                if (maze[r][c] != 2) {
                    if (r == destination[0] && c == destination[1]) {
                        return true;
                    }

                    maze[r][c] = 2;
                    q.add(new int[] { r, c });
                }

            }

        }

        return false;
    }
}