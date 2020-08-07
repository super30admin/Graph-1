/**
 * Time complexity : O(m*n) We might have to traverse half of the maze to get to destination
 * Space complexity : O(m*n) Queue size could go upto m*n
 */
import java.util.*;
public class TheMaze {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze.length == 0 || maze[0].length == 0) return false;

        int m = maze.length;
        int n = maze[0].length;
        Queue<int[]> q = new LinkedList<>();

        q.add(start);
        maze[start[0]][start[1]] = 2;

        int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
        while(!q.isEmpty())
        {
            int[] curr = q.poll();
            if(curr[0] == destination[0] && curr[1] == destination[1]) return true;
            for(int[] d : dirs)
            {
                int r = curr[0];
                int c = curr[1];

                while(r>=0 && r< m && c >=0 && c < n && maze[r][c]!=1)
                {
                    r = r + d[0];
                    c = c + d[1];
                }

                r = r - d[0];
                c = c - d[1];

                if(maze[r][c] != 2)
                {
                    maze[r][c] = 2;
                    q.add(new int[]{r,c});
                }

            }


        }

        return false;
}
}