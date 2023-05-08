/*
Time Complexity - O(m * n)
Space Complexity - O(m * n) where m and n is the size of the input array maze.
Aproach - dfs
1. Start traversing from the start position by adding it to the queue. 
2. Mark the indices that are added to the queue as visited to avoid cycles and unnecessary travel.
2. Keep poping from the queue. For each position popped from queue do the following
    a. travel in all four directions until a wall is present or boundary is reached.
    b. for each direction cur position would have gone out of boundary, reset to prev poisition to get the next position to change direction.
    c. if the position obtained is not visited yet add it to queue.
    d. before doing steps a - c check if the destination is reached.
    
*/
class Solution {
    //dfs
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        
        if(maze == null || maze.length == 0)
            return false;
        
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        Queue<int []> queue = new LinkedList<>();
        int row = maze.length, col = maze[0].length;
        
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        
        visited[start[0]][start[1]] = true;
        queue.add(start);
        
        while(!queue.isEmpty()) {
            int[] curPos = queue.remove();
            if(curPos[0] == destination[0] && curPos[1] == destination[1])
                return true;
            for(int[] dir : directions) {
                int x = curPos[0] + dir[0];
                int y = curPos[1] + dir[1];
                while(isWithinBounds(x,y,row,col) && maze[x][y] == 0){
                    x += dir[0];
                    y += dir[1];
                }
                //by this time x and y values could have move out of bounday. 
                //fetch the prev value which represents the position that 
                //can be reached traveling in the 'dir' direction.
                x -= dir[0]; 
                y -= dir[1];
                if(!visited[x][y]){
                    //System.out.println(x + " " + y);
                    visited[x][y] = true;
                    queue.add(new int[]{x,y});
                }
            }
        }
        return false;
    }
    public boolean isWithinBounds(int x, int y, int row, int col){
        if(x < 0 || y < 0)
            return false;
        if(x >= row || y >= col)
            return false;
        return true;
    }
}
