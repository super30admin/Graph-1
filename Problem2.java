// Time:O(mn)
// Space: O(mn)

class Solution {
    boolean res = false;
    int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];

       res =  backtrack(maze,visited,  start[0],  start[1],destination[0], destination[1]);
        return res;
    }

    private boolean backtrack(int[][] maze,boolean[][] visited, int m , int n, int dr, int dc){
        //
        if(visited[m][n]){
            return false;
        }
        if(m ==dr && n == dc){
            return true;
        }
        visited[m][n] = true;

        for(int[] dir: dirs){
            int r   = dir[0]+ m;
            int c  = dir[1] + n;
            while(r>=0 && c>=0 && r< maze.length && c<maze[0].length && maze[r][c]!=1)
           {
               r+= dir[0];
               c+= dir[1];
            }
            
            r= r-dir[0];
            c= c-dir[1];
            if(backtrack(maze,visited, r,c, dr, dc)) return true;
            // maze[r][c] = temp;
        }
        return false;

    }
}