// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length; int n = maze[0].length;
        Queue<int []> q = new LinkedList<>();
        if(start[0] == destination[0] && start[1] == destination[1])
            return true;
        int[][] dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        q.add(start);
        while(!q.isEmpty()){
            int[] curr = q.poll();
            r = curr[0]; c = curr[1];
            for(int[] dir : dirs){
                while(r < m && r >= 0 && c < n && c >= 0 && maze[r][c] != 1 ){
                    r += dir[0];
                    c += dir[1];
                }
                r -= dir[0];
                c -= dir[1];
                if(maze[r] == destination[0] && maze[c] == destination[1])
                    return true;
                if(maze[r][c] != 2)
                    q.add(new int[]{r,c});
                maze[r][c] = 2;

            }
        }
        return false;
    }
}