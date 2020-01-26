/*
LeetCode Submitted : YES
Time Complexity : O(maze length * maze width)
Space Complexity : O(maze length )
The idea is to use Queue for BFS traversal such that for each position we will traverse till we reach end of the maze. Also, check to see if we reach destination.We are not going to use visited array in this implementation and use current maze to update the location so we don't visit same location again.
*/
import java.util.*;

public class Main {
  
  static int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
  static int m;
  static int n;
  public static void main(String[] args) {
    int[][] grid = {
      {0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};

    int rowStart = 0;
    int colStart = 4;
    int rowDest  = 3;  //3;
    int colDest  = 2; //2;
    m = grid.length;
    n = grid[0].length;

    //boolean[][] visited = new boolean[m][n];

    boolean result = maze(grid,rowStart,colStart,rowDest,colDest); 
    System.out.println(result);

  }

  private static boolean maze(int[][] grid, int rowStart, int colStart, int rowDest, int colDest){

    if(rowStart == rowDest && colStart == colDest)
      return true;

    Queue<int[]> q = new LinkedList<>();

    q.add(new int[]{rowStart,colStart});
    grid[rowStart][colStart] = 2;

    while(!q.isEmpty()){
        int[] position = q.poll();
        if(position[0] == rowDest && position[1] == colDest)
            return true;
            
        for(int[] dir : dirs){
            int r = dir[0] + position[0];
            int c = dir[1] + position[1];

            if(r >= 0 && c>=0 && r < m && c < n && (grid[r][c] == 0 || grid[r][c] == 2)){
                while(grid[r][c] == 0){
                    r = r + dir[0];
                    c = c + dir[1];
                    if(r >= 0 && c>=0 && r < m && c < n && (grid[r][c] == 0 || grid[r][c] == 2)){
                        continue;  
                    }
                    r = r - dir[0];
                    c = c - dir[1];
                    
                    if(grid[r][c] != 2){
                        grid[r][c] = 2;
                        q.add(new int[]{r,c});
                    }
                    //break;  
                }
            }
        }
    }
    return false;
  }
}
