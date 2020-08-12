/*
Time complexity : O(mn) Complete traversal of maze in the worst case. where m is the number of rows and n is number coloumns of the maze.
Space complexity : O(1) no extra space is used
*/
public class Solution {
    int row, col;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        row = maze.length;
        col = maze[0].length;
       // return dfs(maze, start, destination);
        return bfs(maze, start, destination);
    }
    public boolean dfs(int[][] maze, int[] start, int[] destination) {
        //checking if we hv reached the desination
        if (start[0] == destination[0] && start[1] == destination[1]) 
            return true;
        
        //if this starting point was already considered. skip that else we would run into infinite loop
        if (maze[start[0]][start[1]] == 2) 
            return false;
        
        //mark visited
        maze[start[0]][start[1]] = 2;
        
        int [][] dirs = {{-1,0}, {0,-1}, {1,0}, {0,1}};
        //explore all direction
        for(int [] dir : dirs){
            int r= start[0], c = start[1];
            
            while(isValidIndex(r,c) && (maze[r][c] == 0 || maze[r][c] == 2)){
                r= r+ dir[0];
                c= c+ dir[1];
            }
            r = r- dir[0];
            c = c- dir[1];
            //doing depth first traversal in all the direction 
            if(maze[r][c] != 2 && dfs(maze, new int[]{r,c}, destination)) 
                return true;
        }
        return false;
    }
    private boolean isValidIndex(int r, int c){
        return r>=0 && c>=0 && r< row && c < col;
    }
    
    private boolean bfs(int[][] maze, int[] start, int[] destination){
        Queue<Cell> queue = new LinkedList<>();
        //adding starting point in queue. lets start bfs from here
        queue.add(new Cell(start[0], start[1]));
        maze[start[0]][start[1]] = 2;
        while(!queue.isEmpty()){
            Cell cell = queue.remove();
            //we have reached the destination
            if (cell.x == destination[0] && cell.y == destination[1])
                return true;
            //explore all neighbors
            int [][] dirs = {{-1,0}, {0,-1}, {1,0}, {0,1}};
            for(int [] dir : dirs){
                int r= cell.x, c = cell.y;
                while(isValidIndex(r,c) && (maze[r][c] == 0 || maze[r][c] == 2)){
                    r= r+ dir[0];
                    c= c+ dir[1];
                }
                r = r- dir[0];
                c = c- dir[1];
                //check if new position is visited. If not visited process that cell
                if(maze[r][c] != 2){
                    queue.add(new Cell(r,c));
                    maze[r][c] =2;
                }
            }
        }
        return false;
    }
    class Cell{
        int x, y;
        public Cell(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
