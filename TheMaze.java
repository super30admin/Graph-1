// Time Complexity: O(nm * max(n,m)) where max(n,m) is number of times we travel in a direction 
// Space Complexity: O(nm)
// BFS
public class TheMaze {

    public boolean hasPath(int [][] maze, int []start, int [] end)
    {
        if(maze == null || maze.length == 0)
            return false;
        int m = maze.length, n = maze[0].length;
        int[][] dirs = new int[][]{{1,0},{-1,0}, {0, -1}, {0, 1}};
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        // mark start visited
        maze[start[0]][start[1]] = 2;
        while(!q.isEmpty())
        {
            int curr[] = q.pop();
            for(int [] dir: dirs) // start with one direction
            {
                int i = curr[0];
                int j = curr[1];

                // continue till you find a wall
                while(i < m && j < n && i >= 0 && j >= 0 && maze[i][j] != 1) 
                {
                   i = i + dir[0];
                   j = j + dir[1];
                }
                // we have stopped because we found a wall at current i and j or out of bound
                // reset i and j to last valid position, i.e undo last action
                i = i - dir[0];
                j = j - dir[1];

                // you found and wall && goal then it is your answer
                if(i == end[0] && j == end[1])
                    return true;

                if(maze[i][j] == 0) 
                {
                    maze[i][j] = 2; 
                    q.offer(new int[]{i, j});
                }
            }
        }
        return false;
    }
}

// Time Complexity: O(nm * max(n,m)) where max(n,m) is number of times we travel in a direction 
// Space Complexity: O(nm)
// DFS
public class TheMaze {
    int [][]dirs;
    public boolean hasPath(int [][] maze, int []start, int [] end)
    {
        if(maze == null || maze.length == 0)
            return false;

        int m = maze.length, n = maze[0].length;
        dirs = new int[][]{{1,0},{-1,0}, {0, -1}, {0, 1}};

        return dfs(maze, start, end);
    }

    private boolean dfs(int [][] maze, int []start, int[] end)
    {
        // base
        if(start[0] == end[0] && start[1] == end[1])
            return true;
        if(maze[start[0]][start[1]] == 2)
            return false;

        // logic
        maze[start[0]][start[1]] = 2;
        for(int dir[] : dirs) // select one direction
        {
            int i = start[0];
            int j = start[1];

            // keep going till boundary / wall
            while(i < m && j < n && i >= 0 && j >= 0 && maze[i][j] != 1)
            {
                i = i + dir[0];
                j = j + dir[1];
            }
             // we have stopped because we found a wall at current i and j or out of bound
            // reset i and j to last valid position, i.e undo last action
            i = i - dir[0];
            j = j - dir[1];

            // make recursive call only if unvisited
            if(maze[i][j] != 2 &&   dfs(maze, new int[]{i, j}, end)) 
            {
               return true;
            }
            
            return false;
        }
    }
}
