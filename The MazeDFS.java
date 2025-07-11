// Time Complexity:
// O(m * n)
// Each cell is visited at most once due to visited marking, and rolling is bounded by the grid size.

// Space Complexity:
// O(m * n) in the worst case due to the recursion stack in DFS and the visited markings on the maze.


public class Solution {
    /**
     * @param maze: the maze
     * @param start: the start
     * @param destination: the destination
     * @return: whether the ball could stop at the destination
     */
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        return dfs(maze, start, destination, m, n);
    }

    private boolean dfs(int[][] maze, int[] curr, int[] dest, int m, int n) {
        if (maze[curr[0]][curr[1]] == 2) {
            return false; // already visited
        }
        if (curr[0] == dest[0] && curr[1] == dest[1]) {
            return true; // reached destination
        }
        maze[curr[0]][curr[1]] = 2; // mark as visited

        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int[] dir : dirs) {
            int r = curr[0];
            int c = curr[1];
            // roll until hitting the wall
            while (r + dir[0] >= 0 && r + dir[0] < m && c + dir[1] >= 0 && c + dir[1] < n
                    && maze[r + dir[0]][c + dir[1]] != 1) {
                r += dir[0];
                c += dir[1];
            }
            if (dfs(maze, new int[]{r, c}, dest, m, n)) {
                return true;
            }
        }
        return false;
    }
}
