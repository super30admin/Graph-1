//TimeComplexity: O(m*n)
//SpaceComplexity:O(m*n)

public class TheMazeBFS {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
         Queue<int[]>  queue = new LinkedList<>();
         queue.add(start);
         maze[start[0]][start[1]] = 2;
         int [][] dir = new int[][]{{-1,0}, {0,1}, {0,-1}, {1,0}};
         while(!queue.isEmpty()) {
            int []current = queue.poll();
            for(int []d : dir) {
                  int row = current[0];
                  int column = current[1];
                  while(row >=0 && row < maze.length && column >=0 && column < maze[0].length && maze[row][column] != 1) {
                    row = row +d[0];
                    column = column + d[1];
                  } 
                   row = row-d[0];
                   column = column -d[1];
                   if(row == destination[0] && column == destination[1]) {
                    return true;
                   }
                   if(maze[row][column] != 2) {
                   queue.add(new int [] {row, column});
                   maze[row][column] = 2;
                   }
                   
                   
                
            }
         }
         return false;
    }
}