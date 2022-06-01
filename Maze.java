// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach
class Maze {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0)
            return false;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { start[0], start[1] });
        maze[start[0]][start[1]] = 2;

        int[][] dirs = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int m = maze.length;
        int n = maze[0].length;

        while (!q.isEmpty()) {
            int sz = q.size();

            for (int i = 0; i < sz; i++) {
                int[] cur = q.poll();

                for (int[] dir : dirs) {
                    int r = cur[0];
                    int c = cur[1];

                    while (r >= 0 && r < m && c >= 0 && c < n && maze[r][c] != 1) {
                        r = r + dir[0];
                        c = c + dir[1];
                    }

                    r = r - dir[0];
                    c = c - dir[1];

                    if (cur[0] == destination[0] && cur[1] == destination[1]) {
                        return true;
                    }

                    if (maze[r][c] != 2) {
                        q.offer(new int[] { r, c });
                        maze[r][c] = 2;
                    }
                }
            }
        }
        return false;
    }
}