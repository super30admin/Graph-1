// Time Complexity - O(mn)
// Space Complexity - O(mn)

class Solution {
  public boolean hasPath(int[][] maze, int[] start, int[] destination) {
    if(maze == null || maze.length == 0) return false;
    int m = maze.length;
    int n = maze[0].length;
    int[][] dirs = new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};
    Queue<int[]> queue = new LinkedList<>();
    // Marked as processed
    maze[start[0]][start[1]] = 2;
    queue.add(new int[]{start[0],start[1]});
    while(!queue.isEmpty()) {
      int[] current = queue.poll();
      int row = current[0];
      int col = current[1];
      // If reached destination, path is possible so returned true
      if(row == destination[0] && col == destination[1]) return true;
      for(int[] dir: dirs) {
        int nrow = row + dir[0];
        int ncol = row + dir[1];
        while(nrow >= 0 && nrow < m && ncol >=0 && ncol < n && maze[nrow][ncol] != 1) {
          nrow = nrow + dir[0];
          ncol = ncol + dir[1];
        }
        // back to the cell before hitting a wall
        nrow = nrow - dir[0];
        ncol = ncol - dir[1];
        // Add cell to queue and process it
        if(maze[nrow][ncol] != 2) {
          queue.add(new int[]{nrow, ncol});
          maze[nrow][ncol] = 2;
        }
      }
    }
    return false;
  }
}