// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        
        Queue<Integer> row = new LinkedList<>();
        Queue<Integer> col = new LinkedList<>();
        
        row.add(start[0]);
        col.add(start[1]);
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        while(!row.isEmpty()) {
            int pr = row.poll();
            int pc = col.poll();
            
            for(int[] dir:dirs) {
                int r = pr + dir[0];
                int c = pc + dir[1];
                
                while(r>=0 && r<maze.length && c>=0 && c<maze[0].length && maze[r][c] != 1) {
                    r += dir[0];
                    c += dir[1];
                }
                r -= dir[0];
                c -= dir[1];
                if(r == destination[0] && c == destination[1]) {
                    return true;       
                }
                if(maze[r][c] != 2) {
                    maze[r][c] = 2;
                    
                    row.add(r);
                    col.add(c);
                }
            } 
        }
        
        return false;
    }
}