///BFS

class Solution {
    //Time O(m*n)
    //Space O(m*n)
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze == null || maze.length == 0)
        {
            return false;
        }
        Queue<int[]> Q = new LinkedList<>();
        Q.add(start);
        maze[start[0]][start[1]] = 2;
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        while(!Q.isEmpty())
        {
            int[] temp = Q.poll();
            for(int[] dir : dirs)
            {
                int i = temp[0];
                int j = temp[1];
                while(i >= 0 && i < maze.length && j >= 0 && j < maze[0].length && maze[i][j] != 1)
                {
                    i = i + dir[0];
                    j = j + dir[1];
                }
                i = i - dir[0];
                j = j - dir[1];
                if(i == destination[0] && j == destination[1]) return true;
                if(maze[i][j] != 2)
                {
                    Q.add(new int[] {i,j});
                    maze[i][j] = 2;
                }
            }
        }
        return false;
    }
}



///DFS
class Solution {
    //Time O(m*n)
    //Space O(H)
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze == null || maze.length == 0)
        {
            return false;
        }
        return helper(maze , start[0] , start[1] , destination);
    }
    private boolean helper(int[][] maze , int row, int col, int[] destination)
    {
        //base
        if(row < 0 || row >= maze.length || col < 0 || col >= maze[0].length || maze[row][col] == 2)
        {
            return false;
        }
        //logic
        maze[row][col] = 2;
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        for(int[] dir : dirs)
        {
            int i = row ;
            int j = col;
            while(i >= 0 && i < maze.length && j >= 0 && j < maze[0].length && maze[i][j] != 1)
            {
                i = i + dir[0];
                j = j + dir[1];
            }
            i = i - dir[0];
            j = j - dir[1];
            if(i == destination[0] && j == destination[1]) return true;
            if(helper(maze , i , j , destination)) return true;
        }
        return false;
    }
}