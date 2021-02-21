//Time complexity: O(mn)
//Space Complexity: O(mn)

class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze == null || maze.length == 0){
            return false;
        }
        
        int[][] dirs = {{0,1},{1,0},{0,-1}, {-1,0}};
        int m = maze.length; 
        int n = maze[0].length;
        Queue<int []> q = new LinkedList<>();
        q.add(new int[] {start[0], start[1]});
        maze[start[0]][start[1]] = 2;
        while(!q.isEmpty()){
            
            int[] curr = q.poll();
            
            if(curr[0] == destination[0] && curr[1] == destination[1]){
                return true; 
            }
            
            for(int[] dir: dirs){
                int i = curr[0]; 
                int j = curr[1];
                while(i >= 0 && j >= 0 && i < m && j < n && maze[i][j] != 1){
                    i += dir[0];
                    j += dir[1]; 
                }
                
                i -= dir[0];
                j -= dir[1];
                
                if(maze[i][j] != 2){
                    q.add(new int[]{i,j});
                    maze[i][j] = 2;
                }
            }
        }
        
        return false; 
        
    }
}