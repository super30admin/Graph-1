// O(n * m) time, O(n * m) space

import java.util.*;

class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int n = maze.length;
        int m = maze[0].length;

        int[][] dirs = new int[][] {
            {1,0},{0,1},{0,-1},{-1,0}
        };
        boolean[][] visited = new boolean[n][m];

        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        visited[start[0]][start[1]] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            if (curr[0] == destination[0] && curr[1] == destination[1]) {
                return true;
            }

            for (int[] dir : dirs) {
                int r = dir[0] + curr[0];
                int c = dir[1] + curr[1];

                // keep moving ball until inbounds and is empty space
                while (r >= 0 && c >= 0 && r < n && c < m && maze[r][c] == 0) {
                    r += dir[0];
                    c += dir[1];
                }
                r -= dir[0];
                c -= dir[1];

                if (!visited[r][c]) {
                    q.offer(new int[]{r,c});
                    visited[r][c] = true;
                }

            }
        }
        return false;
    }
}
