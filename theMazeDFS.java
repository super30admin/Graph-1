//sc and tc: o(m * n)
class Solution {
    int m, n;
    int dirs[][];
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze == null || maze.length == 0) return false;

        //Depth-First-search
         m = maze.length;
         n = maze[0].length;
         dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // Up Down Left Right

        return dfs(maze, start, destination);
    }
    private boolean dfs(int[][] maze, int[] start, int[] destination) {
        //base
        if(start[0] == destination[0] && start[1] == destination[1]) {
            return true;
        }
        //logic
        maze[start[0]][start[1]] = 2;
        for(int[] dir : dirs) {
            int r = start[0];
            int c = start[1];
            while(r >= 0 && r < m && c >= 0 && c < n && maze[r][c] != 1) {
                r = r + dir[0];
                c = c + dir[1];
            }
            r = r - dir[0];
            c = c - dir[1];
            if(maze[r][c] != 2 && dfs(maze, new int[] {r, c}, destination)) {
                return true;
            }
        }
        return false;
    }
}