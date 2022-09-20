//TC : O(k*m*n)
//SC : O(m*n)
class Solution {
    int[][] dirs = {{0,1}, {1,0}, {-1,0}, {0,-1}};
    int m,n;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        //dfs
        m = maze.length;
        n = maze[0].length;
        return dfs(maze,start,destination);
        
        //bfs
        /*boolean result = false;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start[0]);
        queue.add(start[1]);
        maze[start[0]][start[1]] = 2;
        while(!queue.isEmpty()){
            int i = queue.poll();
            int j = queue.poll();
        if(i == destination[0] && j == destination[1]) return true;
        for(int[] dir : dirs){
            int nr = i;
            int nc = j;
            while(nr >= 0 && nr < maze.length && nc >= 0 && nc < maze[0].length && maze[nr][nc]!=1 ){
                nr += dir[0];
                nc += dir[1];
            }
             nr -= dir[0];
             nc -= dir[1];
            
            if(maze[nr][nc] !=2){    
                if(nr == destination[0] && nc == destination[1]) return true;
                queue.add(nr);
                queue.add(nc);
                maze[nr][nc] = 2;
            }      
        }
        }
        return result;*/
    }
    
    private boolean dfs(int[][] maze, int[] start, int[] destination){
         int i = start[0];
        int j = start[1];
        // Base
        if(i == destination[0] && j == destination[1]) return true;
        if(maze[i][j] == 2) return false;
        maze[i][j] = 2;
        // Logic
        for(int [] dir : dirs){
            int r = start[0];
            int c = start[1];
            while(r >= 0 && r < m && c>= 0 && c<n && (maze[r][c] == 0 || maze[r][c] == 2)){
                r += dir[0];
                c += dir[1];
            }
            // Bring it back to stopping point
            r -= dir[0];
            c -= dir[1];
            if(maze[r][c] != 2 && dfs(maze, new int [] {r,c}, destination)) return true;
        }
        return false;
    }
}
