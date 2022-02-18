// Time Complexity : O(mn) ; worst case mn cells are added to queue and distance moved by cell (i.e while loop) is k - so its k * mn = O(mn)
// Space Complexity : O(mn) - BFS queue size
// Did this code successfully run on Leetcode : Yes

import java.util.LinkedList;
import java.util.Queue;

public class TheMaze {

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze == null || maze.length == 0) return false;
        int[][] dirs = new int[][] {{-1,0}, {1,0}, {0,-1}, {0,1}};
        int m = maze.length; int n = maze[0].length;

        if(start[0] == destination[0] && start[1] == destination[1]) return true;
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int[] dir : dirs){
                int r = curr[0];
                int c = curr[1];
                //Traverse till ball hits wall
                while( r >= 0 && r < m && c < n && c >= 0
                        && maze[r][c] != 1){
                    r += dir[0];
                    c += dir[1];
                }
                //As we have to stop before wall,
                //we need to step back by 1 step
                r -= dir[0];
                c -= dir[1];

                if(r == destination[0] && c == destination[1]) return true;
                //if node not visited, add to queue
                if(maze[r][c] != 2){
                    maze[r][c] = 2;
                    q.add(new int[]{r,c});
                }
            }
        }
        return false;
    }
}
