class Solution {
    boolean foundPath;
    int[][] dirs;
    int m;
    int n;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        foundPath = false;
        dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        m = maze.length;
        n = maze[0].length;
        dfs(maze, start, destination);
        return foundPath;
    }
    public void dfs(int[][] maze, int[] position, int[] destination){
        //base
        if(foundPath) return;
        if(position[0] == destination[0] && position[1] == destination[1]){
            foundPath = true;
            return;
        }
        //logic
        if( maze[position[0]][position[1]] == 1) return;
        maze[position[0]][position[1]] = 9;
        for(int[] dir : dirs){
            int nr = position[0];
            int nc = position[1];
            while((nr + dir[0] >= 0 && nr + dir[0] < m && nc + dir[1] >= 0 && nc + dir[1] < n) && maze[nr + dir[0]][nc + dir[1]] != 1){
                nr = nr + dir[0];
                nc = nc + dir[1];
            }
            if(maze[nr][nc] == 0){
                dfs(maze, new int[]{nr, nc}, destination);
            }
        }
        // maze[position[0]][position[1]] = 0;
    }
}
