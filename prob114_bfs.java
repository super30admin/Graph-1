// S30 Big N Problem #114 {Medium}
// 490. The Maze
// Time Complexity :O(m*n)
// Space Complexity :O(m*n) recursive stack to store stoping indices 
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
// BFS Solution
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze==null || maze.length==0) return false;
        int m=maze.length;
        int n=maze[0].length;
        int [][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
        
        Queue<int []> q=new LinkedList<>();
        q.add(start);
        maze[start[0]][start[1]]=2;
        
        while(!q.isEmpty()){
            int [] curr=q.poll();
            int r=curr[0]; int c=curr[1];
            
            if(r==destination[0] && c==destination[1]) return true;
            
            for(int []dir:dirs){
                int i=r; int j=c;
                
                while(i>=0 && i<m && j>=0 && j<n && maze[i][j] !=1){
                    i+=dir[0];
                    j+=dir[1];
                }
                
                //moving one step back
                i-=dir[0];
                j-=dir[1];
                if(maze[i][j]!=2){
                    q.add(new int [] {i,j});
                    maze[i][j]=2;
                }
            }
        }
        return false;  
    }
}