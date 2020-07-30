<-----Recursive DFS solution-----> 
// Time Complexity: O(m*n) where m is num of cols and n is num of rows in the maze
// Space Complexity: O(min (m, n))

class Solution {
    int m, n;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze == null || maze.length == 0) return true;
        n = maze.length; m = maze[0].length;

        maze[start[0]][start[1]] = 2;
        return dfs(maze, start, destination);
    }

    private boolean dfs(int[][] maze, int[] start, int[] destination){
        
        if(start[0] == destination[0] && start[1] == destination[1]) return true;
        
        int dirs[][] = {{1,0},{-1,0},{0,1},{0,-1}};
        for(int [] dir: dirs){
            int r = start[0]; int c = start[1];

            while(r < n && r >=0 && c < m && c >=0 && maze[r][c] != 1){
                r += dir[0]; c += dir[1]; 
            }
            r -= dir[0]; c-= dir[1]; 

            if(maze[r][c] != 2){ 
                maze[r][c]=2;
                if(dfs(maze, new int [] {r,c}, destination)) return true;
            }

        }
        return false;
    }
}


<------BFS solution-----> 
// Time Complexity: O(m*n) where m is num of cols and n is num of rows in the maze
// Space Complexity: O(min (m, n))

class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze == null || maze.length == 0) return true;

        Queue< int[] > q = new LinkedList<>();
        int n = maze.length; int m = maze[0].length;

        q.add(start); 
        maze[start[0]][start[1]] = 2;
       int dirs[][] = {{1,0},{-1,0},{0,1},{0,-1}};

        while(!q.isEmpty()){
            int [] cur = q.poll(); 
            if(cur[0] == destination[0] && cur[1] == destination[1]) return true;

          for(int [] dir: dirs){  
            int r = cur[0]; int c= cur[1];

              while(r < n && r >=0 && c < m && c >=0 && maze[r][c] != 1){
                r += dir[0]; c += dir[1]; 
            }

            r -= dir[0]; c-= dir[1]; 

            if(maze[r][c] != 2){ 
                maze[r][c]=2;
                q.add(new int[] {r,c});
            }
          }

        }

        return false;
    }
}