// BFS
// TC: O(M*N) -> M, N : dimensions of maze
// SC: O(M*N) -> queue size
// Did it run successfully on Leetcode? : Yes
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if ( maze == null || maze.length == 0)
              return false;
          Queue<int[]> q = new LinkedList();
          q.add(start);
          int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
           int m = maze.length;
           int n = maze[0].length;
      
        // to mark the node visited, assign the value 2 to it
        maze[start[0]][start[1]] = 2;
        
        while (!q.isEmpty())
        {
            int[] cur = q.poll();
            
            // if cuurent node equals the destinatin, return true
            if (cur[0] == destination[0] && cur[1] == destination[1])
                return true;
            
            for ( int[] dir : dirs)
            {
                int i = cur[0];
                int j = cur[1];
                // go on in the current direction i and j go out of bounds or we encounter a wall
                while ( i >= 0 && j >= 0 && i < m && j < n && maze[i][j] != 1)
                {
                    i = i + dir[0];
                    j = j + dir[1];
                }
                // When the above while condition fails, i and j would have gone out of bounds so bring it back to stop point by decrementing them
                i = i - dir[0];
                j = j - dir[1];
                
                // If maze[i][j] is not visisted, then add it to the queue and mark it visited
                if (maze[i][j] != 2)
                {    q.add(new int[]{i ,j});
                         maze[i][j] = 2; 
                }
            }
         }
     return false;
    }
}


// DFS
// TC: O(M*N) -> M, N : dimensions of maze
// SC: O(M*N) -> Recursive stack
// Did it run successfully on Leetcode? : Yes
class Solution {
   int[][] dirs;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
         if ( maze == null || maze.length == 0)
              return false;
         dirs = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
         int m = maze.length;
         int n = maze[0].length;
         return dfs(maze, start, destination, m , n);
    }
    private boolean dfs(int[][] maze, int[] start, int[] destination, int m , int n)
    {
        // base
        if (start[0] == destination[0] && start[1] == destination[1])
            return true;
        // if the current node is already visited, return false
        if (maze[start[0]][start[1]] == 2)
            return false;
        
        // logic
         maze[start[0]][start[1]] = 2;
         for (int[] dir : dirs)
         {
             int i = start[0];
             int j = start[1];
             while ( i >= 0 && j >= 0 && i < m && j < n && maze[i][j] != 1)
             {
                 i = i + dir[0];
                 j = j + dir[1];
             }
             i = i - dir[0];
             j = j - dir[1];
             if (dfs(maze, new int[]{i, j}, destination, m , n))
                 return true;
         }
        return false;
    }
}
