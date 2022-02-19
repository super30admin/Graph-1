// TC: O(mn)
// SC: O(mn)
class Solution {
    int[][] dirs;
    int m; int n;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze == null || maze.length == 0) return false;
        dirs  = new int[][] {{-1,0}, {1,0}, {0,-1}, {0,1}};
        m = maze.length; n = maze[0].length;
        if(start[0] == destination[0] && start[1] == destination[1] ) return true;
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()){
            int [] curr = q.poll(); //poll() removes first element from the queue 
            for(int[] dir : dirs){
                int row = curr[0];
                int col = curr[1];
                while(row >= 0 && row < m && col >= 0 &&col < n && maze[row][col] != 1){ //till where we can move
                    row += dir[0];
                    col += dir[1];
                }
                //one step back
                //bcz it ll reach a hurdle i.e at 1 or corner so we need to go one step back
                row -= dir[0];
                col -= dir[1];
                
                //if we reach destination
                if(row == destination[0] && col == destination[1]) return true;
                
                //if not visited add to queue
                if(maze[row][col] != 2){
                    maze[row][col] = 2;
                    q.add(new int[] {row,col});
                     
                }
            }
            
            
        }
        
        return false;
    }
}