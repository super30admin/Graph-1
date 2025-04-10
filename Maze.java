class Maze {
    int m,n;
    int[][] dirs;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze==null || maze.length==0)
        {
 return false;
        }
        m = maze.length;
        n = maze[0].length;
        dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        Queue<int[]> q = new LinkedList<>();
        if(start[0] == destination[0] && start[1]==destination[1])
        return true;
        q.add(start);
        maze[start[0]][start[1]]=2;
        while(!q.isEmpty())
        {
            int[] cur =q.poll();
            for(int[] dir: dirs)
            {
                //effective neighbour
                int nr = cur[0];
                int nc = cur[1];
                while(nr>=0 && nc>=0 && nr<m && nc<n && maze[nr][nc]!=1)
                {
                    nr+=dir[0];
                    nc+=dir[1];
                }
                //going back because we should not be on the obstacle
                nr-=dir[0];
                nc-=dir[1];
                if(nr== destination[0] && nc== destination[1])
                {
                        return true;
                }
                if(maze[nr][nc]!=2)
                {
                    q.add(new int[]{nr,nc});
                    maze[nr][nc]=2;
                }
            }
        }
        return false;
    }
 }
 

 //tc: O(m*n)
 //sc: O(m*n)
 