//Time Complexity: O((m*n)*max(m,n)); where m is the no. of rows and n is the no. of columns
//Space Complexity: O(m*n)
//Code run successfully on LeetCode.

public class Problem2_1 {

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        
        if(maze == null || maze.length == 0)
            return false;
        
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        
        int m = maze.length;
        int n = maze[0].length;
        
        q.add(new int[] {start[0],start[1]});
        
        maze[start[0]][start[1]] = 2;
        while(!q.isEmpty())
        {
            int[] curr = q.poll();

            for(int[] dir : dirs)
            {
                int i = curr[0];
                int j = curr[1];
                
                while(i < m && i >=0 && j < n && j >=0 && maze[i][j] != 1)
                {
                    i = i + dir[0];
                    j = j + dir[1];
                }
                
                i = i - dir[0];
                j = j - dir[1];
                
                if(i == destination[0] && j == destination[1])
                {
                    return true;
                }
                else if(maze[i][j] == 0)
                {
                    maze[i][j] = 2;
                    q.add(new int[] {i,j});
                }
            } 
        }
        return false;
    }
}
