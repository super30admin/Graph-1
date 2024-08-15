class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int[][] dir = {{0,-1},{0,1},{-1,0},{1,0}};


        Queue<int[]> q = new LinkedList<>();

        q.add(start);
        maze[start[0]][start[1]] = 2;
        while(!q.isEmpty()){
            int[] x = q.poll();
            for(int[] d : dir){
                int nrow = x[0] ;
                int ncol = x[1] ;
                while(nrow + d[0] >= 0 && nrow + d[0] < maze.length && ncol + d[1] >= 0 && ncol + d[1] < maze[0].length && maze[nrow + d[0]][ncol + d[1]]!=1  ){

                
                    nrow = nrow + d[0];
                    ncol = ncol + d[1];
                    System.out.println(nrow + "+" + ncol + "X pop is " + x[0] + "+" + x[1]);
                    
                }
                if(nrow == destination[0] && ncol == destination[1]) return true;
                int[] npos = {nrow,ncol};
                if(maze[nrow][ncol] ==0){
                    maze[nrow][ncol] = 2;

                    // System.out.println(nrow + "+" + ncol + "X pop is " + x[0] + "+" + x[1]);
                    q.add(npos);

                }

            }
        }

        return false;
        
    }
}