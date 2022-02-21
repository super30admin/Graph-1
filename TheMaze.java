import java.util.LinkedList;
import java.util.Queue;

// Time Complexity : Add : O(m+n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class TheMaze{
    public static void main(String[] args) {
       int[][]  maze = {{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
       int[] start = {0,4};
       int[] destination = {4,4};
       hasPath(maze, start, destination);
    }

    public static boolean hasPath(int[][] maze, int[] start, int[] destination) {
            if(maze == null || maze.length == 0)
                return false;

            int m = maze.length;
            int n = maze[0].length;

            int[][] dirs = new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};

            Queue<int[]> q = new LinkedList<>();
            q.add(start);

            while(!q.isEmpty()){  // T.C - O(m+n). S.C - O(m*n)
                int[] curr = q.poll();

                for(int[] dir: dirs){
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];
                    while(r>=0 && r<m && c>=0 && c<n && maze[r][c] != 1){
                        r = r + dir[0];  // keeps rolling until it hits wall i.e., 1
                        c = c + dir[1];
                    }
                    //step back from 1
                    r = r - dir[0];
                    c = c - dir[1];

                    if(r == destination[0] && c == destination[1]) // when it reaches destination
                        return true;

                    if(maze[r][c] != 2){
                        maze[r][c] = 2;
                        q.add(new int[]{r,c});
                    }
                }

            }

            return false;
        }
    }


