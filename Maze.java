//The Maze
// TC O(M*N) SC O(M*N)
// DFS Implementation  
class Solution {
    int m, n;
    int [][] dirs;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0) {
            return false;
        }   
        Queue<int[]> q = new LinkedList<>();
        dirs = new int [][] {{0,1}, {1,0}, {0,-1}, {-1,0}};
        m = maze.length;
        n = maze[0].length;
        return dfs(maze, start, destination);
    }
     private boolean dfs(int [][]maze, int [] start, int [] destination) {
         if (start[0] == destination[0] && start[1] == destination[1]){
             return true;
         }
        
         maze[start[0]][start[1]] = 2;
         for (int [] dir : dirs) {
             int i = start[0];
             int j = start[1];
             while (i >=0 && j >= 0 && i < m && j < n && maze[i][j] != 1) {
                 i = i + dir[0];
                 j = j + dir[1];
             }
             i = i - dir[0];
             j = j - dir[1];
             
             if (maze[i][j] != 2) {
                 if (dfs(maze, new int[]  {i,j}, destination)){
                     return true;
                 }
             }
         }
         return false;
     }
}

// BFS Implementation
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0) {
            return false;
        }   
        Queue<int[]> q = new LinkedList<>();
        int [][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        int m = maze.length;
        int n = maze[0].length;
        q.add(start);
        maze[start[0]][start[1]] = 2;
        while(!q.isEmpty()) {
            int [] curr = q.poll();
            if (curr[0] == destination[0] && curr[1] == destination[1]) {
                return true;
            }
            for (int [] dir : dirs) {
                int i = curr[0];
                int j = curr[1];
                while(i>=0 && j>=0 && i <m && j <n && maze[i][j] != 1) {
                    i = i + dir[0];
                    j = j + dir[1];
                }
                i = i - dir[0];
                j = j - dir[1];
                if (maze[i][j] != 2) {
                    q.add(new int [] {i,j});
                    maze[i][j] = 2;
                }
            }
        }
        return false;
    }
}
