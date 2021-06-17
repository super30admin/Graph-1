// Time Complexity : O(M*N)
// Space Complexity : O(M*N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze == null || maze.length == 0) return true;
        int m = maze.length;
        int n = maze[0].length;
        int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        maze[start[0]][start[1]] = 2;
        while(!q.isEmpty()){
            int[] xy = q.poll();
            
            for(int[] dir : dirs){
                int x = xy[0]+dir[0];
                int y = xy[1]+dir[1];
                while(x>=0 && y>=0 && x<m && y<n && maze[x][y] !=1){
                    x += dir[0];
                    y += dir[1];
                }
                x-= dir[0];
                y-= dir[1];
                if(x == destination[0] && y == destination[1]) return true;
                if(maze[x][y]!=2){
                    maze[x][y] = 2;
                    q.add(new int[]{x,y});
                }
            }
            
        }
        return false;
    }
}
