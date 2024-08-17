// Time Complexity: O(m . n)
// Space Complexity: O(m . n)

class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int[][] dirs = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
        int m = maze.length;
        int n = maze[0].length;

        return dfs(maze, start, destination, m, n, dirs);

    }

    private boolean dfs(int[][] maze, int[] start, int[] destination, int m, int n, int[][] dirs) {
        // base
        if (start[0] == destination[0] && start[1] == destination[1]) {
            return true;
        }
        if (maze[start[0]][start[1]] == 2)
            return false;

        // logic
        maze[start[0]][start[1]] = 2;
        for (int[] dir : dirs) {
            int r = start[0] + dir[0];
            int c = start[1] + dir[1];

            while (r >= 0 && c >= 0 && r < m && c < n && maze[r][c] != 1) {
                r += dir[0];
                c += dir[1];
            }
            r -= dir[0];
            c -= dir[1];

            if (dfs(maze, new int[] { r, c }, destination, m, n, dirs))
                return true;
        }

        return false;
    }
}