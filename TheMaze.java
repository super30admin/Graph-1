// Time Complexity : O(M*N)
// Space Complexity : O(M*N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class TheMaze {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        if (start[0] == destination[0] && start[1] == destination[1]) {
            return true;
        }
        int[][] dirs = new int[][] { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        maze[start[0]][start[1]] = 2; // Mark it visited

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            // iterate over directions array
            for (int[] dir : dirs) {
                int r = curr[0];
                int c = curr[1];
                // iterate over row and columns until we are inbounds and don't hit the wall
                while (r >= 0 && r < m && c >= 0 && c < n && maze[r][c] != 1) {
                    r += dir[0];
                    c += dir[1];
                }
                // if we hit a wall, take a step back
                r -= dir[0];
                c -= dir[1];
                // if destination then return true
                if (r == destination[0] && c == destination[1]) {
                    return true;
                }
                // if not and it is not visited already, add the baby in the queue to process
                if (maze[r][c] != 2) {
                    q.add(new int[] { r, c });
                    maze[r][c] = 2; // mark the column visited
                }
            }
        }
        return false;
    }
}