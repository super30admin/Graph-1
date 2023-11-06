import java.util.LinkedList;
import java.util.Queue;

public class Maze {
    int[][] dirs;
    int m,n;
    public boolean hasPath(int[][] maze,int[] start, int[] destination){
        if(maze == null || maze.length==0){
            return false;
        }

        m = maze.length;
        n = maze[0].length;
        dirs = new int[][] {{-1,0},{1,0},{0,-1},{0,1}}; //U D L R
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {start[0], start[1]});
        maze[start[0]][start[1]] = 2;


        while(!q.isEmpty()){
            int[] curr = q.poll();
            if(curr[0] == destination[0] && curr[1] == destination[1]){
                return true;
            }

            for(int[] dir : dirs){
                int nr = curr[0];
                int nc = curr[1];
                while(nr >= 0 && nc >= 0 && nr < m && nc < n && maze[nr][nc] != 1){
                    nr = nr + dir[0];
                    nc = nc + dir[1];
                }
                nr = nr - dir[0];
                nc = nc - dir[1];
                if(maze [nr][nc]==0){
                    q.add(new int[]{nr,nc});
                    maze[nr][nc] = 2;
                }
            }
        }
        return false;
    }
}
