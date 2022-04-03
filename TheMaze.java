// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Create a queue and add start positions
// Run it till queue is not empty
// check all directions for current position
// Go to the walls using while loop
// If not already visited add to queue
// If queue element poped is same as location of destination return true

class Solution {
    int[][] directions = {{0,1},{0,-1},{-1,0},{1,0}};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start[0],start[1]});
        boolean visited[][] = new boolean[m][n];
        visited[start[0]][start[1]] = true;
        // int emptySpaces = 0;
        // for(int i = 0; i < m; i++){
        //     for(int j = 0; j < n; j++){
        //         if(maze[i][j] == 0)
        //             emptySpaces++;
        //     }
        // }
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            if(x == destination[0] && y == destination[1])
                return true;
            for(int[] dir: directions){
                int x1 = x + dir[0];
                int y1 = y + dir[1];
                while(x1>=0 && y1>= 0 && x1 < m && y1 < n && maze[x1][y1] == 0){
                    x1 += dir[0];
                    y1 += dir[1];
            }
            if(!visited[x1 - dir[0]][y1 - dir[1]]){
                q.add(new int[]{x1 - dir[0], y1 - dir[1]});
                visited[x1 - dir[0]][y1 - dir[1]] = true;
            }
        }
        }
        return false;
    }
}