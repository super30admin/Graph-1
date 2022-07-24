import java.util.*;

class Main {

    // approch 1 BFS
    public static boolean hasPath1(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        // direction array
        int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        // queue for BFS
        Queue<int[]> q = new LinkedList<>();
        // add start position in q
        q.add(start);
        // make start node visited
        maze[start[0]][start[1]] = 2;
        // BFS traversal
        while (!q.isEmpty()) {
            // get current position
            int[] curr = q.poll();
            // go further in direction until we hit 1 or bound of the matrix
            for (int[] dir : dirs) {
                int i = curr[0];
                int j = curr[1];
                while (i >= 0 && j >= 0 && i < m && j < n && maze[i][j] != 1) {
                    i += dir[0];
                    j += dir[1];
                }
                // go back one position
                i -= dir[0];
                j -= dir[1];
                if (i == destination[0] && j == destination[1]) {
                    return true;
                }
                // here check is this a position we already been there or not and add new
                // position in the queue

                if (maze[i][j] != 2) {
                    q.add(new int[] { i, j });
                }
                // make position visited
                maze[i][j] = 2;
            }
        }
        return false;
    }

    private static int[][] dirs;

    // approch 2 using DFS
    public static boolean hasPath2(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        // dfs traversal
        return helper(maze, start[0], start[1], destination, m, n);
    }

    public static boolean helper(int[][] maze, int r, int c, int[] destination, int m, int n) {
        // base case
        if (r == destination[0] && c == destination[1])
            return true;

        // main logic
        // mark it visited
        maze[r][c] = 2;
        // for loop based recursion in all the direction at partcular position
        for (int[] dir : dirs) {
            int i = r;
            int j = c;
            while (i >= 0 && j >= 0 && i < m && j < n && maze[i][j] != 1) {
                i += dir[0];
                j += dir[1];
            }
            // go back one position
            i -= dir[0];
            j -= dir[1];
            // if we havent visited this position and it matched with destination return
            // true;
            if (maze[i][j] == 0 && helper(maze, i, j, destination, m, n))
                return true;
        }
        // we have not found our position we return false;
        return false;

    }

    public static void main(String[] args) {
        int[][] maze = new int[][] {
                { 0, 0, 1, 0, 0 },
                { 0, 0, 0, 0, 0 },
                { 0, 0, 0, 1, 0 },
                { 1, 1, 0, 1, 1 },
                { 0, 0, 0, 0, 0 } };
        int[] start = new int[] { 0, 4 }, destination = new int[] { 4, 4 };

        System.out.println(hasPath1(maze, start, destination));
        maze = new int[][] {
                { 0, 0, 1, 0, 0 },
                { 0, 0, 0, 0, 0 },
                { 0, 0, 0, 1, 0 },
                { 1, 1, 0, 1, 1 },
                { 0, 0, 0, 0, 0 } };
        System.out.println(hasPath2(maze, start, destination));

    }
}