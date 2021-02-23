//Time Complexity: o(m*n)
//Space Complexity: o(1) Ignoring recursive stack else o(m*n) worst case
//Expln: perform bfs in the 2 d array until we hit wall or boundary and perfrom bfs again until we find the destination.
class Solution {
    int[][] dirs  = {{0,-1}, {-1, 0}, {1, 0}, {0,1}};
    int m; int n;
    boolean found = false;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze.length == 0 && maze[0].length == 0) return false;
        m = maze.length; n = maze[0].length;
        helper(maze, start, destination);
        return found;
        
    }
    private void helper(int[][]maze, int[] start, int[] destination)
    {
        //base
        if(maze[start[0]][start[1]] == 2) return;
        else if (start[0] == destination[0] && start[1] == destination[1])
        {
            found = true;
            return;
        }
        maze[start[0]][start[1]] = 2;
        //logic
        for(int[] dir: dirs)
        {
            if(!found){
            int i = start[0]; int j = start[1];
            while((i>=0 && j >=0 && i < m && j < n) && maze[i][j] != 1)
            {
                i += dir[0];
                j += dir[1];
            }
            i -= dir[0];
            j -= dir[1];
            helper(maze, new int[]{i , j}, destination);
            }
            else
                break;

        }
    }
}