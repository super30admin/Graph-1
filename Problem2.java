// Time Complexity : O(k mn) where k is the number of 1s in the matrix and m,n are the dimenstions of the matrix.
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/**
 * Using level order traversal to start navigating the maze from starting position in all directions.
 * Keep going in one direction till either we see 1 or the end of the maze. Go 1 step back since that will be the ball's stopping point.
 * Mark the stopping point with 2 so we know that it has been visited and add the current position to queue for further maze traversal.
 * If we find the ball's stopping point to be destination at any point, we return true.
 * We return false at the end since we traversed through all possible stopping points and the ball never stopped at the destination.
 */
class BFSSolution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;

        if (m == 0 || n == 0) {
            return false;
        }

        if (start[0] == destination[0] && start[1] == destination[1])
            return true;

        // Using queue for level order traversal
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        // marking it with 2 to consider it as visited
        maze[start[0]][start[1]] = 2;

        int[][] dirs = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for (int[] dir : dirs) {
                // move one step to get the next element in current directionb
                int r = curr[0] + dir[0];
                int c = curr[1] + dir[1];

                // keep going in this direction till end of maze or 1 is received
                while (r >= 0 && r < m && c >= 0 && c < n && maze[r][c] != 1) {
                    r += dir[0];
                    c += dir[1];
                }

                // go one step back since this will be the stopping point
                r -= dir[0];
                c -= dir[1];

                // found the destination as stopping point
                if (r == destination[0] && c == destination[1])
                    return true;

                // if this position was never a stopping point for the ball, add it to queue and mark it with visited
                if (maze[r][c] != 2) {
                    maze[r][c] = 2;
                    q.add(new int[]{r, c});
                }
            }
        }

        return false;
    }
}


class DFSSolution {
    int m;
    int n;
    int[][] dirs = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        this.m = maze.length;
        this.n = maze[0].length;

        if (m == 0 || n == 0) {
            return false;
        }

        if (start[0] == destination[0] && start[1] == destination[1])
            return true;

        return dfs(maze, start[0], start[1], destination);
    }

    private boolean dfs(int[][] maze, int i, int j, int[] destination) {
        // stopped at the destination
        if (i == destination[0] && j == destination[1])
            return true;

        // already visited this node and it wasn't the destination
        if (maze[i][j] == 2)
            return false;

        // marking it as visited
        maze[i][j] = 2;
        for (int[] dir : dirs) {
            // starting from the neighbor of the current element
            int r = i + dir[0];
            int c = j + dir[1];

            // keep going in this direction till end of maze or 1 is received
            while (r >= 0 && r < m && c >= 0 && c < n && maze[r][c] != 1) {
                r += dir[0];
                c += dir[1];
            }

            // go one step back since this will be the stopping point
            r -= dir[0];
            c -= dir[1];

            // call the function recursively and bubble the match up
            if (dfs(maze, r, c, destination))
                return true;
        }

        // no match found
        return false;
    }
}