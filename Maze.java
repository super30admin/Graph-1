
//TC - O(m*n)^2
//SC - O(m*n)
// Passed all Test cases on Leetcode : Yes
// Any issues faced while executing the code : No
import java.util.LinkedList;
import java.util.Queue;

public class Maze {
    int[][] dirs;
    int m ,n;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        m = maze.length;
        n = maze[0].length;
        dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}} ;// U D L R
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start[0],start[1]});
        maze[start[0]][start[1]] =2;
        while(! q.isEmpty()){
            int[] curr = q.poll();

            for(int[] dir : dirs){
                int nr = curr[0]+dir[0];
                int nc = curr[1]+dir[1];
                while(nr >=0 && nc >=0 && nr < m && nc < n && maze[nr][nc] != 1){
                    nr += dir[0];
                    nc += dir[1];

                }
                nr  -= dir[0];
                nc  -= dir[1];
                if(maze[nr][nc] == 0){
                    if(nr == destination[0] && nc == destination[1]){
                        return true;
                    }
                    q.add(new int[]{nr,nc});
                    maze[nr][nc]=2;
                }
            }

        }
        return false;
    }
}
