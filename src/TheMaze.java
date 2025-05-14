public class TheMaze {
    int dirs[][];
    int m, n;

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        this.dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};//dirs holds 4 directions: up, down, right, left
        this.m = maze.length; //
        this.n = maze[0].length;

        return dfs(maze, start[0], start[1], destination);

    }


    private boolean dfs(int[][] maze, int i, int j, int[] destination) {

        //If you already visited this cell (marked -1), return false.
        if (maze[i][j] == -1) return false;

        //If the current cell is the destination, return true
        if (i == destination[0] && j == destination[1]) return true;

        //Mark the cell as visited
        maze[i][j] = -1;

        //Roll the ball in all 4 directions
        for (int[] dir : dirs) {
            int r = i + dir[0];
            int c = j + dir[1];

            while (r >= 0 && c >= 0 && r < m && c < n && maze[r][c] != 1) {
                r += dir[0];
                c += dir[1];
            }

            //step back one position
            r -= dir[0];
            c -= dir[1];

            if (dfs(maze, r, c, destination)) return true;
        }

        return false;

    }

}
