package Graph1;

//Time complexity : O(n^2)
//Space complexity: O(h) recursion stack
public class TheMaze {
    int m, n;
    int dirs[][] =  new int[][]{{0,1}, {1,0}, {-1,0}, {0, -1}};

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        m = maze.length;
        n = maze[0].length;
        return dfs(maze, start[0], start[1], destination);

    }

    private boolean dfs(int[][] maze, int i, int j, int[] dest){
        //base
        maze[i][j] = 2;
        if(i == dest[0] && j == dest[1])
            return true;
        //logic
        for(int[] dir : dirs){
            int row =  i + dir[0];
            int col = j + dir[1];
            while(row>=0 && row<m && col>=0 && col<n && maze[row][col] != 1){
                row += dir[0];
                col += dir[1];
            }
            row -= dir[0];
            col -= dir[1];
            if(maze[row][col] != 2){
                if(dfs(maze, row, col, dest))
                    return true;
            }

        }
        return false;
    }
}
