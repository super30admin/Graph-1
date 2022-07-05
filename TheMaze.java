// Time Complexity :O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze.length==0 || maze==null){
            return false;
        }
        
        int[][] dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        int m = maze.length;
        int n = maze[0].length;
        
        if(start==destination){
            return true;
        }
        
        Queue<Integer> q = new LinkedList<>();
        q.add(start[0]);
        q.add(start[1]);
        maze[start[0]][start[1]] = 2;
        
        while(!q.isEmpty()){
            int currRow = q.poll();
            int currCol = q.poll();
            for(int[] dir : dirs){
                int i = currRow;
                int j = currCol;
                while(i>=0 && i<m && j>=0 && j<n && maze[i][j]!=1){
                    i += dir[0];
                    j += dir[1];
                }
                
                i -= dir[0];
                j -= dir[1];
                
                if(i==destination[0] && j==destination[1]){
                    return true;
                }
                
                if(maze[i][j]!=2){
                    q.add(i);
                    q.add(j);
                    maze[i][j] = 2;
                }
            }
        }
        return false;
    }
}