import java.util.LinkedList;
import java.util.Queue;


/*
Time Complexity : O(m*n)
Space Complexity : O(m*n)
Approach :
We can maintain the queue of all the cells where the ball is going to stop. The cells just before a wall. We
start the ball in all 4 dirs, if there is a cell where it is going to stop and is already not visited, add them to the queue.
If one such cell is the destination return true, else the ball is never going to stop at the destination. So

1. Find neighbors where ball can stop by going in 1 direction. Add it to the queue.
2. Mark the cell visited so that it is not visited again.

*/

public class Maze {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int rows = maze.length;
        int cols = maze[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        maze[start[0]][start[1]] = 2;
        int[][] dirs = {{0,1}, {1,0}, {-1,0},{0,-1}};
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            for(int[] dir : dirs){
                int nr = dir[0]+ curr[0];
                int nc = dir[1]+curr[1];
                // Move till you encounter a wall
                while(nr >= 0 && nc >= 0 && nr < rows && nc < cols && maze[nr][nc] != 1){
                    nr = nr + dir[0];
                    nc = nr + dir[1];
                }
                // move back one step
                nr -= dir[0];
                nc -= dir[1];
                // if the place we stopped at, is the destination return true.
                if(nr == destination[0] && nc == destination[1]) return true;
                // If the cell is not visited already
                if(maze[nr][nc] != 2) {
                    queue.add(new int[]{nr, nc});
                    maze[nr][nc] = 2;
                }
            }

        }
        return false;
    }

}
