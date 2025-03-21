//Here the approach is to use BFS(because connected component) to traverse to all effective neighbors to see if any effective neighbor could lead to the destination. If it could, we return true, else we return false
//The most important thing here is to not just check for immediate neighbors, but to check for an effective neighbor, that is, the place where a ball stops(an obstacle or a wall).
//Time Complexity: O(m*n);
//Space Complexity: O(m*n) for queue
//BFS
import java.util.LinkedList;
import java.util.Queue;

class Solution{
    int m, n;
    int[][] dirs;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze == null || maze.length == 0){
            return false; 
        }
        m = maze.length;
        n = maze[0].length;
        dirs = new int[][] {{-1,0}, {1,0}, {0,-1}, {0,1}}; //U D L R
        Queue<int []> q = new LinkedList<>();
        if(start[0] == destination[0] && start[1] == destination[1]) return true;
        q.add(start);
        maze[start[0]][start[1]] = 2;
        while(!q.isEmpty()){
            int [] curr = q.poll();
            for(int[] dir: dirs){
                int nr = curr[0] + dir[0];
                int nc = curr[1] + dir[1];
                //effective neighbour
                while(nr >= 0 && nr < m && nc >= 0 && nc < n && maze[nr][nc] != -1){
                    nr = nr + dir[0];
                    nc = nc + dir[1];
                }
                //stepback
                nr = nr - dir[0];
                nc = nc - dir[0];
                if(nr == destination[0] && nc == destination[1]) return true;
                if(maze[nr][nc] != 2){
                    q.add(new int[]{nr, nc});
                    maze[nr][nc] = 2;
                }
            }
        }
        return false;
    }
}



