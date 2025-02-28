import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// BFS
// TC: O(m *n) + O(m + n) all the traversal will be occuring total length and total height wise in the worst case.
// SC: O(m + n)

// DFS
// TC: O(m *n) + O(m + n) all the traversal will be occuring total length and total height wise in the worst case.
// SC: O(m + n)
public class TheMaze {
    static int[][] dirs;
    static int m, n;

    public static void main(String[] args) {
        System.out.println(hasPathBFS(new int[][] { { 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 1, 0 },
                { 1, 1, 0, 1, 1 }, { 0, 0, 0, 0, 0 } }, new int[] { 0, 4 }, new int[] { 4, 4 })); // true
        System.out.println(hasPathBFS(new int[][] { { 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 1, 0 },
                { 1, 1, 0, 1, 1 }, { 0, 0, 0, 0, 0 } }, new int[] { 0, 4 }, new int[] { 3, 2 })); // false

        System.out.println(hasPathDFS(new int[][] { { 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 1, 0 },
                { 1, 1, 0, 1, 1 }, { 0, 0, 0, 0, 0 } }, new int[] { 0, 4 }, new int[] { 4, 4 })); // true
        System.out.println(hasPathDFS(new int[][] { { 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 1, 0 },
                { 1, 1, 0, 1, 1 }, { 0, 0, 0, 0, 0 } }, new int[] { 0, 4 }, new int[] { 3, 2 })); // false
    }

    public static boolean hasPathBFS(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0)
            return false;
        m = maze.length;
        n = maze[0].length;
        dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } }; // U D L R
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { start[0], start[1] });
        maze[start[0]][start[1]] = 2;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            if (Arrays.equals(destination, curr))
                return true;
            for (int[] dir : dirs) {
                int nr = curr[0];
                int nc = curr[1];
                while (nr >= 0 && nr < m && nc >= 0 && nc < n && maze[nr][nc] != 1) {
                    nr += dir[0];
                    nc += dir[1];
                }
                nr -= dir[0];
                nc -= dir[1];
                if (maze[nr][nc] == 0) {
                    q.offer(new int[] { nr, nc });
                    maze[nr][nc] = 2;
                }
            }
        }
        return false;
    }

    public static boolean hasPathDFS(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0)
            return false;
        m = maze.length;
        n = maze[0].length;
        dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } }; // U D L R
        return dfs(maze, start, destination);
    }

    private static boolean dfs(int[][] maze, int[] start, int[] destination) {
        // base
        if (Arrays.equals(destination, start))
            return true;
        // logic
        maze[start[0]][start[1]] = 2;
        for (int[] dir : dirs) {
            int nr = start[0];
            int nc = start[1];
            while (nr >= 0 && nr < m && nc >= 0 && nc < n && maze[nr][nc] != 1) {
                nr += dir[0];
                nc += dir[1];
            }
            nr -= dir[0];
            nc -= dir[1];
            if (maze[nr][nc] != 2) {
                if (dfs(maze, new int[] { nr, nc }, destination))
                    return true;
            }
        }
        return false;
    }
}
