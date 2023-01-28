import java.util.Queue;
import java.util.LinkedList;

// Time O(MN)
//Space O(MN)

public class TheMaze {
	
	//Time O(MN)
	//Space O(MN)
	  
	// BFS, will add start pointer and thn perform while loop to find next possible neighbours 
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        
        int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        maze[start[0]][start[1]] = 2;
        int m = maze.length;
        int n = maze[0].length;
        
        while(!queue.isEmpty()){
            
            int[] curr = queue.poll(); 
            
            for(int[] dir:dirs){
                int r = curr[0];
                int c = curr[1];
                while(r>=0 && r<m && c>=0 &&c<n && maze[r][c]!=1){
                    r+=dir[0];
                    c+=dir[1];
                }
                // one step back
                r -=dir[0];
                c -=dir[1];
              if(r == destination[0] && c == destination[1])
                  return true;
                if(maze[r][c]==0){
                    queue.add(new int[]{r,c});
                    maze[r][c]=2;
                }
             }   
        }
        
        return false;
    }
}
