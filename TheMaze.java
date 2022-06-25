// Time Complexity :O(mn)
// Space Complexity :O(mn)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (start[0] == destination[0] && start[1] == destination[1])
            return true;
        int[][] dirs = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
        int m = maze.length;
        int n = maze[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        maze[start[0]][start[1]] = 2;
        // processing all routes
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int i = curr[0];
            int j = curr[1];
            for (int[] dir : dirs) {
                int r = i;
                int c = j;
                // if out of bounds or found 1, will break
                while (r < m && r >= 0 && c < n && c >= 0 && maze[r][c] != 1) {
                    r += dir[0];
                    c += dir[1];
                }
                // taking one step back
                r -= dir[0];
                c -= dir[1];
                // if got destination return true
                if (r == destination[0] && c == destination[1])
                    return true;
                // marking the location visited and adding in queue
                if (maze[r][c] != 2) {
                    maze[r][c] = 2;
                    q.add(new int[] { r, c });
                }

            }
        }
        return false;
    }
}