// Time Complexity : O(n*m) where n is the number of rows and m is the number of columns
// Space Complexity : O(n*m) for the queue and the modified maze array
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : understanding the ball rolling mechanism and ensuring the ball stops at the destination
// Your code here along with comments explaining your approach: used BFS to explore the maze. The ball can roll in four directions until it hits a wall. For each direction, I keep rolling the ball until it can't go further, then check if it has reached the destination. If not, I add the new position to the queue for further exploration. I also mark visited positions in the maze to avoid cycles.
class Solution {
    int[][] dirs;
    int m,n;
    
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        this.dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        this.m = maze.length;
        this.n = maze[0].length;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start[0], start[1]});
        maze[start[0]][start[1]] = -1;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int[] dir: dirs){
                int r = dir[0] + curr[0];
                int c = dir[1] + curr[1];

                while(r>=0 && c>=0 && r<m && c<n && maze[r][c] != 1){
                    r += dir[0];
                    c += dir[1];
                }

                r -= dir[0];
                c -= dir[1];

                if(r == destination[0] && c == destination[1]) return true;
                if(maze[r][c] != -1){
                    q.add(new int[]{r,c});
                    maze[r][c] = -1;
                }
            }
        }

        return false;
    }
}
