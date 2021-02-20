class TheMaze {
    
    int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    // BFS
    // Time : O(N*M) | touching all boxes once
    // Space : O(N*M) | Queue can grow upto M * N
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze == null) return false;
        
        int m = maze.length;
        int n = maze[0].length;
        
        Queue<int[]> que = new LinkedList<>();
        maze[start[0]][start[1]] = 2;
        que.add(new int[]{start[0],start[1]});
        
        while(!que.isEmpty()){
            int[] curr = que.poll();
             
            if(curr[0] == destination[0] && curr[1] == destination[1]){
                return true;
            }
            
            for(int[] dir : dirs){
                int i = curr[0];
                int j = curr[1];  
                       
                while(i >= 0 && j >=0 && i < m && j < n && maze[i][j] != 1){
                     i += dir[0];
                     j += dir[1];
                }
                
                i -= dir[0];
                j -= dir[1];
                if(maze[i][j] != 2){
                   que.add(new int[]{i,j});
                    maze[i][j] = 2;
                }
     
            }

        }
        return false;
    }

    // DFS
    // Time : O(N*M) | touching all boxes once
    // Space : O(N*M) | Queue can grow upto M * N
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze == null) return false;
        
        int m = maze.length;
        int n = maze[0].length;
        
        return dfs(maze, start, destination, m, n);
    }
    
    private boolean dfs(int[][] maze, int[] start, int[] destination, int m, int n){
        if(maze[start[0]][start[1]] == 2) return false;
        if(start[0] == destination[0] && start[1] == destination[1]) return true;
        
        maze[start[0]][start[1]] =2;
        
        for(int[] dir : dirs ){
            int i = start[0];
            int j = start[1];
            
            while(i >= 0 && j >= 0 && i < m && j < n && maze[i][j] != 1){
                i += dir[0];
                j += dir[1];
            }
            
            i -= dir[0];
            j -= dir[1];
            
            if(dfs(maze, new int [] {i,j}, destination, m, n)){
                return true;
            }
        }
        
        return false;
    }
// 
//    figure out whats wrong
//     private boolean dfs(int[][] maze, int i, int j, int[] destination){
//             if(maze[i][j] == 2 ) return false;
//             if(i == destination[0] && j == destination[1]){
//                return true;
//             }
            
//             maze[i][j] = 2;
//                 // logic
//                 for(int[] dir : dirs){
                    
//                     while(i >= 0 && j >=0 && i < maze.length && j < maze[0].length && maze[i][j] != 1){
//                         i += dir[0];
//                         j += dir[1];
                        
//                     }
                    
//                     i -= dir[0];
//                     j -= dir[1];
                    
//                     if(dfs(maze, i, j, destination)){
//                        return true;
//                     }
                    
        
            
//             }
        
//         return false;
//     }
    
    
}
