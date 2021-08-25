package Graph1;

import java.util.LinkedList;
import java.util.Queue;

public class TheMaze {
    /* Created by palak on 8/24/2021 */

    /**
     Time Complexity: O(M*N * Max(M, N))
     Space Complexity: O(M * N)
     */
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze == null)    return false;
        int m = maze.length;
        int n = maze[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        maze[start[0]][start[1]] = 2;
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int dirs[][] = new int[][] {{0,1},{1,0},{0,-1},{-1,0}};
            for(int[] dir: dirs) {
                int i = curr[0];
                int j = curr[1];
                while(i < m && i >= 0 && j < n && j >= 0 && maze[i][j] != 1) {
                    i += dir[0];
                    j += dir[1];
                }
                i -= dir[0];
                j -= dir[1];
                if(i == destination[0] && j == destination[1])  return true;
                if(maze[i][j] != 2) {
                    q.add(new int[]{i, j});
                    maze[i][j] = 2;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
