//Time Complexity: O(mn * k) k is a constant (for the m+n in the while loop)
//Space Complexity: O(mn)

/*
 * Using BFS approach, create a queue and add the start point, we move in all the 4 directions till we hit a wall,
 * if we reach at a point where it matches the destination we return true.else we add the new position in the queue and mark it as visited.
 * at the end if we get a destinationw e return false;
 */
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int[][] dirs = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};

        Queue<int[]> q = new LinkedList<>();
        int m = maze.length, n = maze[0].length;
        q.add(start);
        //mark visited
        maze[start[0]][start[1]] = 2;
        while(!q.isEmpty())
        {
            int[] curr = q.poll();
            for(int[] dir: dirs)
            {
                
                int r = curr[0];
                int c = curr[1];
                while(r>= 0 && r < m && c >=0 && c < n && maze[r][c] !=  1)
                {
                    r += dir[0];
                    c += dir[1];
                }
                // step back
                r -= dir[0];
                c -= dir[1];
                if( r == destination[0] && c == destination[1])
                    return true;
                if(maze[r][c] == 0)
                {
                    q.add(new int[]{r,c});
                    maze[r][c] = 2;
                }
            }
        }

        return false;
    }
}

//Time Complexity: O(mn * k) k is a constant (for the m+n in the while loop)
//Space Complexity: O(mn)

/*
 * using DFS, we move in all the 4 directions till we hit a wall,
 * if we reach at a point where it matches the destination we return true.else return false
 */
class Solution {
    int[][] dirs ;
    int m , n;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        dirs = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
        m = maze.length;
        n = maze[0].length;
        if(start[0] == destination[0] && start[1]== destination[1])
            return true;

            return dfs(maze, start[0], start[1], destination[0], destination[1]);
    }

    private boolean dfs(int[][] maze, int i, int j, int destr, int destc)
    {
        //base
        if(maze[i][j]== 2)
            return false;
        if(i == destr && j == destc)
            return true;

        //logic

        maze[i][j] = 2;
        for(int[] dir: dirs)
        {
            int r = i, c = j;
            while(r >= 0 && r < m &&  c >= 0 && c < n && maze[r][c] != 1)
            {
                r += dir[0];
                c += dir[1];
            }
            r -= dir[0];
            c -= dir[1];

            if(dfs(maze,r,c,destr,destc))
                return true;

        }

        return false;
    }
}