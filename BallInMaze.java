//time Complexity : O(m * n)
//space Complexity : O(m * n)
import java.util.LinkedList;
import java.util.Queue;

public class BallInMaze {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze == null || maze.length == 0) return false;
        Queue<int[]> q = new LinkedList<>();
        int m = maze.length;
        int n = maze[0].length;
        int[][] dirs = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        q.add(new int[]{start[0],start[1]});
        maze[start[0]][start[1]] = 2; //marking start as visited
        while(!q.isEmpty()){
            int[] curr = q.poll();
            if(curr[0] == destination[0] && curr[1] == destination[1]){
                return true;
            }
            for(int[] dir: dirs){
                int r = curr[0];
                int c = curr[1];
                while(r >= 0 && c>= 0 &&  r < m && c < n && maze[r][c] != 1){
                    r = r+ dir[0];
                    c=  c+dir[1]; 
                }
                r = r- dir[0];
                c = c-dir[1];
                
                if(maze[r][c] != 2){
                    q.add(new int[]{r,c});
                    maze[r][c] = 2;
                }
            }
        }
        
      return false;  
    }

}
