// Time Complexity : O(nm)
// Space Complexity :O(nm)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/*
Approach
we are suing dfs to find the destination, 
add the start index to queue and make it a visted 
then start the loop on queue until empty
in the loop we take one ele out from queue
and check in all dir until a hurdle is found or
when we take a set back check if its the desstination or not if yes return true
else if its not marked visited add it to queue, if queue is empty and destination not found return false
*/
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0)
            return false;
        if (start[0] == destination[0] && start[1] == destination[1])
            return true;
        int m = maze.length;
        int n = maze[0].length;
        int[][] dirs = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        maze[start[0]][start[1]] = 2;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] dir : dirs) {
                int r = cur[0];
                int c = cur[1];
                while (r >= 0 && c >= 0 && r < m && c < n && maze[r][c] != 1) {
                    r += dir[0];
                    c += dir[1];
                }
                r -= dir[0];
                c -= dir[1];
                if (r == destination[0] && c == destination[1])
                    return true;
                if (maze[r][c] != 2) {
                    q.add(new int[] { r, c });
                    maze[r][c] = 2;
                }
            }
        }
        return false;
    }
}