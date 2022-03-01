// Time Complexity : O(mn)
// Space Complexity : O(mn)

class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0)
            return false;
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        int m = maze.length;
        int n = maze[0].length;
        q.add(start);
        maze[start[0]][start[1]] = 2;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            for (int[] dir : dirs) {
                int i = curr[0];
                int j = curr[1];
                while (i < m && j < n && i >= 0 && j >= 0 && maze[i][j] != 1) {
                    i = i + dir[0];
                    j = j + dir[1];
                }
                i = i - dir[0];
                j = j - dir[1];
                if (i == destination[0] && j == destination[1]) {
                    return true;
                }
                if (maze[i][j] == 0) {
                    maze[i][j] = 2;
                    q.add(new int[] { i, j });
                }
            }
        }
        return false;
    }
}
