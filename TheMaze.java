// Time Complexity : O(n*m) n - number of rows, m- number of cols in the input maze 
// Space Complexity : O(n*m) n - number of rows, m- number of cols in the input maze for Queue
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Used BFS and backtracking to return when hit by an obstacle.
// Store the each cell which is empty and move to next level using queue
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int n = maze.length;
        int m = maze[0].length;
        Queue<int[]> que = new LinkedList<>();
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        que.add(start);
        while(!que.isEmpty()){
            int[] cell = que.remove();
            if(cell[0] == destination[0] && cell[1] == destination[1])
                return true;
            for(int[] d:dirs){
                int r = cell[0];
                int c = cell[1];
                while(r<n && r>=0 && c<m && c>=0 && maze[r][c] !=1){
                    r = d[0]+r;
                    c = d[1]+c;
                }
                r = r-d[0];
                c = c-d[1];
                if(maze[r][c] !=2){
                    que.add(new int[]{r,c});
                    maze[r][c] = 2;
                }
            }
        }
        return false;
    }
}
