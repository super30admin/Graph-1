/*
LeetCode Submitted : Can't check not having premium but seems correct
Time Complexity : O(maze length * maze width)
Space Complexity : O(maze length )

The idea is to use Queue for BFS traversal such that for each position we will traverse till we reach end of the maze. Also, check to see if we reach destination. The visited array is created to keep track of not repeating same location again and again.
*/
import java.util.*;

class Main {
  
  static int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
  static int m;
  static int n;
  public static void main(String[] args) {
    int[][] grid = {
      {0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};

    int rowStart = 0;
    int colStart = 4;
    int rowDest  = 4;  //3;
    int colDest  = 4; //2;
    m = grid.length;
    n = grid[0].length;

    boolean[][] visited = new boolean[m][n];

    boolean result = maze(grid,rowStart,colStart,rowDest,colDest,visited); 
    System.out.println(result);

  }

  private static boolean maze(int[][] grid, int rowStart, int colStart, int rowDest, int colDest,boolean[][]visited){

    if(rowStart == rowDest && colStart == colDest)
      return true;

    Queue<int[]> q = new LinkedList<>();

    q.add(new int[]{rowStart,colStart});
    visited[rowStart][colStart] = true;

    while(!q.isEmpty()){
      int[] position = q.poll();
      for(int[] dir : dirs){
        int r = dir[0] + position[0];
        int c = dir[1] + position[1];

        if(r >= 0 && c>=0 && r < m && c < n && grid[r][c] == 0 && visited[r][c] == false){
          while(visited[r][c] == false){
            int r1 = r + dir[0];
            int c1 = c + dir[1];
            if(r1 >= 0 && c1>=0 && r1 < m && c1 < n && grid[r1][c1] == 0){
              r = r1;
              c = c1;
              continue;  
            }
            if(r == rowDest && c == colDest)
              return true;
            
            visited[r][c] = true;
            q.add(new int[]{r,c});
            break;  
          }
        }
      }
    }
    return false;
  }
}
