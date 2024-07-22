// Time Complexity : O((m*n)(m+n))
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Using BFS

// Your code here along with comments explaining your approach

// 1. Initialize a queue with the start position, mark it as visited in the maze, and define possible movement directions.
//2. Use BFS to explore each direction from the current position, rolling until hitting a wall, and enqueue the stop position if it hasn't been visited.
//3. If the destination is reached during exploration, return true; if the queue is exhausted without finding the destination, return false.

class Solution {

    public boolean check(int i, int j, int m, int n) {
        if(i >= 0 && i < m && j >= 0 && j < n)
            return true;
        return false;
    }
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {

        if(maze == null || maze.length == 0)
            return false;


        int[][] dirs = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

        Queue<int []> q = new LinkedList<>();

        q.add(start);
        maze[start[0]][start[1]] = -1;

        int m = maze.length;
        int n = maze[0].length;

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            if(curr[0] == destination[0] && curr[1] == destination[1])
                return true;

            for(int[] dir : dirs) {
                int nr = curr[0] + dir[0];
                int nc = curr[1] + dir[1];

                while(check(nr, nc, m, n) && maze[nr][nc] != 1 ) {
                    nr = nr + dir[0];
                    nc = nc + dir[1];
                }

                nr = nr - dir[0];
                nc = nc - dir[1];
                if(maze[nr][nc] == 0) {
                    q.add(new int[]{nr,nc});
                    maze[nr][nc] = -1;
                }
            }

        }

        return false;
    }
}