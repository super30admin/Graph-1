// Time Complexity : O(m*n(m+n)) -> O(m*n) (Because  m+n will be much smaller with the walls in between, m+n will be at it's max when there
// are no walls)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * DFS
 */

class Solution {

    int [][] dirs;
    int m, n;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {

        this.m = maze.length;
        this.n = maze[0].length;
        dirs = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

        return dfs(maze, start, destination);
    }

    private boolean dfs(int[][] maze, int[] start, int[] destination) {

        //base
        if(start[0] == destination[0] && start[1] == destination[1]) return  true;
        if(maze[start[0]][start[1]] == 2) return false;

        //logic
        maze[start[0]][start[1]] = 2;

        for(int[] dir: dirs) {
            int r = start[0] + dir[0];
            int c = start[1] + dir[1];

            while(r>=0 && c>=0 && r<m && c<n && maze[r][c] != 1) {
                r += dir[0];
                c += dir[1];
            }

            r -= dir[0];
            c -= dir[1];

            if(dfs(maze, new int[]{r,c}, destination)) return true;
        }

        return false;
    }
}
// Time Complexity : O(m*n(m+n)) -> O(m*n) (Because  m+n will be much smaller with the walls in between, m+n will be at it's max when there
// are no walls)
// Space Complexity : O(m*n)
/**
 * BFS
 */
class Solution {

    int [][] dirs;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {

        int m = maze.length;
        int n = maze[0].length;
        dirs = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        Queue<int[]> path = new LinkedList<>();

        path.add(start);

        while(!path.isEmpty()) {
            int[] curr = path.poll();

            for(int[] dir: dirs) {
                int r = curr[0] + dir[0];
                int c = curr[1] + dir[1];

                while(r>=0 && c>=0 && r<m && c<n && maze[r][c] != 1) {
                    r += dir[0];
                    c += dir[1];
                }

                r -= dir[0];
                c -= dir[1];

                if(r == destination[0] && c == destination[1])
                    return true;

                if(maze[r][c] != 2) {
                    path.add(new int[]{r, c});
                    maze[r][c] = 2;
                }
            }
        }

        return false;
    }
}