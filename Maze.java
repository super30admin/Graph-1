import java.util.Deque;
import java.util.LinkedList;


public class Maze{
    private int[][] dirs;
    private boolean destinationReached;


    //BFS
    // Time Complexity : O(m * n ) where m is the number of rows and n is the number of cols in the maze
    // Space Complexity :O(m * n ) where m is the number of rows and n is the number of cols in the maze
    // Did this code successfully run on Leetcode :yes
     public boolean hasPath(int[][] maze, int[] start, int[] destination) {
         if(maze == null || maze.length == 0){
             return false;
         }
         int numberOfRows = maze.length;
         int numberOfColumns = maze[0].length;
         this.dirs = new int[][] {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
         boolean[][] visited = new boolean[numberOfRows][numberOfColumns];

         Deque<int[]> q = new LinkedList<>();
         visited[start[0]][start[1]] = true;
         q.add(start);

         while(! q.isEmpty()){
             int[] currentCell = q.poll();
             for(int[] direction : dirs){
                 int nr = currentCell[0] + direction[0];
                 int nc = currentCell[1] + direction[1];

                while(nr >=0 && nr < numberOfRows && nc >=0 && nc < numberOfColumns
                 && maze[nr][nc] == 0){
                     nr += direction[0];
                     nc += direction[1];
                }
                 //move one step back to get the stopping position of the ball
                 nr -= direction[0];
                 nc -= direction[1];
                 if(nr == destination[0] && nc == destination[1]){
                     return true;
                 }
                 if(! visited[nr][nc]){
                     visited[nr][nc] = true;
                     q.add(new int[] {nr, nc});
                 }
             }
         }
         return false;
     }

    //DFS
    // Time Complexity : O(m * n ) where m is the number of rows and n is the number of cols in the maze
    // Space Complexity :O(m * n ) where m is the number of rows and n is the number of cols in the maze
    // Did this code successfully run on Leetcode :yes
    public boolean hasPathDFS(int[][] maze, int[] start, int[] destination) {
        if(maze == null || maze.length == 0){
            return false;
        }
        int numberOfRows = maze.length;
        int numberOfColumns = maze[0].length;
        this.dirs = new int[][] {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
        boolean[][] visited = new boolean[numberOfRows][numberOfColumns];

        visited[start[0]][start[1]] = true;
        return dfs(start[0], start[1], maze, destination, visited);
    }

    private boolean dfs(int rowIdx, int colIdx, int[][] maze, int[] destination, boolean[][] visited){
        if(destinationReached){
            return true;
        }
        if(rowIdx == destination[0] && colIdx == destination[1]){
            destinationReached = true;
            return true;
        }

        boolean canReachDestinationFromCurrentCell = false;
        for(int[] dir : dirs){

            int nr = rowIdx + dir[0];
            int nc = colIdx + dir[1];
            while(nr >=0 && nr < maze.length && nc >=0 && nc < maze[0].length
                    && maze[nr][nc] == 0){
                nr += dir[0];
                nc += dir[1];
            }
            //move one step back to get the stopping position of the ball
            nr -= dir[0];
            nc -= dir[1];

            if(! visited[nr][nc]){
                visited[nr][nc] = true;
                if(! canReachDestinationFromCurrentCell){
                    canReachDestinationFromCurrentCell = dfs(nr, nc, maze, destination, visited);
                }
            }
        }
        return canReachDestinationFromCurrentCell;
    }
}
