//tc is O(mxn)
//sc is O(mxn)
class Solution {
    int[][] dirs;
    int m, n;

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze == null || start == null || destination == null)
            return false;

        // depth first search
        m = maze.length;
        n = maze[0].length;

        dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };

        return dfs(maze, start, destination);
    }

    private boolean dfs(int[][] maze, int[] start, int[] dest) {
        // base
        if (start[0] == dest[0] && start[1] == dest[1])
            return true;

        // logic
        maze[start[0]][start[1]] = 2;

        for (int[] dir : dirs) {
            int r = start[0];
            int c = start[1];

            while (r >= 0 && r < m && c >= 0 && c < n && maze[r][c] != 1) {
                r = r + dir[0];
                c = c + dir[1];
            }

            r = r - dir[0];
            c = c - dir[1];

            if (maze[r][c] != 2) {
                if (dfs(maze, new int[] { r, c }, dest)) {
                    return true;
                }
            }

        }

        return false;
    }
}