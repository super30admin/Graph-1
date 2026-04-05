// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
We do a dfs recursive approach to roll the ball from the start position until destination coordinates are met.
As mentioned in the problem, the ball can be rolled in 4 directions, so we declare a dirs array and iterate the
i,j coordinates in all 4 directions. We need to roll ball until a wall is hit, so we use a while loop to iterate
with the given direction until conditions go out of bounds.Now, we decrement to the previous position and explore
in all directions from that position and we also keep track of visited array to mark positions such that we
dont visit them again.
 */
class Solution {
    boolean flag;
    int[][] dirs;
    int m, n;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        this.flag = false;
        this.dirs = new int[][] {{-1, 0} , {0, -1} , {1, 0} , {0, 1}};
        this.m = maze.length;
        this.n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        dfs(maze, start[0] , start[1], destination, visited);
        return flag;
    }

    private void dfs(int[][] maze, int i , int j, int[] destination, boolean[][] visited) {
        if(i == destination[0] && j == destination[1]) {
            flag = true;
            return;
        }

        visited[i][j] = true;

        for(int[] dir : dirs) {
            int nr = dir[0] + i;
            int nc = dir[1] + j;

            while(nr >= 0 && nc >= 0 && nr < m && nc < n && maze[nr][nc] == 0) {
                nr += dir[0];
                nc += dir[1];
            }

            nr -= dir[0];
            nc -= dir[1];

            if(!visited[nr][nc])
                dfs(maze, nr, nc , destination, visited);
        }
    }
}