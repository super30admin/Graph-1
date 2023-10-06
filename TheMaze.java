// tc = O(m*n)(m+n)
//sc = O(m*n)
public class TheMaze {

}

class Solution {
    int m;
    int n;
    int[][] dirs;

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (start[0] == destination[0] && start[1] == destination[1])
            return true;
        m = maze.length;
        n = maze[0].length;
        dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
        return dfs(maze, start, destination);

    }

    private boolean dfs(int[][] maze, int[] start, int[] destination) {
        // base
        if (start[0] == destination[0] && start[1] == destination[1])
            return true;
        if (maze[start[0]][start[1]] == 2)
            return false;

        // logic
        maze[start[0]][start[1]] = 2;
        for (int dir[] : dirs) {
            int i = start[0];
            int j = start[1];
            while (i >= 0 && j >= 0 && i < m && j < n && maze[i][j] != 1) {
                i += dir[0];
                j += dir[1];

            }
            i -= dir[0];
            j -= dir[1];
            if (dfs(maze, new int[] { i, j }, destination))
                return true;

        }
        return false;

    }
}
