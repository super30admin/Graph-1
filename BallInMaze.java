import java.util.LinkedList;
import java.util.Queue;

//Idea is to use bfs to traverse and mark the visited cells to avoid going through cycles
//Time Complexity:O(m*n)
//Space Complexity:O(m*n)
public class BallInMaze {
    int[][] dirs;
    int m,n;
    public boolean findBall(int[][] maze, int[] start, int[] destination) {
        this.dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        this.m = maze.length;
        this.n = maze[0].length;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start[0], start[1]});
        maze[start[0]][start[1]] = -1;

        while(!q.isEmpty())
        {
            int[] curr = q.poll();
            for(int[] dir: dirs)
            {
                int r = dir[0] + curr[0];
                int c = dir[1] + curr[1];

                while(r>=0 && c>=0 && r<m && c<n && maze[r][c] != 1)
                {
                    r += dir[0];
                    c += dir[1];
                }

                r -= dir[0];
                c -= dir[1];

                if(r == destination[0] && c == destination[1]) return true;
                if(maze[r][c] != -1)
                {
                    q.add(new int[]{r,c});
                    maze[r][c] = -1;
                }
            }
        }
        return false;
        
    }
}
