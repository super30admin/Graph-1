import java.util.LinkedList;
import java.util.Queue;

class TheMaze {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze == null)
            return false;
        if (start[0] == destination[0] && start[1] == destination[1])
            return true;
        int m = maze.length;
        int n = maze[0].length;
        int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        maze[start[0]][start[1]] = 2;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            for (int[] dir : dirs) {
                int i = curr[0];
                int j = curr[1];
                while (i < m && j < n && i >= 0 && j >= 0 && maze[i][j] != 1) {
                    i += dir[0];
                    j += dir[1];
                }
                // one step
                i -= dir[0];
                j -= dir[1];
                if (maze[i][j] != 2) {
                    if (i == destination[0] && j == destination[1])
                        return true;
                    q.add(new int[] { i, j });
                    maze[i][j] = 2;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TheMaze theMaze = new TheMaze();

        // Example input
        int[][] maze = {
                { 0, 0, 1, 0, 0 },
                { 0, 0, 0, 0, 0 },
                { 0, 0, 0, 1, 0 },
                { 1, 1, 0, 1, 1 },
                { 0, 0, 0, 0, 0 }
        };
        int[] start = { 0, 4 };
        int[] destination = { 4, 4 };

        boolean hasPath = theMaze.hasPath(maze, start, destination);
        System.out.println("The path exists: " + hasPath);
    }
}