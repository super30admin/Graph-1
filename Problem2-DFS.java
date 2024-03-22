// ## Problem2 The Maze (https://leetcode.com/problems/the-maze/)

class Solution {
    // DFS - The neighbors is the next position we will stop at, 
    // and not immediate neighbors like in a regular dfs
    // we will maintain visited by marking a node as 2
    // Time - O(mn)
    // Space - O(mn)

    int[][] dirs;

    private boolean dfs(int[][] maze, int[] curr, int[] destination){
        //base

        //logic
        // iterate over all valid neighbors
        for(int[] dir: dirs){
            int r=curr[0];
            int c=curr[1];

            // hit the next wall
            while(r>=0 && r<maze.length && c>=0 && c<maze[0].length && maze[r][c]!=1){
                r+=dir[0];
                c+=dir[1];
            }

            // step-back int same direction as we went one step ahead
            r-=dir[0];
            c-=dir[1];

            // check if not already visited
            if(maze[r][c]!=2){
                // check if destination
                if(r==destination[0] && c==destination[1])  return true;

                // mark visited and do dfs
                maze[r][c]=2;
                if(dfs(maze, new int[] {r,c}, destination)){
                    return true;
                }
            }
        }

        //not found
        return false;
    }

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(start[0]==destination[0] && start[1]==destination[1]){
            return true;
        }
        this.dirs= new int[][] {{0,1},{1,0},{0,-1},{-1,0}};

        return dfs(maze, start, destination);
    }
}