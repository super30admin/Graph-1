// Time Complexity:O(m*n);
// Space Complexity:O(m*n);
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        q.offer(start);
        maze[start[0]][start[1]] = 2;
        while (!q.isEmpty()) {
            int[] top = q.poll();
            int r = top[0], c = top[1];
            if (r == destination[0] && c == destination[1]) return true;
            for (int[] dir : dirs) {
                int i = r, j = c;
                while (i >= 0 && j >= 0 && i < m && j < n && maze[i][j] != 1) {
                    i += dir[0];
                    j += dir[1];
                }
                i -= dir[0];
                j -= dir[1];
                if (maze[i][j] == 0) {
                    q.offer(new int[]{i, j});
                    maze[i][j] = 2;
                }
            }
        }
        return false;
    }
}
