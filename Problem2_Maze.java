// Time Complexity : o(mn)
// Space Complexity : o(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    
    //BFS Approach
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
      
        if(maze==null || maze.length==0)
            return false;
        
        Queue<int[]> queue=new LinkedList<>();
        queue.add(start);
        maze[start[0]][start[1]]=2;
        
        int m=maze.length;
        int n=maze[0].length;
        
        int dirs[][]={{-1,0},{0,-1},{0,1},{1,0}};
        
        while(!queue.isEmpty())
        {
            int[] curr=queue.poll();
            
            for(int[] dir:dirs)
            {
                int i=curr[0];
                int j=curr[1];
                
               while (i < m && j < n && i >= 0 && j >= 0 && maze[i][j] != 1) {
					i += dir[0];
					j += dir[1];
				}
                
                 // if it hits wall (1's) we need to go previous position 0's
                
                i -= dir[0];
				j -= dir[1];

				if (destination[0] == i && destination[1] == j) {
					return true;
				}

				if (maze[i][j] != 2) {
					queue.add(new int[] { i, j });
					maze[i][j] = 2;
				}
            }
        }
        return false;
    }
    
    //DFS Approach
    int[][] dirs;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze==null || maze.length==0)
            return false;
        
        
        int m=maze.length;
        int n=maze[0].length;
        
         dirs={{-1,0},{0,-1},{0,1},{1,0}};
        
        return dfs(maze,start,destination,m,n);
    }
    
    private boolean dfs(int[][] maze,int[] start,int[] destination,int m,int n)
    {
       
    if(start[0] == destination[0] && start[1] == destination[1]) {
      return true;
    }

      maze[start[0]][start[1]] = 2;

 for(int[] dir : dirs) {
    int i = start[0];
    int j = start[1];
    while(i >= 0 && j >= 0 && i < m && j < n && maze[i][j] != 1) 
    {
       i += dir[0];
       j += dir[1];
    }
     i -= dir[0];
     j -= dir[1];

    if(maze[i][j] != 2 && helper(maze,new int[]{i,j},destination, m,n)) 
    {
    return true;
    }
        
    }
    return false;
 }
}