// Time Complexity : O(n*m) n is rows and m is columns of given maze
// Space Complexity : O(1) COnstant Space (Excluding Recursive Stack)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// DFS is the approach to solve the problem.
// start the recursion witht he given start index of the maze. Create a 2D directions array to traverse all sides of the given start index.
// pick a direction and reach the end till you hit the wall (i.e., maze[r][c] == 1) or already explored destination (maze[r][c] == 2) and compare that with the destination given.
// if that is not the destination, replace it with some other number like 2 (Indicating that we explored this end point).
// continue with the other direction now and repeat the recursion.
// if you find the destination return true, else false.

class Solution {
    int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze == null || maze.length == 0) {
            return false;
        }

        return recurr(maze, start, destination);

    }

    public boolean recurr(int[][] maze, int[] start, int[] destination){
        int sRow = start[0];
        int sCol = start[1];
        if(sRow == destination[0] && sCol == destination[1]) {
            return true;
        }

        if(maze[sRow][sCol] == 2) {
            return false;
        }

        maze[sRow][sCol] = 2;

        for(int[] dir: dirs) {
            int r = dir[0] + sRow;
            int c = dir[1] + sCol;

            while(r>=0 && r<maze.length && c>=0 && c<maze[0].length && maze[r][c]!=1) {
                r = r + dir[0];
                c = c + dir[1];
            }
            if(recurr(maze, new int[]{r-dir[0],c-dir[1]}, destination)){
                return true;
            }
        }

        return false;
    }
}