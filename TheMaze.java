//TC = O(N*M)
//SC = O(N*M)

/*
 * Breadth First Search is used. Till we hit the wall, we traverse in that direction.
 * We stop only if we have already visited that location or if we hit the wall.
 * Same is done with all the possible correct directions.
 * 
 */

import java.util.*;
public class TheMaze {
    
    public static boolean hasPath(int[][] maze, int[] start, int[] destination)
    {
        if(maze == null || maze.length == 0) return false;

        //BFS

        Queue<int[]> q = new LinkedList<>();
        int m = maze.length;
        int n = maze[0].length;

        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        q.add(new int[]{start[0],start[1]});

        while(!q.isEmpty())
        {
            int[] curr = q.poll();

            for(int[] dir: dirs)
            {
                int r = curr[0];
                int c = curr[1];


                while(r>=0 && r<m && c>=0 && c<n && maze[r][c]!=1)
                {
                    r = r + dir[0];
                    c = c + dir[1];
                }

                r = r - dir[0];
                c = c - dir[1];

                if(maze[r][c]!=2)
                {
                    if(r == destination[0] && c == destination[1])
                    {
                        return true;
                    }

                    maze[r][c] = 2;
                    q.add(new int[]{r,c});
                }
            }
        }

        return false;

    }

    public static void main(String args[])
    {
        int[][] maze = {{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
        int[] start = {0,4};
        int[] destination = {4,4};

        System.out.println(hasPath(maze, start, destination));
    }
}
