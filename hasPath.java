// Time Complexity : O(m*n)
// Space Complexity : O(m+n) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
public class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        
        int m = maze.length;
        int n = maze[0].length;
        
        Queue<int[]> bfs = new LinkedList();
        bfs.add(start);
        maze[start[0]][start[1]]=2;
        
        int dirs[][] = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!bfs.isEmpty()) {
            
            int[] curr = bfs.poll();
            
            for(int[] dir : dirs) {
                
                int r = curr[0];
                int c = curr[1];
                
                while(r>=0 && c>=0 && r<m && c<n && maze[r][c]!=1) {
                    r+=dir[0];
                    c+=dir[1];
                }
                r-=dir[0];
                c-=dir[1];
                
                
                if(r==destination[0] && c==destination[1]) {
                    return true;
                }
                
                if(maze[r][c]!=2) {
                    maze[r][c]=2;
                    bfs.add(new int[]{r,c});
                }
                
                
            }
            
        }
        
        return false;
    }
}
