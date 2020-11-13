class Solution {
    int[][] maze;
    String destination;
    int[] xVals = new int[] {0,0,1,-1};
    int[] yVals = new int[] {1,-1,0,0};
    int[] oppositePos = new int[] {1,0,3,2};
    
    public String convertToCoordinateString(int[] loc) {
        return String.valueOf(loc[0]) + "," + String.valueOf(loc[1]);
    }
    
    
    public boolean helper(int[] currLoc, int prevDirection) {
        
        int nextX = currLoc[0] + xVals[prevDirection];
        int nextY = currLoc[1] + yVals[prevDirection];
        boolean isEdge = false;
        
        if (maze[currLoc[0]][currLoc[1]] == 2)
            return false;
        if (currLoc[0] == 0 || currLoc[1] == 0 || currLoc[0] == maze.length - 1 || currLoc[1] == maze[0].length - 1)
            isEdge = true;
        
        
        if (destination.equals(convertToCoordinateString(currLoc)) && (isEdge || (nextX >= 0 && nextY >= 0 && nextX < maze.length && nextY < maze[0].length && maze[nextX][nextY] == 1))) 
            return true;            
        
        
        
        if (isEdge || maze[nextX][nextY] == 1) {
            
            maze[currLoc[0]][currLoc[1]] = 2;
            
            for (int i = 0; i < xVals.length; i++) {
                if (prevDirection == i || oppositePos[prevDirection] == i)
                    continue;
                int x = currLoc[0] + xVals[i];
                int y = currLoc[1] + yVals[i];
                
                if (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] != 1){
                    if (helper(new int[]{x,y}, prevDirection))
                        return true;
                }
            } 
        } else {
            int[] nextLoc = new int[] {nextX, nextY};
            return helper(nextLoc, prevDirection);
        }
        
        return false;
        
        
    }
    
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        this.maze = maze;
        this.destination = convertToCoordinateString(destination);
        
        for (int i = 0; i < xVals.length; i++) {
                int x = start[0] + xVals[i];
                int y = start[1] + yVals[i];
                
                if (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] != 1){
                    if (helper(new int[]{x,y}, i))
                        return true;
                }
        } 
        
        for (int i = 0; i < maze.length; i++) {
            
            for (int j = 0; j < maze[0].length; j++) {
                System.out.print(maze[i][j]);
            }
            System.out.println();
            
        }
        return false;
        
    }
}
