// Time Complexity :
//      O(m x n) where m is the number of rows and n is number of columns in maze
//
// Space Complexity :
//      O(1) as we are using only recursive stack space
//
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//dfs solution

class Solution {
    //public members
    //create a directions array called as dirs which shall take care of left, right, up, down
    int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        //edge case
        if(maze == null || maze.length == 0) return false;
        //create a function dfs to perform depth first search in the given maze
        return dfs(maze,start,destination);
    }
    private boolean dfs(int[][] maze, int[] start, int[] destination)
    {
        //terminating condition
        if(start[0] == destination[0] && start[1] == destination[1]) return true;
        //logic
        maze[start[0]][start[1]] = -1; //make the visited cell as -1
        for(int[] dir:dirs)
        {
            int row = start[0], col = start[1];
            while(row>=0 && row < maze.length && col>=0 && col < maze[0].length && (maze[row][col]==0 || maze[row][col]==-1))
            {
                row = row + dir[0];
                col = col + dir[1];
            }
            //now we shall again go back in row and column and check for other possible paths
            row = row - dir[0];
            col = col - dir[1];
            if(maze[row][col] != -1 && dfs(maze,new int[]{row,col}, destination))
                return true;
        }
            return false;
    }
}