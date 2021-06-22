// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

//Time Complexity - O(mn) since in worst case scenario we will be iterating through the entire matrix
//Space Complexity - O(n) since we are using an extra Queue

class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze == null || maze.length == 0) return true;
        int m = maze.length;
        int n = maze[0].length;
        int[][] dirs = {{0,1}, {1,0}, {0, -1}, {-1, 0}};
        Queue<int []> q = new LinkedList<>();
        maze[start[0]][start[1]] = 2;
        q.add(new int[]{start[0], start[1]});
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int[] dir : dirs){
                int i = curr[0];
                int j = curr[1];
                //Trace along until the obstacle in a certain direction
                while(i >= 0 && i < m && j >= 0 && j < n && maze[i][j] != 1){
                    i = i + dir[0];
                    j = j + dir[1];
                }
                //Come back from the obstacle 
                 i = i - dir[0];
                 j = j - dir[1];
                if(i == destination[0] && j == destination[1]) return true;
                if(maze[i][j] != 2){ //If not visited, then add to the queue
                    q.add(new int[] {i, j});
                    maze[i][j] = 2; // Mark the current as visited
                }
            }
        }
        
        return false;
    }
}