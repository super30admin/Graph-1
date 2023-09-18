// Time Complexity: O(mn(m+n))
// Space Complexity: O(mn)


class Solution2 {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if( start[0] == destination[0] && start[1] == destination[1] ) {
            return true;
        }
        int m = maze.length;
        int n = maze[0].length;
        int[][] dirs = new int[][]{{-1,0}, {0,-1}, {1,0}, {0,1}};
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        maze[start[0]][start[1]] = -1;
        while( !q.isEmpty() ) {
            int[] cp = q.poll();
            int cr = cp[0];
            int cc = cp[1];
            for(int[] dir: dirs) {
                int i = cr;
                int j = cc;
                while( i >= 0 && i < m && j >= 0 && j < n && maze[i][j] != 1) {
                    i = i + dir[0];
                    j = j + dir[1];
                }
                i = i - dir[0];
                j = j - dir[1];
                if( i == destination[0] && j == destination[1]) {
                    return true;
                }
                if( maze[i][j] != -1) {
                    int[] np = new int[]{i,j};
                    q.add(np);
                    maze[i][j] = -1;
                }
            }
        }
        return false;
    }
}