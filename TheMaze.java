
// TC : O(m*n *(m+n))
// SC : O(m⋅n)

package S30_Codes.Graph_1;

class TheMaze {
    int m, n;
    boolean[][] visited;
    int[][] directions = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
    };

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        m = maze.length;
        n = maze[0].length;
        visited = new boolean[m][n];
        return dfs(maze, start, destination);
    }

    private boolean dfs(int[][] maze, int[] start, int[] destination){
        // base case
        if (visited[start[0]][start[1]])
            return false;

        if(start[0] == destination[0] && start[1] == destination[1])
            return true;

        visited[start[0]][start[1]] = true;
        for(int[] dir : directions){
            int[] nextStop = getStop(start[0], start[1], dir, maze);
            if(dfs(maze, nextStop, destination))
                return true;
        }
        return false;
    }

    private int[] getStop(int row, int col, int[] dir, int[][] maze){
        while(row < m && col < n && row >= 0 && col >=0 && maze[row][col] == 0){
            row = row+dir[0];
            col = col+dir[1];
        }
        return new int[] {row-dir[0], col-dir[1]};
    }
}