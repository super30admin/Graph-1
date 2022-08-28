// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this: No

//dfs
class Solution {
    int [][] dirs;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length; int n = maze[0].length;
        dirs = new int [][] {{0,1}, {0,-1},{1,0},{-1,0}};
        return dfs(maze, start[0], start[1], destination, m, n);
    }
    private boolean dfs(int[][] maze, int i, int j, int[] destination, int m, int n){
        if(i == destination[0] && j == destination[1]) return true;
        maze[i][j] = 2;
        for(int [] dir: dirs){
            int r = i; int c = j;
            while(r >= 0 && c >= 0 && r < m && c < n && maze[r][c] != 1){
                r  += dir[0];
                c += dir[1];
            }
            r  -= dir[0];
            c -= dir[1];
            if(maze[r][c] == 0 && dfs(maze, r, c, destination, m, n))return true;
        }
        return false;
    }
}

/*
//bfs
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length; int n = maze[0].length;
        Queue<int []> q = new LinkedList<>();
        q.add(start);
        int [][] dirs = new int [][] {{0,1}, {0,-1},{1,0},{-1,0}};
        maze[start[0]][start[1]] = 2;
        while(!q.isEmpty()){
            int [] curr = q.poll();
            for(int [] dir: dirs){
                int i  = curr[0]; int j = curr[1];
                while(i >= 0 && j >= 0 && i < m && j < n && maze[i][j] != 1){
                    i += dir[0];
                    j += dir[1];
                }
                i -= dir[0];
                j -= dir[1];
                if(maze[i][j] != 2){
                    if(i == destination[0] && j == destination[1]) return true;
                    q.add(new int [] {i ,j});
                    maze[i][j] = 2;
                }
            }
        }
        return false;
    }
}
*/