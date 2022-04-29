import java.util.LinkedList;
import java.util.Queue;

//Time Complexity : O(k*m*n) => O(m*n) since k is constant
//Space Complexity : O(m*n)
public class Maze {	
	/**Approach1: BFS| Time O(m*n)| Space O(m*n)**/
	/*public boolean hasPath(int[][] maze, int[] start, int[] destination) {        
        int m=maze.length;
        int n= maze[0].length;
        int[][] dirs= {{1,0},{0,1},{-1,0},{0,-1}};
        Queue<int[]> q= new LinkedList<>();        
        q.add(new int[]{start[0],start[1]});
        maze[start[0]][start[1]] = 2;
        while(!q.isEmpty()){
            int[] curr= q.poll();            
            if(curr[0] == destination[0] && curr[1] == destination[1]) return true;
            for(int[] dir: dirs){
                int i= curr[0];
                int j= curr[1];
                while(i>=0 && j>=0 && i<m && j<n && maze[i][j] != 1){
                    i += dir[0];
                    j += dir[1];                    
                }
                i -= dir[0];
                j -= dir[1];                
                if(maze[i][j] !=2 ){                
                    q.add(new int[] {i,j});
                    maze[i][j]=2;
                }
            }
        }
        return false;
    }*/
	
	/**Approach2: DFS| Time O(m*n)| Space O(m*n)**/
	int[][] dirs;
    int m;
    int n;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        //DFS
        m=maze.length;
        n= maze[0].length;
        dirs= new int[][] {{1,0},{0,1},{-1,0},{0,-1}};        
        return dfs(maze, start, destination);
    }
    private boolean dfs(int[][] maze, int[] curr, int[] destination){
        //base
        if(maze[curr[0]][curr[1]]==2) return false;
        if(curr[0] == destination[0] && curr[1] == destination[1]) return true;
        
        //logic
        maze[curr[0]][curr[1]]=2;
        for(int[] dir: dirs){
            int i= curr[0];
            int j= curr[1];
            while(i>=0 && j>=0 && i<m && j<n && maze[i][j] != 1){
                i += dir[0];
                j += dir[1];                    
            }
            i -= dir[0];
            j -= dir[1]; 
            
            if(dfs(maze, new int[]{i,j}, destination)) return true;
        }
        return false;
    }
	
	// Driver code to test above
	public static void main (String[] args) {
		Maze ob= new Maze();
		/*int[][] maze=  {{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
		int[] start = {0,4};
		int[] destination = {3,2};*/
		
		int[][] maze= {{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
		int[] start = {0,4};
		int[] destination = {4,4};
		
		System.out.print("Can the ball stop at destination? "+ob.hasPath(maze, start, destination));			
	}
}
