/*
Time complexity: O(mn)
space complexity : O(mn)

algorithm:
doing a bfs. 
Add starting node to the queue. Traverse in each direction but keep on traversing in single direction until hit the boundary.
Then mark the cell as visited and to queue.
At any point if the polled node from queue is equal to destination, then return true


*/
class Solution {
    
    int m;
    int n;
    int[][]dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        
        if(maze == null || maze.length ==0)return false;
        
        this.m = maze.length;
        this.n = maze[0].length;
        
        Queue<int[]>q = new LinkedList<>();
        q.add(start);
        maze[start[0]][start[1]] = 2; //marking it as visited
        
        while(!q.isEmpty()){
            int[]curr = q.poll();
            
            //check if we have reached destination point
            if(curr[0] == destination[0] && curr[1] == destination[1]){
                return true;
            }
            
            for(int[]d : dirs){
                int i = curr[0];
                int j = curr[1];
                //traverse in one direction until u hit the wall or some boundary
                while( i >= 0 && i < m && j >= 0 && j < n && maze[i][j] != 1){
                    i += d[0];
                    j += d[1];
                }
                //take step back
                i -= d[0];
                j -= d[1];
                if(maze[i][j] != 2){ //if not   visited
                    q.add(new int[]{i,j});
                    maze[i][j] = 2;
                }
                
            }
        }
        return false;
    }
}