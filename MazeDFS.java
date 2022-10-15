class Solution {
    //tc-o(m*n)
    //sc-o(m*n)
    int m;
    int n;
    int[][] dirs;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        m = maze.length;
         n = maze[0].length;
        //null check
        if(maze == null || maze.length == 0) return false;
        dirs = new int[][]{{0,-1},{-1,0},{0,1},{1,0}};
        return dfs(maze,start,destination);
    }
    private boolean dfs(int[][]maze, int[] curr, int[] destination)
    {
        //base case
       if(maze[curr[0]][curr[1]] == 2) return false;
       if(curr[0] == destination[0] && curr[1] == destination[1]) return true;

        //logic
        maze[curr[0]][curr[1]] = 2;
        for(int[] dir : dirs)
        {
            int i = dir[0];
            int j = dir[1];
        while(i>=0 && j>=0 && i<m && j<n && maze[i][j] != 1)
        {
            i+= dir[0];
            j+= dir[1];
        }
        i-= dir[0];
        j-= dir[1];

        if(dfs(maze, new int[]{i,j},destination)) return true;

        }
        return false;
    }

}