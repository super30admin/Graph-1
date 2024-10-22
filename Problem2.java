// Time Complexity : O(nxm) 
// Space Complexity : O(mxn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : used the same logic Jaspinder explained in the class.

class Solution {
    boolean flag;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(start[0] == destination[0] && start[1]== destination[1]) return true;
        int m = maze.length;
        int n = maze[0].length;
        int [][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        dfs(maze,start,destination,dirs);
        return flag;
    }

    private void dfs(int[][] maze, int[] start, int[] destination, int [][] dirs){
        //base
        //already visited
        if(maze[start[0]][start[1]] == 2) return;
        if(start[0] == destination[0] && start[1]== destination[1]){
            flag = true;
            return;
        } 

        //logic
        //mark as visited
        maze[start[0]][start[1]] = 2;
        for(int dir []: dirs){
            int r = start[0] + dir[0];
            int c = start[1] + dir[1];
            while(r >=0 && r< maze.length && c >=0 && c < maze[0].length && maze[r][c] != 1){
                r += dir[0];
                c += dir[1];
            }
            //go one step back
            r -= dir[0];
            c -= dir[1];
            if(!flag){
                dfs(maze,new int []{r,c},destination, dirs);
            }
        }
    }
}