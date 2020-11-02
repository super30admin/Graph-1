class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {

        int[][] directions = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        boolean[][] visited = new boolean[maze.length][maze[0].length];

        return helper(maze, start, destination, directions, visited);

    }

    private boolean helper(int[][] maze, int[] start, int[] destination, int[][] directions, boolean[][] visited) {

        if (visited[start[0]][start[1]])
            return false;

        if (start[0] == destination[0] && start[1] == destination[1])
            return true;

        visited[start[0]][start[1]] = true;
        boolean result = false;
        for (int dirs[] : directions) {
            int x = start[0] + dirs[0];
            int y = start[1] + dirs[1];
            while (0 <= x && x < maze.length && 0 <= y && y < maze[0].length && maze[x][y] == 0) {
                x += dirs[0];
                y += dirs[1];
            }
            result = result || helper(maze, new int[] { x - dirs[0], y - dirs[1] }, destination, directions, visited);
        }

        return result;
    }
}

// Time:O(N^2)
// Space:O(N^2)