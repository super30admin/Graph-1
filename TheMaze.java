//  Time Complexity: O(m*n)
//  Space Complexity: O(m*n) because of recursive stack

public class TheMaze {
    int[][] dirs;

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {

        if (start[0] == destination[0] && start[1] == destination[1]) {
            return true;
        }

        dirs = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        return dfs(maze, start, destination);
    }

    private boolean dfs(int[][] maze, int[] start, int[] destination) {
        //  base
        if (start[0] == destination[0] && start[1] == destination[1]) {
            return true;
        }

        if (maze[start[0]][start[1]] == 2) {
            return false;
        }

        //  logic
        //  mark current location as visited
        maze[start[0]][start[1]] = 2;

        for (int[] dir : dirs) {
            int x = start[0];
            int y = start[1];

            while (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] != 1) {
                x += dir[0];
                y += dir[1];
            }

            //  take a step back as we have landed at a 1
            x -= dir[0];
            y -= dir[1];

            if (dfs(maze, new int[]{x, y}, destination)) {
                return true;
            }
        }

        return false;
    }
}
