//Time complexity O(n)
//Space complexity O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        
        if(maze.length == 0 || start.length == 0 || destination.length == 0){
            
            return false;
            
        }
        int r = maze.length;
        int c = maze[0].length;
        Queue<Integer> q1 = new LinkedList<>();
        
        q1.add(start[0]);
        q1.add(start[1]);
        maze[start[0]][start[1]] = 2;
        int[] dirX = new int[]{0,1,-1,0};
        int[] dirY = new int[]{-1,0,0,1};
        
        while(!q1.isEmpty()){
            
            int i = q1.poll();
            int j = q1.poll();
            
           
            for(int k = 0; k < 4; k ++){
                
                int tempX = i + dirX[k];
                int tempY = j + dirY[k];
                
                if(tempX < r && tempY < c && tempX >= 0 && tempY >=0 && maze[tempX][tempY] != 1){
                  while((tempX < r && tempY < c && tempX >= 0 && tempY >=0 && maze[tempX][tempY] != 1)){
                    tempX = tempX + dirX[k];
                    tempY  = tempY + dirY[k];
                  }  
                    tempX =  tempX - dirX[k];
                    tempY = tempY - dirY[k];
                    
                     if(tempX == destination[0] && tempY == destination[1]){
                
                return true;
            }
            
                   if(maze[tempX][tempY] != 2){
                       
                       maze[tempX][tempY] = 2;
                       q1.add(tempX);
                       q1.add(tempY);
                       
                   } 
                }
            }
        }
        return false;
    }
}