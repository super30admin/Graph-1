/*  approach: BFS  */
// TC = O(m*n)
// SC = O(m*n)

class Solution {
    int [][] dirs;
        int m,n;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        m = maze.length;
        n = maze[0].length;
        
        //null case
        if(maze== null || maze.length ==0) return false;
        
        dirs = new int[][] {{-1,0},{1,0},{0,-1},{0,1}};
        
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        maze[start[0]][start[1]] = 2;
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int[] dir : dirs){
                int i = curr[0];
                int j = curr[1];
                while(i>=0 & j>=0 && i<m &&j<n && maze[i][j] != 1){ //boundary check
                    i+=dir[0];
                    j+= dir[1];
                }
                //one step back to get the position of ball
                i-= dir[0];  
                j -= dir[1];
                if (maze[i][j] != 2){   //add only when it is not visited
                    if(i==destination[0] && j == destination[1]) return true;
                    q.add(new int[]{i,j});
                    maze[i][j] = 2;
                }
            }
        }
        return false;
    }
}


/*  approach: DFS  */
// TC = O(m*n)
// SC = O(m*n)
class Solution {
    int [][] dirs;
    int m,n;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        m = maze.length;
        n = maze[0].length;
        
        //null case
        if(maze== null || maze.length ==0) return false;        
        dirs = new int[][] {{-1,0},{1,0},{0,-1},{0,1}};
        return dfs(maze,start,destination);
    }
    
    private boolean dfs(int[][] maze, int[] curr, int[] destination){
        //base
        if(maze[curr[0]][curr[1]] == 2) return false;
        if (curr[0]== destination[0] && curr[1] == destination[1])  return true;
        
        //logic
        maze[curr[0]][curr[1]] = 2;
        for(int[] dir: dirs){
            int i = curr[0];
            int j = curr[1];
            while(i>=0 && j>=0 && i<m && j<n && maze[i][j] != 1){ //boundary check
                i+=dir[0];
                j+= dir[1];   
            }
            //one step back to get the position of ball
            i-= dir[0];  
            j -= dir[1];
            
            if(dfs(maze, new int[]{i,j}, destination)) return true;
        }
        return false;
    }
}
