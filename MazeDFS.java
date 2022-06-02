public class MazeDFS {

    int[][] dirs;

    // DFS approach
    // TC : O(m * n)
    // SC : O(m * n)
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        dirs = new int[][]{
                {-1,0}, // Up
                {1,0}, // Down
                {0, -1}, // Left
                {0,1}    // Right
        };

        return dfs(maze, start, destination);

    }

    private boolean dfs(int[][] maze, int[] start, int[] destination) {
        // base
        if(maze[start[0]][start[1]] == 2) return false;
        if(start[0] == destination[0] && start[1] == destination[1]) return true;

        //action
        for(int[] dir : dirs) {
            int r = start[0];
            int c = start[1];

            while(r >= 0 && r < maze.length && c >=0 && c < maze[0].length && maze[r][c] != 1) {
                r = r + dir[0];
                c = c + dir[1];
            }
            r = r - dir[0];
            c = c - dir[1];

            if(dfs(maze, new int[]{r,c}, destination)) return true;
        }

        return false;
    }
}
