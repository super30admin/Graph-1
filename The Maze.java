public class TheMaze {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        boolean[][] visited = new boolean[m][n];

        return dfs(maze, start[0], start[1], destination, visited);
    }

    private boolean dfs(int[][] maze, int row, int col, int[] dest, boolean[][] visited) {
        if (visited[row][col]) return false;
        if (row == dest[0] && col == dest[1]) return true;

        visited[row][col] = true;

        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};

        for (int[] dir : directions) {
            int r = row, c = col;

            // Move in current direction until hitting a wall (0 = empty, 1 = wall)
            while (r + dir[0] >= 0 && r + dir[0] < maze.length &&
                   c + dir[1] >= 0 && c + dir[1] < maze[0].length &&
                   maze[r + dir[0]][c + dir[1]] == 0) {
                r += dir[0];
                c += dir[1];
            }

            // Recurse from the stop position
            if (dfs(maze, r, c, dest, visited)) return true;
        }

        return false;
    }
}

/*
Time Complexity: O(m * n)
- We may visit each cell at most once

Space Complexity: O(m * n)
- visited[][] array + recursive stack
- In worst case, recursion depth can be O(m * n)
*/
