// Time Complexity : O(m*n) m -> no of rows of maze; n -> no. of columns of maze
// Space Complexity : O(m*n) visited array and recursive stack space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach1: DFS
// Once the ball starts rolling in a particular direction from the start point, it will continue to roll until it finds a wall. All the boundaries and value 1 are considered to be wall.
// On reaching the wall, the specific point will be marked visited and we need to trace another path considering a different direction from the visited point.
// These steps will be performed recursively until the destination is reached or it is no more possible to move in an empty space.

/*
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        // edge case
        if(maze == null || maze.length == 0 || start == null || destination == null) {
            return false;
        }
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        return traversePath(maze, destination, start[0], start[1], visited);
    }
    
    private boolean traversePath(int[][] maze,int[] destination, int i, int j, boolean[][] visited) {
        int m = maze.length;
        int n = maze[0].length;
        // base case
        if(i < 0 || i >= m || j < 0 || j >= n || maze[i][j] == 1) 
            return false;
        
        if(i == destination[0] && j == destination[1])
            return true;
        
        int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        
        for(int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
                
            while(isValid(x,y,m,n) && maze[x][y] == 0) {
                x += dir[0];
                y += dir[1];
            }
            x -= dir[0];
            y -= dir[1];
              
            // marking the last coordinate upto the wall as visited
            if(isValid(x,y,m,n) && !visited[x][y]) {
                visited[x][y] = true;
                
                if(traversePath(maze, destination, x, y, visited))
                    return true;
            }
        }
        return false;
    }

    private boolean isValid(int x, int y, int m, int n) {
        if(x >= 0 && x < m && y >= 0 && y < n)
            return true;
        return false;
    }
}
*/


// Time Complexity : O(m*n) m -> no of rows of maze; n -> no. of columns of maze
// Space Complexity : O(m*n) queue datastructure and visited array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach2: BFS
// In breadth first search approach, the starting point will be added in queue. The underlying concept is same i.e. going on in specific direction until a wall is hit.
// Here once a wall is hit, the last point is added to queue and the process continues.

class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        // edge case
        if(maze == null || maze.length == 0 || start == null || destination == null) {
            return false;
        }
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] visited = new boolean[m][n]; // visited array
        int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}}; // 4 directions
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        
        while(!q.isEmpty()) { // while there is a point to process
            int[] curr = q.poll();
            if(curr[0] == destination[0] && curr[1] == destination[1])
                return true;
            for(int[] dir : dirs) {
                int x = curr[0] + dir[0];
                int y = curr[1] + dir[1];

                while(isValid(x,y,m,n) && maze[x][y] == 0) { // while moving in current direction is valid
                    x += dir[0];
                    y += dir[1];
                }
                x -= dir[0]; // retracting from wall
                y -= dir[1];

                // marking the last coordinate upto the wall as visited
                if(isValid(x,y,m,n) && !visited[x][y]) {
                    visited[x][y] = true;
                    q.offer(new int[]{x,y});
                }
            }
        }
        return false;
    }

    private boolean isValid(int x, int y, int m, int n) {
        if(x >= 0 && x < m && y >= 0 && y < n)
            return true;
        return false;
    }
}

