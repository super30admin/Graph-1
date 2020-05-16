//Time Complexity: O(m x n)
//Space Complexity: O(m x n)
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] visited = new boolean[m][n];

        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        visited[start[0]][start[1]] = true;

        int[][] dirs = {{0,1}, {0, -1}, {1, 0}, {-1, 0}};
        while(!q.isEmpty()) {
            int[] cur = q.poll();

            if(cur[0] == destination[0]  && cur[1] == destination[1]) {
                return true;
            }
            for(int[] dir: dirs) {
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];

                while(x >=0 && x < m && y >= 0 && y < n && maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];
                }

                if(!visited[x - dir[0]][y - dir[1]]) {
                    q.add(new int[]{x - dir[0], y - dir[1]});
                    visited[x - dir[0]][y - dir[1]] = true;
                }
            }
        }
        return false;

    }
}