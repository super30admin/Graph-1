Time Complexity: O(mn). m is the number of rows and n is the number of columns
SC: O(mn)

public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        
        int[][] dirs = new int[]{
            {-1,0},
            {1,0},
            {0,-1},
            {0,1}
        };
        int rowLength = maze.length;
        int colLength = maze[0].length;
        
        Queue<int[]> q = new Queue<>();
        q.add(start);
        
        maze[start[0]][start[1]]=2;
        
        while(!q.isEmpty()){
            int topArray = q.poll();
            
            int row = topArray[0];
            int column = topArray[1];
            
            if(row==destination[0] && column==destination[1]) return true;
            
            
            for(int f=0;f<dirs.length;f++){
                while(row>=0 && row<rowLength&& column>=0 && column<colLength
                 && maze[row][column]!=1){
                    
                row = row+dirs[0];
                column+=dirs[1];
                    
                }
                row = row-dirs[0];
                column-=dirs[1];
                
                if(maze[row][column]!=2){
                    maze[row][column]=2;
                    q.add(new int[]{row,column});
                }
                
            }
            
                
            }
           
        return false;
            
        }
