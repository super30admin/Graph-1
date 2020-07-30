// problem -1: Town judge
//TC = O(E) num of edges or trust pairs
// SC = O(n) n is number of node or total population
class Solution {
    public int findJudge(int N, int[][] trust) {
        int arr[] = new int[N+1];
        
        for(int[] trst: trust){
            int person = trst[0];
            int personTrust = trst[1];
            
            arr[person]--;
            arr[personTrust]++;
        }
       
        for(int i=1; i< arr.length; i++){
            if(arr[i] == N-1) return i;
        }
        
        return -1;
    }
}

// Problem-2: Maze

/**
Recursive DFS solution 
TC = O(m*n) where m is num of cols and n is num of rows in the mazw
SC = O(min (m, n))
*/
class Solution {
    int m, n;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze == null || maze.length == 0) return true;
        n = maze.length; m = maze[0].length;
        
        maze[start[0]][start[1]] = 2;
        return dfs(maze, start, destination);
    }
    
    private boolean dfs(int[][] maze, int[] start, int[] destination){
        //edge
        if(start[0] == destination[0] && start[1] == destination[1]) return true;
        //recursion
        int dirs[][] = {{1,0},{-1,0},{0,1},{0,-1}};
        for(int [] dir: dirs){
            int r = start[0]; int c = start[1];
            
            while(r < n && r >=0 && c < m && c >=0 && maze[r][c] != 1){
                r += dir[0]; c += dir[1]; // which direction to move to find the stopping point
            }
            r -= dir[0]; c-= dir[1]; // getting the child sitting at the boundary
            
            if(maze[r][c] != 2){ // if the current end point is already not visited
                maze[r][c]=2;
                if(dfs(maze, new int [] {r,c}, destination)) return true;
            }
            
        }
        
        //logic
        return false;
    }
}

/**
Queue based BFS solution. Every stoping of the maze is going to be stored in the queue and processed to see if it contains the destination point or not. 
TC = O(m*n) where m is num of cols and n is num of rows in the mazw
SC = O(min (m, n))
*/
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze == null || maze.length == 0) return true;
        
        Queue< int[] > q = new LinkedList<>();
        int n = maze.length; int m = maze[0].length;
        
        q.add(start); // add the given starting point to be processed
        maze[start[0]][start[1]] = 2;
       int dirs[][] = {{1,0},{-1,0},{0,1},{0,-1}};
        
        while(!q.isEmpty()){
            int [] cur = q.poll(); // get the current stopping point and add other stopping point from the current stopping point
            if(cur[0] == destination[0] && cur[1] == destination[1]) return true;
            
          for(int [] dir: dirs){  
            int r = cur[0]; int c= cur[1];
              
              while(r < n && r >=0 && c < m && c >=0 && maze[r][c] != 1){
                r += dir[0]; c += dir[1]; // which direction to move to find the stopping point
            }
            
            r -= dir[0]; c-= dir[1]; // getting the child sitting at the boundary
            
            if(maze[r][c] != 2){ // if the current end point is already not visited
                maze[r][c]=2;
                q.add(new int[] {r,c});
            }
          }
            
        }
        
        return false;
    }
}
