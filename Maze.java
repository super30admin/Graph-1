//Time Complexity: O(mn)
//Space Complexity: O(mn) recursive stack

public class Maze {
    int m, n;
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze == null || maze.length == 0) return false;
        m = maze.length;
        n = maze[0].length;
        return dfs(maze, start, destination);
    }
    
    private boolean dfs(int[][] maze, int[] start, int[] destination){
        int i = start[0]; int j = start[1];
        
        if(i == destination[0] && j == destination[1]) return true;
        
        maze[i][j] = 2;
        for(int[] dir: dirs){
            int r = i; int c = j;
            while(r < m && r >= 0 && c < n && c >= 0 && maze[r][c] != 1){
                r += dir[0]; c += dir[1]; 
            }
            r -= dir[0]; c-= dir[1];
            if(maze[r][c] != 2 && dfs(maze, new int[]{r, c}, destination)) return true;
        }
        return false;
    }
}
