// Solution - DFS Approach
// TC - O(m*n) - iterate over maze once.
// SC - O(m*n) - recursive stack space. Worst case we have to visit all cells in the maze.
// class Solution {
//     public boolean hasPath(int[][] maze, int[] start, int[] destination) {
//         int[][] dirs = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
//         maze[start[0]][start[1]] = 2;
//         return helper(maze, start, destination, dirs);
//     }

//     private boolean helper(int[][] maze, int[] start, int[] destination, int[][] dirs) {
//         // base
//         if (start[0] == destination[0] && start[1] == destination[1]) {
//             return true;
//         }
//         // Logic
//         // Recurse
//         for (int[] dir : dirs) { // for each direction, keep moving in that direction until we hit a wall or
//                                  // boundary.
//             int r = start[0];
//             int c = start[1];
//             while (r >= 0 && r < maze.length && c < maze[0].length && c >= 0 && maze[r][c] != 1) { // keep moving in
//                                                                                                    // that direction
//                                                                                                    // until we hit a
//                                                                                                    // wall or boundary.
//                 r += dir[0];
//                 c += dir[1];
//             }
//             r -= dir[0]; // move back to the last valid position.
//             c -= dir[1]; // move back to the last valid position.
//             if (maze[r][c] != 2) { // if we have not visited this cell before, then only recurse. This is important
//                                    // to avoid infinite loop.
//                 maze[r][c] = 2;
//                 if (helper(maze, new int[] { r, c }, destination, dirs)) { // recurse with new position as start
//                                                                            // position.
//                     return true; // if we found a path to destination, return true.
//                 }
//             }
//         }
//         return false;

//     }
// }

// Solution 2: BFS Approach
// TC - O(m*n) - iterate over maze once.
// SC - O(m*n) - queue space. Worst case we have to visit all cells in the maze.
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        int[][] dirs = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        maze[start[0]][start[1]] = 2;

        while (!q.isEmpty()) { // iterate over queue until it is empty.
            int[] current = q.poll();
            int r = current[0];
            int c = current[1];
            if (r == destination[0] && c == destination[1])
                return true; // if we found a path to destination, return true.

            for (int[] dir : dirs) { // for each direction, keep moving in that direction until we hit a wall or
                                     // boundary.
                r = current[0];
                c = current[1];
                while (r >= 0 && r < maze.length && c >= 0 && c < maze[0].length && maze[r][c] != 1) { // keep moving in
                                                                                                       // that direction
                                                                                                       // until we hit a
                                                                                                       // wall or
                                                                                                       // boundary.
                    r += dir[0];
                    c += dir[1];
                }
                r -= dir[0]; // move back to the last valid position.
                c -= dir[1]; // move back to the last valid position.
                if (maze[r][c] != 2) { // if we have not visited this cell before, then only add it to the queue. This
                                       // is important to avoid infinite loop.
                    maze[r][c] = 2;
                    q.add(new int[] { r, c }); // add new position to the queue.
                }
            }

        }
        return false;
    }
}