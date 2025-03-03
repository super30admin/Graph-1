// In this problem, we are starting the dfs from the given start cell, and marking it as visited, then rolling the ball in 4 
// directions one by one till it hit the wall, then checking if that new position of ball is already visited, if no then starting
// dfs from their. Base check if any of the new position is equal to the destination then returning true else false.

// Time Complexity : O(m*n)+O(m+n)
// Space Complexity : O(m+n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Using DFS
// class Maze {
//     int m, n;
//     int[][] dirs;

//     public boolean hasPath(int[][] maze, int[] start, int[] destination) {
//         // Base Case
//         if (maze == null || maze.length == 0) {
//             return false;
//         }
//         // Declare m,n and dirs array
//         m = maze.length;
//         n = maze[0].length;
//         dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
//         // Make the dfs call and if it returns true then return true
//         if (dfs(maze, start, destination)) {
//             return true;
//         }
//         // Else return false
//         return false;
//     }

//     private boolean dfs(int[][] maze, int[] start, int[] destination) {
//         // Base
//         // Check if any new position where the ball is stopped is equal to our destination or not
//         if (start[0] == destination[0] && start[1] == destination[1]) {
//             // If it is then return true
//             return true;
//         }
//         // Logic
//         // Mark the cell visited
//         maze[start[0]][start[1]] = 2;
//         // Check in 4 directions
//         for (int[] dir : dirs) {
//             // Declare new row and new col
//             int nr = start[0];
//             int nc = start[1];
//             // Check if it is valid row and col and also if it not a wall
//             while (nr >= 0 && nr < m && nc >= 0 && nc < n && maze[nr][nc] != 1) {
//                 // Roll until it hits a wall
//                 nr = nr + dir[0];
//                 nc = nc + dir[1];
//             }
//             // Then since we breaked when it was a wall, go back one cell to go to a valid cell where the ball stopped
//             nr = nr - dir[0];
//             nc = nc - dir[1];
//             // Check if this cell is already visited or not
//             if (maze[nr][nc] != 2) {
//                 // If not then, call dfs from here and if this call returns true, return true
//                 if (dfs(maze, new int[] { nr, nc }, destination)) {
//                     return true;
//                 }
//             }
//         }
//         // Else false
//         return false;
//     }

//     public static void main(String[] args) {
//         Maze m = new Maze();
//         System.out
//                 .println(
//                         m.hasPath(
//                                 new int[][] { { 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 1, 0 },
//                                         { 1, 1, 0, 1, 1 }, { 0, 0, 0, 0, 0 } },
//                                 new int[] { 0, 4 }, new int[] { 4, 4 }));
//     }

// }

// In this problem, we are starting the bfs from the given start cell by putting it in queue, and marking it as visited, then 
// rolling the ball in 4 directions one by one till it hit the wall, then checking if that new position of ball is already visited, 
// if no then putting it in queue and marking that cell as visited. Then checking other direction and putting that in queue.
// Doing this till queue is empty. Base check if any of the new position is equal to the destination then returning true else false.

// Time Complexity : O(m*n)+O(m+n)
// Space Complexity : O(m+n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Using BFS

import java.util.*;

class Maze {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        // Base Case
        if (maze == null || maze.length == 0) {
            return false;
        }
        // Declare m,n and dirs array
        int m = maze.length;
        int n = maze[0].length;
        int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        // Queue for BFS
        Queue<int[]> q = new java.util.LinkedList<>();
        // Add the indices of the start cell to the queue
        q.add(new int[] { start[0], start[1] });
        // Mark this start cell as visited
        maze[start[0]][start[1]] = 2;
        // Do BFS this queue is empty
        while (!q.isEmpty()) {
            // Poll the current element
            int[] curr = q.poll();
            // Base
            // Check if any new position where the ball is stopped is equal to our
            // destination or not
            if (curr[0] == destination[0] && curr[1] == destination[1]) {
                return true;
            }
            // Check in 4 directions
            for (int[] dir : dirs) {
                // Declare new row and new col
                int nr = curr[0];
                int nc = curr[1];
                // Check if it is valid row and col and also if it not a wall
                while (nr >= 0 && nr < m && nc >= 0 && nc < n && maze[nr][nc] != 1) {
                    // Roll until it hits a wall
                    nr = nr + dir[0];
                    nc = nc + dir[1];
                }
                // Then since we breaked when it was a wall, go back one cell to go to a valid
                // cell where the ball stopped
                nr = nr - dir[0];
                nc = nc - dir[1];
                // Check if this cell is already visited or not
                if (maze[nr][nc] != 2) {
                    // If not then, mark it visited and put it in queue to do bfs later from this
                    // cell also
                    q.add(new int[] { nr, nc });
                    maze[nr][nc] = 2;

                }
            }

        }
        // Else return false
        return false;
    }

    public static void main(String[] args) {
        Maze m = new Maze();
        System.out
                .println(
                        m.hasPath(
                                new int[][] { { 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 1, 0 },
                                        { 1, 1, 0, 1, 1 }, { 0, 0, 0, 0, 0 } },
                                new int[] { 0, 4 }, new int[] { 4, 4 }));
    }

}