// DFS
class Solution {
    int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze == null) {
            return false;
        }


        int m, n;
        m = maze.length;
        n = maze[0].length;

        return dfs(maze, start, destination, m, n);

    }
    private boolean dfs(int[][] maze, int[] start, int[] destination, int m, int n) {
        if(start[0] == destination[0] && start[1] == destination[1]) {
            return true;
        }

        maze[start[0]][start[1]] = 2;
        for(int[] d : dirs) {
            int i = start[0];
            int j = start[1];
            while(i < m && j < n && i >= 0 && j >= 0 && maze[i][j] != 1) {
                i += d[0];
                j += d[1];
            }
            i -= d[0];
            j -= d[1];

            if(maze[i][j] != 2 && dfs(maze, new int[] {i, j}, destination, m, n)) {
                return true;
            }

        }
        return false;
    }
}
