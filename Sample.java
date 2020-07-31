// Time Complexity : O(M+N) where M is number of edges
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution {
    public int findJudge(int N, int[][] trust) {
        if(trust == null) //edge case
            return -1;
       int indegree[] = new int[N]; // indegree for each person i.e how many people trusts that person
        
        for(int t[]:trust) // iterating over trust array
        {
            indegree[t[0]-1]--; // for each person trusting decrease indegree
            indegree[t[1]-1]++; // for each person trusted increase indegree
        }
        
        for(int i=0;i<N;i++) // iterate over indegree array
        {
            if(indegree[i] == N-1) // if all people trust the person
                return i+1; // return its value
        }
        
        return -1;
    }
}

// Time Complexity : O(m*n) where M is number of edges
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        //edge case
        if(maze==null || maze.length==0)
            return false;
        int m = maze.length;
        int n = maze[0].length;
        int dirs[][] = {{-1,0},{0,-1},{1,0},{0,1}};
        Queue<int[]> q = new LinkedList<>(); //bfs
        q.add(start); //add the starting point to queue
        maze[start[0]][start[1]] = 2; // mark it visited
        
        while(!q.isEmpty()) // till queue becomes empty
        {
            int curr[] = q.poll(); // get index to be processed
            if(curr[0] == destination[0] && curr[1] == destination[1]) // if it is equal to destination
                return true;
            for(int dir[]: dirs) // itearte over all the directions
            {
              int r = curr[0]; // take the r and c for the point where we are starting the rolling again
              int c = curr[1];
            while(r>=0 && r<m && c>=0 && c<n && maze[r][c] != 1)  // till we are in bounds and we havent encountered a wall
            {
                r += dir[0]; // keep on rolling
                c += dir[1];
            }
                r -=dir[0]; // we stop when we reach a wall i.e 1 so we have to give a index prior to that
                c -=dir[1];
                
                if(maze[r][c] !=2) // if it has not been visited previously
                {
                    maze[r][c] = 2; // mark it visited 
                    q.add(new int[]{r,c}); // add it to queue to process it neighbours
                }
            
            }
         }
        return false;
}
}

// Time Complexity : O(m*n) where M is number of edges
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution {
    int m;
    int n;
    int dirs[][];
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze==null || maze.length==0)
            return false;
         m = maze.length;
         n = maze[0].length;
         dirs = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
        
        maze[start[0]][start[1]] = 2; // mark the starting position as visited
       return dfs(maze, start, destination); // start dfs on it
        
    }
    
    private boolean dfs(int[][] maze, int[] start, int[] destination)
    {
        //base
        if(start[0] == destination[0] && start[1] == destination[1]) // when the start of dfs becomes destination
            return true;
        
        //logic
        for(int dir[]: dirs) // iterate in all directions
            {
              int r = start[0]; // store the starting point of rolling
              int c = start[1];
            while(r>=0 && r<m && c>=0 && c<n && maze[r][c] != 1) // till we are in bounds and we havent encountered a wall
            {
                r += dir[0]; //keep on rolling
                c += dir[1];
            }
                r -=dir[0];// we stop when we reach a wall i.e 1 so we have to give a index prior to that
                c -=dir[1];
                
                if(maze[r][c] !=2) // if position not visited 
                {
                    maze[r][c] = 2; // mark it visited
                   if( dfs(maze, new int[]{r,c}, destination)) return true; // start dfs on the new starting index, if it returns true at any point return true
                }
            
            }
        return false;
    }
      

}