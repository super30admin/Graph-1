//BFS
//Time Complexity: O(mn * k) k is a constant which will be dropped
//Space Complexity: O(mn)

/*
 * we move to neighbours of each element until we can and mark them
 * visited. if we reach the destination we return true. if the 
 * queue is empty we return false.
 */

public boolean hasPath(int[][] maze, int[] start, int[] destination) {
    int m = maze.length;
    int n = maze.length;
    int[][] dirs = new int[][] {{1,0}, {0,1}, {0,-1}, {-1,0}};
    Queue<int[]> q = new LinkedList<>();
    q.add(start);
    maze[start[0]] [start[1]] = 2;
    
    while(!q.isEmpty()){
        int[] curr = q.poll();
        for (int[] dir: dirs){
           int nr = curr[0] + dir[0];
           int nc = curr[1] + dir[1];
           while(nr >= 0 && nc >= 0 && nr < m && nc < n && maze[nr][nc] != 1){
               nr += dir[0];
               nc += dir[1];
           }
           nr -= dir[0];
           nc -= dir[1];
           if(nr == destination[0] && nc == destination[1]) return true;
           if(maze[nr][nc] == 0){
               q.add(new int[] {nr, nc});
               maze[nr][nc] = 2;
           }
        }
    }
    return false;
}

//DFS
//Time Complexity: O(mn * k) k is a constant which will be dropped
//Space Complexity: O(mn)

/*
 * here we go to the very depth and mark it visited. if it is already 
 * visited then we return false. if it is the destination return true.
 * 
 */

 static int[][] dirs;
    static int m;
    static int n;
     public static boolean hasPath(int[][] maze, int[] start, int[] destination) {
         m = maze.length;
         n = maze.length;
         dirs = new int[][] {{1,0}, {0,1}, {0,-1}, {-1,0}};
         return dfs(maze, start[0], start[1], destination[0], destination[1]);
     }
     public static boolean dfs(int[][] maze, int i, int j, int destr, int destc){
         //base
         if(maze[i][j] == 2) return false;
         if(i == destr && j == destc) return true;
         
         //logic
         maze[i][j] = 2;
         for(int[] dir: dirs){
             int r = i;
             int c = j;
             while(r >=0 && c >= 0 && r < m && c < n && maze[r][c] != 1){
                r += dir[0];
                c += dir[1];    
             }
             r -= dir[0];
             c -= dir[1];
             if(dfs(maze, r, c, destr, destc)) return true;
         }
         return false;
     }