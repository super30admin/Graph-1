    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/the-maze/
    Time Complexity for operators : o(m*n) 
    Extra Space Complexity for operators : o(m*n) 
    Did this code successfully run on Leetcode : NA
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : 
        # Optimized approach: 
                              
            # 1. 
                    A) Create  directions and visited array to keep the track of root.
                    B) In helper function, if Visited array is true that means we traversed this path already then just return false.
                    C) If this is true start[0] == destination[0] && start[1] == destination[1] then return true
                    D) Now travser the according to directions array and the call maze function recursively.
                    E) In the recursive call there is just change  of start point according to directions array.
                    F) At the  end, return result.
    */  

class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        
        int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        
        boolean[][] visited = new boolean[maze.length][maze[0].length];

        return helper(maze, start, destination, directions, visited);
        
    }
    
    private boolean helper(int[][] maze, int[] start, int[] destination, int[][] directions, boolean[][] visited){
        
        if(visited[start[0]][start[1]]) return false;
        
        if(start[0] == destination[0] && start[1] == destination[1])
            return true;
        
        visited[start[0]][start[1]] = true;
        boolean result = false;
        for(int dirs[] : directions){
            int x = start[0] + dirs[0];
            int y = start[1] + dirs[1];
            while ( 0 <= x && x < maze.length && 0 <= y && y < maze[0].length && maze[x][y] == 0) {
                x += dirs[0];
                y += dirs[1];
            }   
            result = result || helper(maze, new int[]{ x - dirs[0], y - dirs[1]}, destination, directions, visited);
        }
        
        return result;
    }
}