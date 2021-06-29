class HasPath {
    //Time: O(m*n) where m = no. of rows and n = no. of columns
    //space: O(m*n)
    //Did it run successfully on leetcode: yes
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        
        if(maze==null || maze.length==0) return true;
        //if destination found in the begining
        if(start[0]==destination[0] && start[1]==destination[1]) return true;
        //que to store left, right, bottom or top most location where bal can stop
        Queue<int[]> q = new LinkedList<>();
        //initializing queue
        q.add(new int[]{start[0], start[1]});
        //marking start index as visited
        maze[start[0]][start[1]] = 2;
        //direction array to traverse top, right, bottom and left neighbour
        int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        //until queue is not empty
        while(!q.isEmpty()){
            //get current location
            int[] curr = q.poll();
           
            // move through the neighbour of current location
            for(int[] dir: dirs){
                //row and column for current location
                int r = curr[0];
                int c = curr[1];
                    
                //until current location is within the bound and wall is not rached
                while(r>=0 && r<maze.length && c>=0 && c<maze[0].length && maze[r][c]!=1){
                    //keep moving towards the direction
                    r = r + dir[0];
                    c = c + dir[1];
                }
                //reduce index to bring it to bounds
                r = r-dir[0];
                c = c-dir[1];
               //if destion if found
                if(r == destination[0] && c == destination[1]) return true;
                //if current location is not visited
                if(maze[r][c]!=2){
                  //add current location to queue
                    q.add(new int[]{r,c});
                    //mark current location as visited
                    maze[r][c] = 2;
                }
              
            }
            
        }
        return false;
            
    }
    
    
}