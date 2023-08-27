// Time Complexity :O(mn)
// Space Complexity :O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

class Solution {
    boolean flag;
    int[][] dirs = new int[][]{{0,1} , {0,-1}, {1,0}, {-1,0}};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        //Recursive function
        dfs(maze, start, destination);
        return flag;
    }

    private void dfs(int[][] maze, int[] start, int[] destination){
        if(start[0] == destination[0] && start[1] == destination[1]){
            flag = true;
            return;
        } 


        maze[start[0]][start[1]] = 2;
        //Go in each direction until you find wall
        //Recurse over that cell
        for(int k=0; !flag && k<dirs.length; k++){
            int i=start[0] + dirs[k][0];
            int j=start[1] + dirs[k][1];
            while(i<maze.length && i>=0 && j >=0 && j<maze[0].length && maze[i][j] != 1){
                i= i + dirs[k][0];
                j = j+ dirs[k][1];
            }
            i = i - dirs[k][0];
            j = j - dirs[k][1];
            if(maze[i][j] != 2) dfs(maze, new int[]{i,j}, destination);
        }
    }
}