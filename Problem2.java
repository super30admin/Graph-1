// Time Complexity - O(m*n) for tarversing through the entire maze with m rows and n columns worst case
// Space Complexity - O(m*n) for visited array
// Below is the BFS solution 

class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        // Boolean visited array to keep track of not getting into an infinite loop
        boolean[][] visited = new boolean[m][n];
        visited[start[0]][start[1]] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        while(!q.isEmpty()){
            int[] curr = q.poll(); // The position from the queue
            if(curr[0] == destination[0] && curr[1] == destination[1])  return true;
            int r = curr[0]; 
            int c = curr[1];
            // Explore all 4 directions from the position
            for(int[] dir : dirs){
                int i = r; // start the i and j from r and c and proceed to updating it using the directions array
                int j = c;
                // traverse until wall is hit
                while(i >= 0 && i < m && j >= 0 && j < n && maze[i][j] == 0){
                    i += dir[0];
                    j += dir[1];    
                }
                // Go the step before the wall was hit to explore the path from there
                i -= dir[0];
                j -= dir[1];
                // Add the position to the queue only if it is not visited
                if(!visited[i][j]){
                    q.add(new int[]{i,j});
                    visited[i][j] = true;  // make it visited
                }    
            }    
        }
        return false;        
    }
}



// BFS solution without Visited array
// Time Complexity - O(mn)
// Space Complexity - O(1)

class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        maze[start[0]][start[1]] = 2;
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        while(!q.isEmpty()){
            int[] curr = q.poll();
            if(curr[0] == destination[0] && curr[1] == destination[1])  return true;
            int r = curr[0];
            int c = curr[1];
            for(int[] dir : dirs){
                int i = r;
                int j = c;
                while(i >= 0 && i < m && j >= 0 && j < n && (maze[i][j] == 0 || maze[i][j] == 2)){ // check for value =2 so keep changing the i and j until the wall is hit or 1 is hit. since now we are replacing the visited positions with value 2 instead of keeping visited array
                    i += dir[0];
                    j += dir[1];    
                }
                i -= dir[0];
                j -= dir[1];
                if(maze[i][j] != 2){ // add the new position to the queue only if the value is not 2 which means the position is not visited yet
                    q.add(new int[]{i,j});
                    maze[i][j] = 2;
                }    
            }    
        }
        return false;        
    }
}


// DFS Solution without visited array 
// Space Complexity O(mn)
// Time Complexity - O(1)
class Solution {
     int m = 0;
    int n = 0;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        m = maze.length;
        n = maze[0].length;
        return(dfs(maze, start, destination));
    }
    private boolean dfs(int[][] maze, int[] start, int[] destination){
        maze[start[0]][start[1]] = 2; 
        int r= start[0];
        int c = start[1];
        // Base Case
        if(r == destination[0] && c == destination[1])    return true;
        if(r >= m || r < 0 || c >=n || c < 0 || maze[r][c] ==1) return false;
        // Logic
    
        int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
        for(int[] dir: dirs){
            int i=r;
            int j=c;
            while(i < m && i>=0 && j < n && j >= 0 && (maze[i][j] ==0 || maze[i][j] ==2)){
                i += dir[0];
                j += dir[1];    
            }
            i -= dir[0];
            j -= dir[1];
            if(maze[i][j] !=2)
                if(dfs(maze, new int[]{i,j}, destination)) return true;
        }
        return false;
    }
}
