// Time Complexity : O(M*N)
// Space Complexity : O(M*N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
 /* 
 BFS :
 */
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
       if(maze == null || maze.length == 0) return false;

        int m = maze.length;
        int n = maze[0].length;
        int [][] dirs = new int[][] {{0,1}, {0,-1}, {1,0}, {-1, 0}};
        Queue<int[]> q = new LinkedList<>();
        maze[start[0]][start[1]] = 2;
        q.add(start);
        while(!q.isEmpty()){  
            int[] curr = q.poll();
            if(cur[0]==destinaton[0]n && curr[1]==destination[1]){
                return true;
            }
            for(int[] dir : dirs){
                int r = dir[0];
                int c = dir[1];
                while(r>=0 && r<m && c>=0 && c<n && maze[r][c]!=1){
                  r += dir[0];
                  c += dir[1];
                }
                r -= dir[0];
                c -= dir[1];
                if(maze[r][c]!=2){
                    maze[r][c] = 2;
                    q.add(start[r][c]);
                }
        }
        return false;
    }
}




// Time Complexity : O(M*N)
// Space Complexity : O(M*N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
 /* 
 DFS :
 */
class Solution {
    int m;
    int n ;
    int [][] dirs;

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
       if(maze == null || maze.length == 0) return false;

        m = maze.length;
        n = maze[0].length;
        dirs = new int[][] {{0,1}, {0,-1}, {1,0}, {-1, 0}};

        return dfs(maze,start, destination);
    }

    private boolean dfs(int[][] maze, int[] start, int[] destination){
        if(start[0] == destination[0] && start[1] == destination[1]){
            return true;
        }
        if(maze[start[0]][start[1]] == 2){
            return false;
        }

        maze[start[0]][start[1]] = 2;
        for(int[] dir : dirs){
            int r = dir[0];
            int c = dir[1];
            while(r>=0 && r<m && c>=0 && c<n && maze[r][c]!=1){
                r += dir[0];
                c += dir[1];
            }
            r -= dir[0];
            c -= dir[1];
            return dfs(maze, new int[][] {r,c}, destination);
        }
    }
}



