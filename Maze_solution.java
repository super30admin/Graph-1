package codes;

import java.util.LinkedList;
import java.util.Queue;

public class Maze_solution {

	
	
	
	 public boolean hasPath1(int[][] maze, int[] start, int[] destination) {
//		 bfs o(n) --> n - size of matrix
	        if(maze==null|| maze.length==0) return false;
	        
	        Queue<int []> q =new LinkedList<>();
	        
	        
	        int m=maze.length;
	        int n= maze[0].length;
	        
	        
	        
	        q.add(start);
	        
	        
	        maze[start[0]][start[1]]=2;
	        
	        
	        
	        int [][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
	        
	        
	        
	        while(!q.isEmpty()){
	            
	            // get first item
	            int [] curr = q.poll();
	            
	            
	            // check if the returened item is destination
	            if(curr[0]==destination[0]&&curr[1]==destination[1]) return true;
	            
	            
	            for(int [] dir:dirs){
	                
	                
	                int i=curr[0];
	                
	                
	                int j=curr[1];
	                
	                
	                while(i>=0 && j>=0&& j<n && i<m&& maze[i][j]!=1){
	                    // go down the lane as long we dont find a wall .
	                    
	                    i=i+dir[0];
	                    j=j+dir[1];
	                    
	                    
	                }
	                
	                // we are on the wall , move back a single block .
	                
	                i=i-dir[0];
	                j=j-dir[1];
	                
	                
	                if(maze[i][j]!=2){
	                    q.add(new int [] {i,j});
	                    maze[i][j]=2;
	                }
	                
	                
	                
	            }
	            
	            
	            
	        }
	        
	        return false;
	        
	        
	        
	    }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	  int [][] dirs;
	    int m;
	    int n;
	    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
	        if(maze==null|| maze.length==0) return false;
	        
	        
	        m= maze.length;
	         n= maze[0].length;
	        
	        
	        
	        
	        dirs= new int [][] {{0,1},{0,-1},{1,0},{-1,0}};
	        
	        
	        
	        return dfs(maze, start,destination);
	        
	    }
	    
	    
	    
	    private boolean dfs(int [] [] maze, int [] start, int [] destination){
	        
	        //base
	        if(maze[start[0]][start[1]]==2) return false;
	        
	        if(start[0]==destination[0]&&start[1]==destination[1]) return true;
	        
	        
	        
	        
	        
	        
	        
	        
	        //main
	        
	        maze[start[0]][start[1]]=2;
	        
	        for(int [] dir :dirs){
	            int i=start[0];
	            int j=start[1];
	            
	            
	            
	            while(i>=0&&j>=0&& i<m && j<n && maze[i][j]!=1){
	                i=i+dir[0];
	                j=j+dir[1];
	            }
	            
	            
	            
	            
	            i=i-dir[0];
	            j=j-dir[1];
	            
	        
	            
	            if(dfs(maze, new int [] {i,j},destination)) return true;
	            
	            
	            
	        }
	        
	         return false;
	        
	        
	        
	        
	    }
	    
	   
	    
	 
	 
	 
	 
}
