// Time Complexity : O(m*n)  -> (m*n)(m+n)  -> m*n goes high then m+n goes down and viceversa.
// So asymptotically its m*n
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes

public class TheMazeUsingDFS {
    int m;
    int n ;
    int[][] dirs;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        m = maze.length;
        n = maze[0].length;
        dirs = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
        return dfs(maze,start[0],start[1],destination);
    }

    public boolean dfs(int[][] maze, int i, int j, int[] destination)
    {
        if(i == destination[0] &&  j == destination[1]) return true;
        if(maze[i][j] == 2)return false;
        maze[i][j] = 2;
        //logic
        for(int[] dir: dirs)
        {
            int r = i + dir[0];
            int c = j + dir[1];

            while(r>=0 && r<m && c>=0 && c<n && maze[r][c] != 1)
            {
                r = r + dir[0];
                c = c + dir[1];
            }
            r = r - dir[0];
            c = c - dir[1];

            if(dfs(maze, r, c, destination)) return true;
        }

        return false;
    }
}
