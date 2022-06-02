import java.util.LinkedList;
import java.util.Queue;

public class Problem2 {

    // DFS solution
    // TC : O(m*n)
    // SC : O(m*n)
    int m, n;
    int[][] dirs;

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze == null) return false;

        m = maze.length;
        n = maze[0].length;

        dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        return dfs(maze, start, destination);
    }

    private boolean dfs(int[][] maze, int[] start, int[] destination) {
        //base case
        if (start[0] == destination[0] && start[1] == destination[1]) {
            return true;
        }

        //logic
        maze[start[0]][start[1]] = 2;
        for (int[] dir : dirs) {
            int r = start[0];
            int c = start[1];
            while (r >= 0 && r < m && c >= 0 && c < n && maze[r][c] != 1) {
                r = r + dir[0];
                c = c + dir[1];
            }
            r = r - dir[0];
            c = c - dir[1];
            if (maze[r][c] != 2 && dfs(maze, new int[]{r, c}, destination)) return true;
        }
        return false;
    }

    // BFS solution
    // TC : O(m*n)
    // SC : O(m*n)
    public boolean hasPath1(int[][] maze, int[] start, int[] destination) {
        if (maze == null) return false;

        int m = maze.length;
        int n = maze[0].length;

        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> que = new LinkedList<>();
        que.add(start);

        while (!que.isEmpty()) {
            int[] curr = que.poll();
            if (destination[0] == curr[0] && destination[1] == curr[1]) {
                return true;
            }
            maze[curr[0]][curr[1]] = 2;
            for (int[] dir : dirs) {
                int r = curr[0];
                int c = curr[1];

                while (r >= 0 && r < m && c >= 0 && c < n && maze[r][c] != 1) {
                    r = r + dir[0];
                    c = c + dir[1];
                }
                r = r - dir[0];
                c = c - dir[1];
                if (maze[r][c] != 2) {
                    que.add(new int[]{r, c});
                }
            }
        }
        return false;
    }
}
