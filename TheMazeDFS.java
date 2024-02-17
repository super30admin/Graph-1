/*
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(m*n)
* 
* Space Complexity: O(m*n)
* 
*/
public class TheMazeDFS {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;

        int n = maze[0].length;

        if (start[0] == destination[0] && start[1] == destination[1]) {
            return true;
        }

        return dfs(maze, destination, start[0], start[1], m, n);
    }

    int[][] dirs = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    private boolean dfs(int[][] maze, int[] destination, int row, int col, int m, int n) {
        if (row < 0 || row == m || col < 0 || col == n || maze[row][col] == 2) {
            return false;
        }

        if (row == destination[0] && col == destination[1]) {
            return true;
        }

        maze[row][col] = 2;

        for (int[] dir : dirs) {
            int nr = row + dir[0];
            int nc = col + dir[1];

            while (nr >= 0 && nr < m && nc >= 0 && nc < n && maze[nr][nc] != 1) {
                nr += dir[0];
                nc += dir[1];
            }

            nr -= dir[0];
            nc -= dir[1];

            if (dfs(maze, destination, nr, nc, m, n))
                return true;
        }

        return false;
    }
}
