// Time Complexity : 
/*
 * APPROACH 1 : BFS: O(n) where n is the number of elements in the matrix
 * APPROACH 2 : DFS: O(n) where n is the number of elements in the matrix
 */

// Space Complexity : 
/*
 * APPROACH 1 : BFS: O(n) where n is the number of elements in the queue at a certain instant
 * APPROACH 2 : DFS: O(n) n recursive calls for the stack
 */

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, I think this is a bit difficult problem. Had to watch video twice to fully understand everything

//DFS APPROACH

class Solution {
    int m, n;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze == null || maze.length == 0) return true;
        m = maze.length; n = maze[0].length;
        maze[start[0]][start[1]] = 2;//mark visited
        return dfs(maze, start, destination);
    }
    private boolean dfs(int[][] maze, int[] start, int[] destination){
        //base
        if(start[0] == destination[0] && start[1] == destination[1]) return true;
        //logic
        int[][] dirs = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        for(int[] dir: dirs){
            int r = start[0]; int c = start[1];//each time we call DFS recursively r and c is initialized with new start values on line 39
            while(r < m && r >= 0 && c < n && c >= 0 && maze[r][c] != 1){
                r += dir[0]; c += dir[1];
            }
            r -= dir[0]; c -= dir[1];//bring the ball back to correct position since it overshot one cell
            if(maze[r][c] !=2){
                maze[r][c] = 2;
                if(dfs(maze, new int[] {r,c}, destination)) return true;
            }
        }
        return false;
    }
}

//BFS APPROACH

class Solution {
    int m, n;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze == null || maze.length == 0) return true; //edge case
        m = maze.length; n = maze[0].length;
        maze[start[0]][start[1]] = 2;
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        int[][] dirs = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        while(!q.isEmpty()){
            int[] curr = q.poll();//take the first node out and start processing
            if(curr[0] == destination[0] && curr[1] == destination[1]) return true;
            for(int[] dir: dirs){
                int r = curr[0]; int c = curr[1];
                while(r < m && r >= 0 && c < n && c >= 0 && maze[r][c] != 1){
                    r += dir[0]; c += dir[1];
                }
                r -= dir[0]; c -= dir[1];
                if(maze[r][c] !=2){
                    maze[r][c] = 2;
                    q.add(new int[] {r,c});//add children to the queue
                }
            }
        }

        return false;
    }
}
