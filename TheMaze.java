
/*BFS approach
add start to queue. 
go to while loop  until q is not emppty

 * 1. Ball stops only when found wall - run a while loop in all four directions
 * 2. when found a valid position, and which not amrked as 2 (visited as well) - check if that's destination!
 * 3. if not, just add it to the queue, 
 * repeat polling from q, raversing in 4 dir
 * at last we never found anything , we return false;
 * else we would have find it before adding to the Queue.
 * 
 * TC: O(mn) + O(m+n) ~ O(mn)
 * SC: O(mn)
 */

public class Solution {

    public boolean findDestination(int[][] maze, int[] start, int[] destiation) {
        if (maze == null || maze.length == 0)
            return false;

        int m = maze.length;
        int n = maze[0].length;
        int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // T D L R

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { start[0], start[1] }); // we added the start index;

        maze[start[0]][start[1]] = -1; // mark as visited.

        // start BFS
        while (!q.isEmpty()) {
            int[] curr = q.poll();

            int r = curr[0];
            int c = curr[1];

            for (int[] dir : dirs) {
                int i = r;
                int j = c;

                while (i >= 0 && i < m && j >= 0 && j < n && maze[i][j] != 1) {
                    i = i + dir[0];
                    j = j + dir[1];
                }
                // we come here when we reach at the last pooint in that direction, and at the
                // wall may be
                // so deduct the dir[0] and dir[1] to get to the position before wall/
                i = i - dir[0];
                j = j - dir[1];

                // check if those are the destination
                if (i == destination[0] && j == destination[1]) {
                    return true;
                }
                maze[i][j] = -1;
                q.add(new int[] { i, j });
            }
        }
        return false;
    }
}

// approach -2
// DFS
// TC - we touch mostly all locations, and so we says , it's O(m*n)
// sc - O(m*n) - recursive stack space

public class Solution {
    int i, j, m, n;

    public boolean findDestination(int[][] maze, int[] start, int[] destiation) {
        if (maze == null || maze.length == 0)
            return false;
        if (start[0] >= m || start[1] >= n || start[0] < 0 || start[1] < 0)
            return false;
        if (destiation[0] >= m || destiation[1] >= n || destiation[0] < 0 || destiation[1] < 0)
            return false;

        m = maze.length;
        n = maze[0].length;
        int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // T D L R
        i = destination[0];
        j = destination[1];

        return helper(maze, start[0], start[1]);
    }

    private boolean helper(int[][] maze, int r, int c) {
        // base case
        if (r == i && c == j)
            return true;

        // logic
        maze[r][c] = -1;

        for (int[] dir : dirs) {
            int p = r + dir[0];
            int q = c + dir[1];
            while (p >= 0 && p < m && q >= 0 && q < n && maze[p][q] != 1) {
                p = p + dir[0];
                q = q + dir[1];
            }
            // return helper(maze, p - dir[0], q - dir[1]);
            if (maze[p - dir[0]][q - dir[1]] != 1 && helper(maze, p - dir[0], q - dir[1])) {
                return true;
            }
        }
    }
}