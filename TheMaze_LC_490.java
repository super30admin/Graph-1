import java.util.LinkedList;
import java.util.Queue;

/*
Approach - BFS
Time complexity - O(M*N)
Space Complexity - O(M*N)
Did this code successfully run on Leetcode :  Yes
Any problem you faced while coding this :  No
*/
public class TheMaze_LC_490 {
    int dir[][];
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        Queue<int[]> q = new LinkedList<>();
        int m = maze.length;
        int n = maze[0].length;
        maze[start[0]][start[1]] = 2;
        q.add(start);
        dir = new int[][] {{-1,0}, {1,0},{0,-1},{0,1}};

        while(!q.isEmpty()){
            int [] curr = q.poll();
            for(int [] dir : dir) {
                //stopage point
                int r = curr[0];
                int c = curr[1];
                while (r >=0 && r <m && c >=0 && c<n && maze[r][c] != 1){
                    r += dir[0];
                    c += dir[1];
                }
                //Step back
                r -= dir[0];
                c -= dir[1];
                if( r== destination[0] && c == destination[1]) return true;
                if(maze[r][c] != 2) {
                    q.add(new int[] {r,c});
                    maze[r][c] = 2;
                }
            }

        }
        return false;
    }
}

/*
Approach - DFS
Time complexity - O(M*N)
Space Complexity - O(M*N)
Did this code successfully run on Leetcode :  Yes
Any problem you faced while coding this :  No

class Solution {
    int dir[][];
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        dir = new int[][] {{-1,0}, {1,0},{0,-1},{0,1}};
        return helper(maze, start, destination, m ,n);
    }
    private boolean helper(int[][] maze, int[] start,int[] destination, int m, int n) {
        //base
        if(start[0] == destination[0] && start[1] == destination[1]){
            return true;
        }
        if(maze[start[0]][start[1]] == 2) return false;
        maze[start[0]][start[1]] = 2;

        //logic
        for(int [] dir : dir) {
            int r = start[0];
            int c = start[1];
            while(r >= 0 && c >= 0 && r <m && c < n && maze[r][c] != 1 ) {
                r += dir[0];
                c+= dir[1];
            }
            r-= dir[0];
            c-= dir[1];
            if(helper(maze, new int[]{r,c}, destination, m, n)) return true;
        }
        return false;
    }
} */