
//TC : O(M*N)
//SC : O(1)
class Solution {
    int[][] directions;
    int m, n;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        
        if(maze == null || maze.length == 0)    return false;
        m = maze.length;
        n = maze[0].length;
        directions = new int[][]{ {0,1}, {0,-1}, {-1,0}, {1,0} }; 
        return dfs(maze, start, destination); // Start will be curr initially
        
    }
    
    
    public boolean dfs(int[][] maze, int[] curr, int[] destination){
        //Base 
        
        if(maze[curr[0]][curr[1]] == 2) return false;
        if(curr[0] == destination[0] && curr[1] == destination[1])  return true;
        
        //Marking curr as visited
        maze[curr[0]][curr[1]] = 2;
            
        for(int[] d : directions){
                int i = curr[0]; // i and j indices of data(Curr pair of indices)
                int j = curr[1]; 
                
                while(i >= 0 && i < m && j >= 0 && j < n && maze[i][j] != 1){ // Going in direction till hitting the wall
                    i += d[0];
                    j += d[1];
                }
                //Will come back one step back for curr direction once we hit wall
                i -= d[0];
                j -= d[1];
                
                if(dfs(maze, new int[]{i, j}, destination)) return true;
            }
        return false;  
    }
    
    
}



/*

//TC : O(M*N)
//SC : O(N)
class Solution {
    int[][] directions;
    int m, n;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        
        if(maze == null || maze.length == 0)    return false;
        m = maze.length;
        n = maze[0].length;
        
        directions = new int[][]{ {0,1}, {0,-1}, {-1,0}, {1,0} }; 
        
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        maze[start[0]][start[1]] = 2; //Marking as Visited
        
        while(!queue.isEmpty()){
            int[] data = queue.poll();
            
            if(data[0] == destination[0] && data[1] == destination[1])  return true;
            
            for(int[] d : directions){
                int i = data[0]; // i and j indices of data(Curr pair of indices)
                int j = data[1]; 
                
                while(i >= 0 && i < m && j >= 0 && j < n && maze[i][j] != 1){ // Going in direction till hitting the wall
                    i += d[0];
                    j += d[1];
                }
                //Will come back one step back for curr direction once we hit wall
                i -= d[0];
                j -= d[1];
                
                if(maze[i][j] != 2){ // If current cell in not visited, add that cell indices into the Queue
                    if(i == destination[0] && j == destination[1])  return true;
                    queue.add(new int[] {i,j});
                    maze[i][j] = 2;
                }
                
            }
        }
        
        
        return false;
        
    }
}

*/