/*
LeetCode Submitted : YES
Time Complexity : O(maze length * maze width)
Space Complexity : O(1 )
The idea is to use recursion to travel in DFS fashion. Here, we are using visited array to tarverse the grid till we encounter all the paths..
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

    //boolean[][] visited = new boolean[m][n];

    boolean result = maze(grid,rowStart,colStart,rowDest,colDest); 
    System.out.println(result);

  }

  private static boolean maze(int[][] grid, int rowStart, int colStart, int rowDest, int colDest){
    
    if(rowStart == rowDest && colStart == colDest)
      return true;
    
    if(rowStart >= 0 && colStart >=0 && rowStart < m && colStart < n && (grid[rowStart][colStart] == 1 || grid[rowStart][colStart] == 2))
      return false;

    grid[rowStart][colStart] = 2;

    for(int[] dir : dirs){
      int r = dir[0] + rowStart;
      int c = dir[1] + colStart;
        while(r >= 0 && c>=0 && r < m && c < n && (grid[r][c] == 0 || grid[r][c] == 2)){
          r = r + dir[0];
          c = c + dir[1];
        }
      if(maze(grid, r - dir[0], c - dir[1], rowDest, colDest))
        return true;
    }
    return false;
  }
}

