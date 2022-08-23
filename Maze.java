import java.util.LinkedList;
import java.util.Queue;

//Time Complexity: O(m*n)+ max(m,n)-for the while loop
//Space Complexity: O(m*n)

class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0)
            return false;

        // BFS solution
        int m = maze.length;
        int n = maze[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        q.add(new int[] { start[0], start[1] }); // adding the indices of the starting cell.
        maze[start[0]][start[1]] = 2; // marking the starting cell as visited.

        // BFS
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            for (int[] dir : dirs) {
                int i = curr[0];
                int j = curr[1];
                // while loop to make sure the ball travels until it reaches a cell with 1 or
                // boundary conditions.
                while (i >= 0 && i < m && j >= 0 && j < n && maze[i][j] != 1) {
                    i = i + dir[0];
                    j = j + dir[1];
                }
                // at this point, we reach a cell having 1, therefore we undo the last action to
                // reach a 0 cell before the 1 cell.
                i = i - dir[0];
                j = j - dir[1];
                if (maze[i][j] == 0) {
                    if (i == destination[0] && j == destination[1]) {
                        return true;
                    }

                    maze[i][j] = 2; // if not destinantion, marking the cell as visited
                    q.add(new int[] { i, j }); // and adding the cell to the queue
                }
            }
        }
        return false;

    }
}