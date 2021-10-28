class Solution {

    // TC:O(m*n) SC:O(m*n)
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        return dfs(start[0], start[1], maze, destination, visited);
    }

    int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    private boolean dfs(int i, int j, int[][] maze, int[] dest, boolean[][] visited) {

        if (visited[i][j])
            return false;
        if (i == dest[0] && j == dest[1])
            return true;

        visited[i][j] = true;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
                x += dir[0];
                y += dir[1];
            }
            if (dfs(x - dir[0], y - dir[1], maze, dest, visited))
                return true;
        }

        return false;
    }
}