/**
 * LeetCode Execution: No Problem
 * 
 * Time Complexity = O(m*n)
 * Space Complexity = O(m*n) for the visited matrix
 */


class Solution {
  public boolean hasPath(int[][] maze, int[] start, int[] destination) {
      
      int r = maze.length;
      int c = maze[0].length;
      
      int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
      boolean[][] visited = new boolean[r][c];
      
      Queue <int[]> q = new LinkedList<>();
      
      visited[start[0]][start[1]] = true;
      
      q.add(start);
      
      while(!q.isEmpty()) {
          int[] el = q.remove();
          
          if (el[0] == destination[0] && el[1] == destination[1]) return true;
          
          for (int[] dir : dirs) {
              int x = el[0] + dir[0];
              int y = el[1] + dir[1];
              
              while (x >= 0 && x < r && y >= 0 && y < c && maze[x][y] == 0) {
                  x += dir[0];
                  y += dir[1];
              }
              
              int tx = x - dir[0];
              int ty = y - dir[1];
              
              if (!visited[tx][ty]) {
                  q.add(new int[] {tx, ty});
                  visited[tx][ty] = true;
              }
          }
          
      }
      
      return false;
  }
}