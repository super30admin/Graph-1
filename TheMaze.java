/*
 *  Time Complexity: O(M*N) Average case, worst case would not excede O(M*N(N+M)). Where N is the number of rows and M is the number of columns. 
 *  Space Complexity: O(N*M) Visited array would take up this space. Aso Queue might take max of N*M elements
 * 
 *  Did this code successfully run on Leetcode : Yes
 *  Any problem you faced while coding this : None
 * 
 *  We can solve using in BFS or DFS, In BFS we first create a queue and add the start position to it. We also create a visisted array to keep track of all the visited nodes. For every node in the queue we travers in all the four directions and if we hit an obstacle or the edge we add that node to the queue if its not already visited. If we find the destination we simply return true. We continue to do this as long as the queue is not empty and in the last we return false if dont reach the destination.
 */

class Solution {
    boolean visited[][];
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze==null) return false;
        
        int n=maze.length, m=maze[0].length;
        visited = new boolean[maze.length][maze[0].length];
        int dirs[][] = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        
        Queue<int[]> queue= new LinkedList<>();
        queue.offer(new int[]{start[0],start[1]});
        
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            
            visited[curr[0]][curr[1]] = true;
            if(curr[0]==destination[0] && curr[1]==destination[1]){
                return true;
            }
            
            
            for(int[] dir:dirs){
                int x = curr[0], y = curr[1];
                while( x+dir[0]<n && x+dir[0]>=0 && y+dir[1]<m && y+dir[1]>=0 && maze[x+dir[0]][y+dir[1]]!=1 ){
                    x=x+dir[0];
                    y=y+dir[1];
                }
                if(visited[x][y]==false){
                    queue.offer(new int[]{x,y});
                    visited[x][y]=true;
                }
            }
        }
        return false;
    }
    
}
