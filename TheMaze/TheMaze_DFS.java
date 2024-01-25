/* Time Complexity : O(m*n) 
 *  m - rows of the matrix - maze
 *  n - cols of the matrix - maze */
/* Space Complexity : O(m*n) */
// Did this code successfully run on Leetcode : No, as it's a premium problem 
// Any problem you faced while coding this :


public class Main {
    public static void main(String[] args) {        
        int[][] maze = new int[][]{{0, 0, 1, 0, 0},{0, 0, 0, 0, 0},{0, 0, 0, 1, 0},{1, 1, 0, 1, 1},{0, 0, 0, 0, 0}};
        int[] start = new int[]{0,4};
        int[] dest= new int[]{4,4};
        
        boolean res = hasPath(maze, start, dest);
        System.out.println(res);
        
        int[] start2 = new int[]{0,4};
        int[] dest2= new int[]{3,2};
        
        boolean res2 = hasPath(maze, start2, dest2);
        System.out.println(res2);
    }
    
    static int m;
    static int n;
    static int[][] dirs;
    public static boolean hasPath(int[][] maze, int[] start, int[] destination){
		m = maze.length;
		n = maze[0].length;
        dirs = new int[][] {{-1,0}, {1,0},{0,-1},{0,1}};
        return dfs(maze, start, destination);        
	}
    
    private static boolean dfs(int[][] maze, int[] start, int[] destination){
        //base condition
        if(start[0] == destination[0] && start[1] == destination[1]) return true;
        //logic
        maze[start[0]][start[1]] = 2;//mark visited
        for(int[] dir: dirs){
            int r = start[0];
            int c = start[1];
            //Incr r and c till we encounter an edge or a wall
            while(r < m && r >= 0 && c < n && c >= 0 && maze[r][c] != 1){
                r += dir[0];
                c += dir[1];    
            }
            //step back
            r -= dir[0];
            c -= dir[1];
			//Not already visited, make dfs call
            if(maze[r][c] != 2 && dfs(maze, new int[]{r, c}, destination)){
                return true;
            }                                                
        }    
        return false;
    }
}