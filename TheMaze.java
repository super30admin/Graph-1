import java.util.*;


// Approach: BFS
// TC: O(m.n.(m+n)) where m is number of rows and n is number of columns
// SC: O(m.n)
public class TheMaze {
    int x[] = { -1, 1, 0, 0 };
    int y[] = { 0, 0, 1, -1 };

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        int visited[][] = new int[m][n];
        visited[start[0]][start[1]] = 1;
        while (!q.isEmpty()) {
            int polled[] = q.poll();
            if (polled[0] == destination[0] && polled[1] == destination[1])
                return true;
            for (int k = 0; k < 4; k++) {
                int i = polled[0];
                int j = polled[1];
                while (i >= 0 && i < m && j >= 0 && j < n && maze[i][j] == 0) {
                    i += x[k];
                    j += y[k];
                }
                i -= x[k];
                j -= y[k];
                if (visited[i][j] == 0) {
                    q.add(new int[] { i, j });
                    visited[i][j] = 1;
                }
            }
        }
        return false;
    }
}


// Approach: DFS
// TC: O(m.n.(m+n)) where m is number of rows and n is number of columns
// SC: O(m.n)

class Solution {
    int x[] = { -1, 1, 0, 0 };
    int y[] = { 0, 0, 1, -1 };
    int m, n;

    private boolean dfs(int maze[][], int start[], int destination[], int visited[][]) {
        if (start[0] == destination[0] && start[1] == destination[1])
            return true;
        visited[start[0]][start[1]] = 1;
        for (int k = 0; k < 4; k++) {
            int i = start[0];
            int j = start[1];
            while (i >= 0 && i < m && j >= 0 && j < n && maze[i][j] == 0) {
                i += x[k];
                j += y[k];
            }
            i -= x[k];
            j -= y[k];
            if (visited[i][j] == 0 && dfs(maze, new int[] { i, j }, destination, visited)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        m = maze.length;
        n = maze[0].length;
        return dfs(maze, start, destination, new int[m][n]);
    }
}