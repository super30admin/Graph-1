
import java.util.LinkedList;
import java.util.Queue;

// Premium problem
// https://leetcode.ca/2017-04-03-490-The-Maze/
// Because of connected components think about BFS and DFS.
// For both methods, TC: O(m*n) * (m + n) SC: O(m*n)
class Solution {

    int m;
    int n;

    int dirs[][] = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    // BFS

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0) {
            return false;
        }

        m = maze.length;
        n = maze[0].length;

        Queue<int[]> q = new LinkedList<>();

        q.add(start);

        while (!q.isEmpty()) {
            int cur[] = q.poll();

            if (cur[0] == destination[0] && cur[1] == destination[1]) {
                return true;
            }
 
            for (int[] dir : dirs) {
                int nr = cur[0];
                int nc = cur[1];

                while (nr >= 0 && nr < m && nc >= 0 && nc < n && maze[nr][nc] != 1) {
                    nr = nr + dir[0];
                    nc = nc + dir[1];
                }

                nr = nr - dir[0];
                nc = nc - dir[1];



                if (maze[nr][nc] != 2) {
                    q.add(new int[] {nr, nc});
                    maze[nr][nc] = 2;
                }


            }

        }

        return false;
    }



    // DFS
    public boolean hasPath1(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0) {
            return false;
        }

        m = maze.length;
        n = maze[0].length;

        return dfs(maze, start, destination);
    }

    private boolean dfs(int[][] maze, int[] start, int[] destination) {
        if (start[0] == destination[0] && start[1] == destination[1]) {
                return true;
        }


        maze[start[0]][start[1]] = 2;
        for (int[] dir : dirs) {
            int nr = start[0];
            int nc = start[1];

            while (nr >= 0 && nr < m && nc >= 0 && nc < n && maze[nr][nc] != 1) {
                nr = nr + dir[0];
                nc = nc + dir[1];
            }

            nr = nr - dir[0];
            nc = nc - dir[1];

            if(maze[nr][nc] != 2 && dfs(maze, new int[] {nr, nc}, destination)) {
                return true;
            }

        }

        return false;
    }


}