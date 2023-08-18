// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes



class Solution {

    int[][] offset = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int DOWN = 0;
    int UP = 1;
    int RIGHT = 2;
    int LEFT = 3;

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        boolean[][][] visited = new boolean[m][n][4];

        // Let's kick the ball in all 4 directions
        return 
        DFS(start[0], start[1], destination[0], destination[1], visited, maze, DOWN) ||
        DFS(start[0], start[1], destination[0], destination[1], visited, maze, UP) ||
        DFS(start[0], start[1], destination[0], destination[1], visited, maze, RIGHT) ||
        DFS(start[0], start[1], destination[0], destination[1], visited, maze, LEFT);
    }

    private boolean DFS(int x, int y, int targetX, int targetY, boolean[][][] visited, int[][] maze, int direction) {
        int m = maze.length;
        int n = maze[0].length;

        visited[x][y][direction] = true;
        int nextX = x + offset[direction][0];
        int nextY = y + offset[direction][1];

        // The next cell in the current direction is not a wall.
        // so.. keep rolling
        if (!isBallHittingAWall(nextX, nextY, maze)) {
            return DFS(nextX, nextY, targetX, targetY, visited, maze, direction);
        }

        // The next cell is part of a wall.. so can't go further in this direction.
        // check if current cell is the destination
        if (x == targetX && y == targetY) {
            return true;
        }

        // Try the other 3 directions
        for (int newDirection = direction+1; newDirection < direction+4; newDirection++) {
            nextX = x + offset[newDirection % 4][0];
            nextY = y + offset[newDirection % 4][1];
            // Roll the ball in a new direction only if
            // there is no wall and we haven't visited the cell in the new direction.
            if (!isBallHittingAWall(nextX, nextY, maze) && !visited[nextX][nextY][newDirection % 4]) {
                if (DFS(nextX, nextY, targetX, targetY, visited, maze, newDirection % 4)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isBallHittingAWall(int x, int y, int[][] maze) {
        int m = maze.length;
        int n = maze[0].length;

        if (x < 0 || x == m || y < 0 || y == n || maze[x][y] == 1) {
            return true;
        }
        return false;
    }

}

