// Time complexity - O(m*n)
// Space complexity - O(m*n)
// Solved on leetcode - yes
// faced any issues - no
// Solving using DFS DP memorization
class Solution {
    int[][] dirs = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        return dfs(maze, start[0], start[1], destination, visited);
    }

    private boolean dfs(int[][] maze, int i, int j, int[] destination, boolean[][] visited) {
        if (visited[i][j]) return false;
        if (i == destination[0] && j == destination[1]) return true;

        visited[i][j] = true;

        for (int[] dir : dirs) {
            int x = i;
            int y = j;
            
            while (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0) {
                x += dir[0];
                y += dir[1];
            }

            // Step back to the last valid position before hitting the wall
            x -= dir[0];
            y -= dir[1];

            if (dfs(maze, x, y, destination, visited)) return true;
        }

        return false;
    }
}
