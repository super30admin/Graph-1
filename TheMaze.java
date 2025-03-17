/*
 * TC: O(m⋅n⋅(m+n)) - The function dfs visits each node at most once, resulting in O(m⋅n) calls.
 * For each call, we loop through the node's neighbors. To discover neighboring nodes for a node,
 * we check in each direction with a while loop and it would take O(m) steps for vertical directions
 * or O(n) steps for horizontal directions to reach a wall, resulting in O(m+n) operations.
 * O(m⋅n⋅(m+n)) in total for all the nodes.
 * SC: O(m⋅n) - recursive stack
 */
public class TheMaze {
    int m, n;
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        m = maze.length;
        n = maze[0].length;
        return dfs(maze, start, destination);
    }
    private boolean dfs(int[][] maze, int[] start, int[] dest) {
        if(start[0] == dest[0] && start[1] == dest[1]) {
            return true;
        }
        // mark this start point as done
        // so we don't start here again
        maze[start[0]][start[1]] = 2;
        for(int[] dir: dirs) {
            int nr = start[0];
            int nc = start[1];
            // keep rolling until you hit a wall
            while(nr >= 0 && nr < m && nc >= 0 && nc < n && maze[nr][nc] != 1) {
                nr = nr + dir[0];
                nc = nc + dir[1];
            }
            // revert the last step as we crossed the bounds
            nr -= dir[0];
            nc -= dir[1];
            // if we haven't started from here before, start a dfs from here
            if(maze[nr][nc] != 2 && dfs(maze, new int[]{nr, nc}, dest))
                return true;
        }
        return false;
    }
}
