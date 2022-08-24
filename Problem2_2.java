//Time Complexity: O((m*n)*max(m,n)); where m is the no. of rows and n is the no. of columns
//Space Complexity: O(m*n)
//Code run successfully on LeetCode.

public class Problem2_2 {

    boolean result;
    int m, n;
    int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    
    public boolean hasPath(int[][] maze, int[] start, int[] destination)
    {
        if(maze == null || maze.length == 0)
            return false;
        
        m = maze.length;
        n = maze[0].length;
        
        maze[start[0]][start[1]] = 2;
        dfs(maze, start, destination);   
        return result;
    }
    
    private void dfs(int[][] maze, int[] start, int[] destination)
    {
         int k = start[0];
         int l = start[1];
    
        if(k == destination[0] && l == destination[1])
            {
                result = true;
                return;
            }
        
        if( k >= m || k < 0 || l >=n || l < 0)
            return;
        
        for(int[] dir : dirs)
        {
            int i = start[0];
            int j = start[1];
            
            while(i < m && i >=0 && j < n && j >=0 && maze[i][j] != 1)
            {
                i = i + dir[0];
                j = j + dir[1];
            }
            
            i = i - dir[0];
            j = j - dir[1];
            
            if(maze[i][j] == 0)
            {
                maze[i][j] = 2;
                dfs(maze, new int[] {i,j}, destination);
            }
        }
        
    }
}
