//TC - O(m*n)
//SC - O(m*n)

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
