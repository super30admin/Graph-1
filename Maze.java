// TC -> O(m*n)
// SC -> O(m*n)

public class Maze {
    int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    int m = 0;
    int n = 0;
    boolean flag;

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {

        if (maze == null || maze.length == 0)
            return false;

        m = maze.length;
        n = maze[0].length;
        dfs(maze, start, destination);
        return flag;

    }

    public void dfs(int[][] maze, int[] start, int[] destination) {
        // base
        if (maze[start[0]][start[1]] == 1) {
            return;
        }
        // logic
        if (start[0] == destination[0] && start[1] == destination[1]) {
            flag = true;
            return;
        }

        // action
        maze[start[0]][start[1]] = 2;
        for (int[] d : dirs) {
            int r = start[0];
            int c = start[1];

            int x = d[0];
            int y = d[1];

            while (r >= 0 && r < m && c >= 0 && c < n && maze[r][c] != 1) {
                r += x;
                c += y;

            }
            // bactrack to valid position (1 step back)
            r -= x;
            c -= y;

            if (r == destination[0] && c == destination[1])
                flag = true;

            if (maze[r][c] != 2) {
                dfs(maze, new int[] { r, c }, destination);

            }

        }
    }
}
