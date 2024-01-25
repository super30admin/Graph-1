/* Time Complexity : O(m*n*(m+n)) ~= O(m*n) as m*n>m+n
 *  m - rows of the matrix - maze
 *  n - cols of the matrix - maze */
/* Space Complexity : O(m*n)
 *  (m*n) => max number of elements that could be present in the queue at any any given point of time*/
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
        Queue<int []> q = new LinkedList<>();
        q.add(start);
        maze[start[0]][start[1]] = 2;//mark visited
        
        while(!q.isEmpty()){
            int[] curr = q.poll();            
            for(int[] dir: dirs){
                int r = curr[0];
                int c = curr[1];
				//Incr r and c till we encounter an edge or a wall
                while(r < m && r >= 0 && c < n && c >= 0 && maze[r][c] != 1){
                    r += dir[0];
                    c += dir[1];    
                }
                //step back
                r -= dir[0];
                c -= dir[1];
                if(r == destination[0] && c == destination[1]) return true;
				//Not already visited, add to queue
                if(maze[r][c] != 2){
                    q.add(new int[]{r,c});
                    maze[r][c] = 2;   
                }                                                
            }
        }
        return false;
	}
}