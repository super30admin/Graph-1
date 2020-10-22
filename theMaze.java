// Time Complexity : O(n*m) since we are doing this for n*m tiles
// Space Complexity : O(n*m) since we are keeping a visited for m*n and also O(m*n) for stack memory
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

/*

This can be done in bfs we just have to see that once the destination is reached do we add a new child for this position
If we can that means that the ball will not stop rolling

For DFS, we use helper function(maze and coordinates of start and destination)

in this helper fuction we go to extreme left right up and down we can go from this point,
once we reach the end we do helper but now our start will be the end point in the previous step


the helper returns - 
false if there is ablock or if its visited
true if it reaches the dest

if this is still not the destination then we continue rolling to the end in all the directions from this point

if any of the subproblems return true, stack will collapse and return true for all;
else if all return false then it can be reached


Here instead of searching the destination first and then see if the ball is rolling or not,
we first check the endpoints and then see if the this endpoint is our destination or not
*/

public class Main {
    public class Solution {

        int[][] dirs = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
        int nRows, nCols;
        boolean[][] visited;

        public boolean willReach(int maze[][], int start[], int dest[]) {
            nRows = maze.length;
            nCols = maze[0].length;

            visited = new boolean[nRows][nCols];

            return helper(maze, start, dest);
        }

        private boolean helper(int maze[][], int start[], int dest[]) {
            int row = start[0];
            int col = start[1];

            if (maze[row][col] == 1)
                return false;

            if (row == dest[0] && col == dest[1])
                return true;

            visited[row][col] = 1;

            // or we can encode alternatively so that we dont explore this point again
            // maze[row][col] = -1;

            for (int[] dir : dirs) {
                int r = row;
                int c = col;

                while (r >= 0 && r < nRows && c >= 0 && c < nCols && maze[r][c] == 0) {
                    r = r + dir[0];
                    c = c + dir[1];
                }

                if (helper(maze, new int[] { r - dir[0], c - dir[1] }, dest))
                    return true;

            }
            return false;
        }

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int maze[][] = { { 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 1, 0 }, { 1, 1, 0, 1, 1, },
                { 0, 0, 0, 0, 0 } };
        int start[] = { 0, 4 };
        int dest[] = { 5, 4 };
        System.out.println(s.willReach(maze, start, dest));
    }
}
