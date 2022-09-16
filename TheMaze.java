// Time Complexity : O(m*n) + k * O(m+n) where m = number of rows, n = number of columns, k = number of 1's
// Space Complexity : O(m*n) where m = numebr of rows, n = number of columns
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//490. The Maze (Medium) - https://leetcode.com/problems/the-maze/
class Solution {
	
	//int[][] dirs;
	//int m, n;
	
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
    	
//    	if (start[0] == destination[0] && start[1] == destination[1]) return true;
//        
//        m = maze.length;
//        n = maze[0].length;
//        
//        dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
//        return dfs(maze, start, destination);
//    }
//    
//    private boolean dfs(int[][] maze, int[] start, int[] destination) {
//        // base
//        if (start[0] == destination[0] && start[1] == destination[1]) return true;
//        if (maze[start[0]][start[1]] == 2) return false;
//        
//        // logic
//        maze[start[0]][start[1]] = 2; // mark the cell as visited
//        
//        for (int[] dir : dirs) {
//            int row = start[0];
//            int col = start[1];
//            
//            while (row >= 0 && row < m && col >= 0 && col < n && maze[row][col] != 1) {
//                row += dir[0];
//                col += dir[1];
//            }
//            
//            // one step back
//            row -= dir[0];
//            col -= dir[1];
//
//            if (dfs(maze, new int[] {row, col}, destination)) return true;
//        }
//        
//        return false;
//    }
        
        if (start[0] == destination[0] && start[1] == destination[1]) return true;
        
        int m = maze.length, n = maze[0].length;
        int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int []> queue = new LinkedList<>();
        queue.add(start);
        
        maze[start[0]][start[1]] = 2; // mark the cell as visited
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            
            for (int[] dir : dirs) {
                int row = curr[0];
                int col = curr[1];
                
                while (row >= 0 && row < m && col >= 0 && col < n && maze[row][col] != 1) {
                    row += dir[0];
                    col += dir[1];
                }
                
                // come one dir back
                row -= dir[0];
                col -= dir[1];
                
                if (maze[row][col] != 2) {
                    if (row == destination[0] && col == destination[1]) return true;
                    
                    queue.add(new int[] {row, col});
                    maze[row][col] = 2;
                }
            }
        }
        
        return false;
    }
}