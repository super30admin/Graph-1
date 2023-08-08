
// Time Complexity - 0(m * n)
// Space Complexity - 0(m * n)

class Solution {
    int m, n;
    int[][] dirs;

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0) {
            return false;
        }
        m = maze.length;
        n = maze[0].length;

        dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        if (dfs(maze, start, destination)) {
            return true;
        }
        return false;
    }
    private boolean dfs(int[][] maze, int[] start, int[] destination) {

        if (maze[start[0]][start[1]] == 2) {
            return false;
        }
        if (start[0] == destination[0] && start[1] == destination[1]) {
            return true;
        }


        maze[start[0]][start[1]] = 2;
        for (int[] dir : dirs) {
            int r = start[0];
            int c = start[1];

            while (r < m && c < n && r >= 0 && c >= 0 && maze[r][c] != 1) {
                r = r + dir[0];
                c = c + dir[1];
            }
            r = r - dir[0];
            c = c - dir[1];

            if (dfs(maze, new int[] {r, c}, destination)) {
                return true;
            }
        }
        return false;
    }
}