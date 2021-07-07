//TC - O(m*n)
//SC - O(m*n)
//BFS

class Solution {
    
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        if(maze == null || m == 0) return false;
        int n = maze[0].length;
        
        Queue<int[]> q = new LinkedList();
        q.add(start);
        
        maze[start[0]][start[1]] = -1;
        
        int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        
        while(!q.isEmpty())
        {
            int[] curr = q.poll();
            
            for(int[] dir : dirs)
            {
                int r = curr[0];
                int c = curr[1];
                
                while(r + dir[0] >= 0 && r + dir[0] < m && c +dir[1] >= 0 && c + dir[1]< n && maze[r + dir[0]][c + dir[1]] != 1)
                {
                    maze[r][c] = -1;
                    r = r + dir[0];
                    c = c + dir[1];
                }
                
                if(destination[0] == r && destination[1] == c) return true;
                else if(r >= 0 && r < m && c >= 0 && c < n && maze[r][c] == 0)
                {
                    maze[r][c] = -1;
                    q.add(new int[]{r,c});
                }
            }
        }
        return false;
    }
}

//DFS
//TC - O(n)
//SC - O(n)
class Solution {
    int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    int m = 0;
    int n = 0;
    
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze == null || maze.length == 0) return false;
        
        m = maze.length;
        n = maze[0].length;
        
        return helper(maze, start, destination);
    }
    
    private boolean helper(int[][] maze, int[] s, int[] d)
    {
        //base
        if(d[0] == s[0] && d[1] == s[1]) return true;
        
        //logic
        maze[s[0]][s[1]] = 2;
        
        for(int[] dir : dirs)
        {
            int r = s[0];
            int c = s[1];
            
            while(r < m && r >= 0 && c < n && c>= 0 && maze[r][c] != 1)
            {
                r += dir[0];
                c += dir[1];
            }
            
            r -= dir[0];
            c -= dir[1];
            
            if(maze[r][c] == 0 && helper(maze, new int[]{r,c}, d)) return true;
        }
        
        return false;
    }
}
