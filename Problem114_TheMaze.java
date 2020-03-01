//Time Complexity: O(m*n)
//Space Complexity: Auxillary stack is used
//DFS

class Solution {
    int m, n;
    //direction array
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        //base case
        if(maze == null || maze.length == 0)
            return false;
        
        m = maze.length;
        n = maze[0].length;
        return dfs(maze, start, destination);
    }
    
    private boolean dfs(int[][] maze, int[] start, int[] destination){
        int i = start[0]; int j = start[1];
        //base condition
        if(i == destination[0] && j == destination[1])
            return true;
        //1st node -> start is visited
        maze[i][j] = 2;
        //in every direction
        for(int[] dir : dirs){
            int row = i;
            int col = j;
            //if the ball is in bounds and there is no wall
            while(row >= 0 &&  row < m && col >=0 && col < n && maze[row][col] != 1){
                row += dir[0];  //explore rows
                col += dir[1];  //explore cols
            }
            //subtract 1 if there is a wall; to get back in place
            row -= dir[0];
            col -= dir[1];
            //if the node is not visited && dfs is still taking place for row and col
            //i.e. ball still not stopped
            if(maze[row][col] != 2 && dfs(maze, new int[]{row,col}, destination)){
                return true;
            }
            
        }
        return false;
    }
}

/******************************************************************************* */
//BFS
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        //base case
        if(maze == null || maze.length == 0)
            return false;
        
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        int m = maze.length;
        int n = maze[0].length;
        //creating que to store all adjacent available path
        Queue<int[]> q = new LinkedList<>();
        //add first node to queue
        q.add(start);
        //mark first node entered visited
        maze[start[0]][start[1]] = 2;
        //while q is not empty
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int i = curr[0];
            int j = curr[1];
            //if i and j matches destination coordinates; return true
            if(i == destination[0] && j == destination[1])
                return true;
            //else go over all direction
            for(int[] dir : dirs){
                int r = i;
                int c = j;
                //check all edge cases and if there is no wall
                while(r >= 0 && r < m && c >= 0 && c < n && maze[r][c] != 1){
                    //increment row and column
                    r += dir[0];
                    c += dir[1];
                }
                //decrement if found a wall by 1 value
                r -= dir[0];
                c -= dir[1];
                //if node not visited
                if(maze[r][c] != 2){
                    //add the node as new node into queue to process 
                    //and mark it visited 
                    q.add(new int[]{r,c});
                    maze[r][c] = 2;
                }
            }
        }
        return false;
        
    }
}