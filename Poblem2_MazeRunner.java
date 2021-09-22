class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        //base
        if(maze==null || maze[0].length==0){
            return false;
        }
        //Algorithm: Starting from start position; t raverse
        int m = maze.length;
        int n = maze[0].length;
        
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        Queue<int []> q = new LinkedList<>();
        //initialise queue with start point
        q.add(new int[] {start[0], start[1]});
        //set to done/'2'
        maze[start[0]][start[1]] = 2;
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            // int[][] newPos = new
            for(int[] dir: dirs){
                int row = curr[0];
                int col = curr[1];
                //until we find 0's in neighbors
                while(row>=0 && row<m && col>=0 && col<n && maze[row][col]!=1){
                    row = row + dir[0];
                    col = col + dir[1];
                }
                row = row - dir[0];
                col = col - dir[1];
                if(row==destination[0] && col==destination[1]) return true;
                if(maze[row][col]!=2){
                    maze[row][col] = 2;
                    q.add(new int[]{row, col});
                }
            }
        }
        return false;
    }
}
