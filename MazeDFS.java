// Time Complexity : O(m * n)
// Space Complexity : O(m * n)

class Solution {
    int[][] dirs;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze == null || maze.length == 0) return false;
        int m = maze.length; 
        int n = maze[0].length; 
        dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        return dfs(maze, start, destination, m, n);
    }

    private boolean dfs(int[][] maze, int[] start, int[] destination, int m, int n){
        //base
        if(start[0] == destination[0] && start[1] == destination[1]) return true;
        //logic
        maze[start[0]][start[1]] = 2; 
        for(int[] dir:dirs){
            int i = curr[0]; 
            int j = curr[1];  
            while(i < m && i >= 0 && j < n && j >= 0 && maze[i][j] != 1){
                i = i + dir[0]; 
                j = j + dir[1]; 
            }

            i = i - dir[0];
            j = j - dir[1]; 

            int[] newStart = new int[]{i, j};  
            if(maze[i][j] != 2 && dfs(maze, newStart, destination, m, n)){
                return true;
            }
        }
        return false;
    }
}