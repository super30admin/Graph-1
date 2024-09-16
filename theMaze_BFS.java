// Time Complexity : O(m*n) where m and n are the dimensions of the maze
// Space Complexity : O(m*n) where m and n are the dimensions of the maze
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class theMaze_BFS {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0) return false;
        int m = maze.length;
        int n = maze[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        maze[start[0]][start[1]] = 2; // mark start point as visited
        int[][] dirs = {{0,1}, {1,0}, {-1,0}, {0,-1}};
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int i = curr[0];
            int j = curr[1];
            if (i == destination[0] && j == destination[1]) return true;
            for (int[] dir : dirs) {
                int r = i;
                int c = j;
                while (r >= 0 && r < m && c >= 0 && c < n && maze[r][c] != 1) {
                    r += dir[0];
                    c += dir[1];
                }
                r -= dir[0];
                c -= dir[1];  
                if (maze[r][c] != 2) {
                    q.add(new int[] {r, c});
                    maze[r][c] = 2;
                }
            }
        }
        return false;
    }
}