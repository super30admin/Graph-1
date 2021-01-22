// Time Complexity : O(m * n)
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA


// Your code here along with comments explaining your approach

// We start at the start position and traverse using BFS.
// We traverse in all 4 directions till we reach wall or boundary
// Once traversal is completed for a position, marks its value to 2
// Continue traversal similarly till we find the destination

class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        
        if(maze == null || maze.length == 0 ) return false;
        
        Queue<int[]> q = new LinkedList<>();
        
        int m = maze.length, n = maze[0].length;
        
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        q.add(start);
        
        maze[start[0]][start[1]] = 2;
        
        while(!q.isEmpty()) {
            
            int[] curr = q.poll();
            
            if(curr[0] == destination[0] && curr[1] == destination[1]) {
                return true;
            }
            
            for(int[] dir: dirs) {
                int i = curr[0];
                int j = curr[1];
                
                while(i >= 0 && i < m && j >= 0 && j < n && maze[i][j] != 1) {
                    i += dir[0];
                    j += dir[1];
                }
                i = i - dir[0];
                j = j - dir[1];
                
                if(maze[i][j] != 2) {
                    q.add(new int[] {i, j});
                    maze[i][j] = 2;
                }
                
            }
        }
        return false;
    }
}