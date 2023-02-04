// Approach: BFS modified for free flow condition
// Time: O(mn)
// Space: O(mn)

import java.util.*;

class TheMaze {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        // mark first cell visited by cell value = 2
        maze[start[0]][start[1]] = 2;
        int m = maze.length, n = maze[0].length;
        int dirs[][] = new int[][] {{1,0}, {0,1}, {-1,0}, {0,-1}};

        while (!q.isEmpty()) {
            int curr[] = q.poll();
            for (int dir[] : dirs) {
                int r = curr[0];
                int c = curr[1];
                // in boundaries check and free flow until obstacle logic
                while (r>=0 && c>=0 && r<m && c<n && maze[r][c] != 1) {
                    r += dir[0];
                    c += dir[1];
                }
                // one step back after hitting obstacle
                r -= dir[0];
                c -= dir[1];
                // check if destination reachable yet
                if (r == destination[0] && c == destination[1]) return true;
                if (maze[r][c] == 0) {
                    q.add(new int[]{r,c});
                    maze[r][c] = 2;
                }
            }
        }
        return false;
    }
}