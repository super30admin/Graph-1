

//Approach - Depth First Search
//Time Complexity - O(mn) - where m is no of rows in maze, n is no of cols in maze
//Space Complexity - O(mn)

class Solution {
  int[][] dirs = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
  int m,n;
  public boolean hasPath(int[][] maze, int[] start, int[] destination) {

    if(maze == null || maze.length == 0){
      return false;
    }

    dfs(maze, start, destination);
    m = maze.length;
    n = maze[0].length;

    return dfs(maze, start, destination);
  }


  private boolean dfs(int[][] maze, int[] start, int[] destination){

    if(start[0] == destination[0] && start[1] == destination[1]){
      return true;
    }

    maze[start[0]][start[1]] = 2;
    for(int[] dir: dirs){
      int r = dir[0]+start[0];
      int c = dir[1]+start[1];

      while(r >= 0 && r < m && c >= 0 && c < n && maze[r][c] != 1){
        r = r+dir[0];
        c = c+dir[1];
      }

      r = r-dir[0];
      c = c-dir[1];

      if(maze[r][c] !=2 && dfs(maze, new int[]{r,c}, destination)){
        return true;
      }
    }
    return false;
  }
}


//Approach - Breadth First Search
//Time Complexity - O(mn) - where m is no of rows in maze, n is no of cols in maze
//Space Complexity - O(mn)

class Solution {
  public boolean hasPath(int[][] maze, int[] start, int[] destination) {

    if(maze == null || maze.length == 0){
      return false;
    }

    int m = maze.length, n = maze[0].length;
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{start[0], start[1]});

    int[][] dirs = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};

    while(!queue.isEmpty()){
      int[] curr = queue.poll();

      if(curr[0] == destination[0] && curr[1] == destination[1]){
        return true;
      }

      for(int[] dir: dirs){
        int r = dir[0]+curr[0];
        int c = dir[1]+curr[1];

        while(r >= 0 && r < m && c >= 0 && c < n && maze[r][c] != 1){
          r = r+dir[0];
          c = c+dir[1];
        }

        r = r-dir[0];
        c = c-dir[1];

        if(maze[r][c] != 2){
          maze[r][c] = 2;
          queue.add(new int[]{r,c});
        }
      }
    }
    return false;
  }
}
