class Maze {

     /**
     * Time complexity: O(M*N) where M and N are dimensions of maze
     * Space complexity: O(M*N) where M and N are dimensions of maze
     * 
     * Approach:
     * 1. For every person calculate the number of people trusting him and number of people trusted
     * by him.
     */

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        
        if(maze == null || maze.length == 0)
            return false;
        
        if(start[0] == destination[0] && start[1] == destination[1]){
            return true;
        }
        
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        maze[start[0]][start[1]] = 2;
        
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            if(curr[0] == destination[0] && curr[1] == destination[1]) {
                return true;
            }
            
            for(int[] dir: dirs) {
                int r = curr[0];
                int c = curr[1];
                
                while(r >= 0 && c >= 0 && r < maze.length && c < maze[0].length && maze[r][c] != 1){
                    r += dir[0];
                    c += dir[1];
                }
                
                r -= dir[0];
                c -= dir[1];
                
                if(maze[r][c] != 2){
                    maze[r][c] = 2;
                    q.add(new int[]{r, c});
                }
            }
            
        }
        
        return false;
        //  return dfs(maze, start, destination);
    }


    // private boolean dfs(int[][] maze, int[] start, int[] destination) {
    //     if(start[0] == destination[0] && start[1] == destination[1]) {
    //         return true;
    //     }
        
    //     int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
    //     for(int[] dir: dirs) {
    //         int r = start[0];
    //         int c = start[1];

    //         while(r >= 0 && c >= 0 && r < maze.length && c < maze[0].length && maze[r][c] != 1){
    //             r += dir[0];
    //             c += dir[1];
    //         }

    //         r -= dir[0];
    //         c -= dir[1];

    //         if(maze[r][c] != 2){
    //             maze[r][c] = 2;
    //             if(dfs(maze, new int[]{r, c}, destination))
    //                 return true;
    //         }
    //     }
        
    //     return false;
    // }
}