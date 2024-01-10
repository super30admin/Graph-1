//TC :  O(m*n) could be less than this depending on the structure of the maze
//SC :  O(m*n) recursive stack height



class Problem2 {

    int [][] dirs = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};;
    int m,n;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        m = maze.length;
        n = maze[0].length;

        return dfs(maze, start, destination);
    }

    private boolean dfs(int[][] maze, int[] curr, int[] destination) {

        //base
        if(curr[0] == destination[0] && curr[1] == destination[1]) return  true;
        if(maze[curr[0]][curr[1]] == 2) return false;

        //logic
        maze[curr[0]][curr[1]] = 2;

        for(int[] dir: dirs) {
            int r = curr[0] + dir[0];
            int c = curr[1] + dir[1];

            while(r>=0 && c>=0 && r<m && c<n && maze[r][c] != 1) {
                r += dir[0];
                c += dir[1];
            }

            r -= dir[0];
            c -= dir[1];

            if(dfs(maze, new int[]{r,c}, destination)) return true;
        }

        return false;
    }
}