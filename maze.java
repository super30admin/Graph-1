/**
 * Time Complexity: O(m * n), where m is the number of rows and n is the number of columns in the maze.
 * - In the worst case, the DFS explores every cell in the maze to find the destination.
 * - Each cell is visited once, and each exploration in a direction takes linear time proportional to the distance from the current cell to the wall.

 * Space Complexity: O(m * n), where m is the number of rows and n is the number of columns in the maze.
 * - The space complexity is determined by the recursion stack used during DFS and the maze itself.
 * - The recursion stack can grow up to O(m * n) in the worst case if the DFS traverses all cells.
 * - The maze's cells are marked to prevent revisits, so the overall space is dominated by the size of the maze.
 */
class Solution {
    // Define directions for movement (up, down, left, right)
    int[][] dirs;
    // A flag to indicate if the destination has been reached
    boolean flag;

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int rows = maze.length;
        int columns = maze[0].length;

        // Initialize directions for movement (up, down, left, right)
        this.dirs = new int[][] { 
            { -1, 0 },  // up
            { 1, 0 },   // down
            { 0, -1 },  // left
            { 0, 1 }    // right
        };

        // Initialize the flag to false
        this.flag = false;

        // Start depth-first search (DFS) from the start position
        dfs(maze, start, destination);

        // Return the flag which indicates whether a path to the destination was found
        return flag;
    }

    private void dfs(int[][] maze, int[] start, int[] destination) {
        // Base case: If the destination has been reached, terminate the search
        if (flag) return;

        // Mark the current position as visited
        maze[start[0]][start[1]] = 2;

        // Explore all four possible directions from the current position
        for (int[] dir : dirs) {
            int currentRow = start[0];
            int currentCol = start[1];

            // Move continuously in the current direction until hitting a wall or boundary
            while ((currentRow >= 0 && currentRow < maze.length)
                    && (currentCol >= 0 && currentCol < maze[0].length)
                    && maze[currentRow][currentCol] != 1) {
                currentRow += dir[0];  // Update the row index
                currentCol += dir[1];  // Update the column index
            }

            // Step back to the last valid position before hitting the wall/boundary
            currentRow -= dir[0];
            currentCol -= dir[1];

            // If the destination is reached, set the flag to true
            if (currentRow == destination[0] && currentCol == destination[1]) {
                flag = true;
                return;
            }

            // If this position hasn't been visited yet
            if (maze[currentRow][currentCol] != 2) {
                // Recursively perform DFS from the new position
                dfs(maze, new int[] { currentRow, currentCol }, destination);
            }
        }
    }
}
