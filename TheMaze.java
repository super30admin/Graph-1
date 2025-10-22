/**
TC: O(m*n(m+n)) for each node, we visit its neighbors which can be max m or max r.
SC: O(m*n) rows*cols for vis[][].
Approach: Take a boolean[][] visited to keep track of visited. perform dfs on each node starting from the start[], for each node visits its neighbors in all the direction and keep visited in one direction until we hit the wal or obstacle.At any dfs call if our node happens to be the destination then return true right away. At the end if we are not able to visit the destination then return false.
 */

class Solution {
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
    boolean[][] vis = new boolean[maze.length][maze[0].length];

    return dfs(maze,start,destination, vis);
    }

    private boolean dfs(int[][] maze, int[] start, int[] destination, boolean[][] vis){
        int row = start[0];
        int col = start[1];
        if(vis[row][col]) return false;
        if(row == destination[0] && col == destination[1])
            return true;
        if(vis[row][col] || row < 0 || row >= maze.length || col <0 || col >= maze[0].length)
            return false;

        vis[row][col] = true;

        for(int[] dir : dirs){
            int newR = row + dir[0];
            int newC = col + dir[1];

            while(newR >= 0 && newR < maze.length && newC >= 0 && newC < maze[0].length && maze[newR][newC] == 0){
               newR += dir[0];
               newC += dir[1];
            }

            if(dfs(maze,new int[] {newR-dir[0],newC-dir[1]},destination,vis))
                return true;
        }
     return false; 
    }
}