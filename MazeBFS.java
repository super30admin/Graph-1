//TC : O(mn)  where m is the number of rows,n is number of cols
//SC : O(mn) size of queue
class Solution {
    
    
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        Queue<int[]> q = new LinkedList<>();
        
        q.add(start);
        //Visited node marked as 2
        maze[start[0]][start[1]] = 2;
        
        while(!q.isEmpty()){
             int[] curr = q.poll();
            
             int i = curr[0],j = curr[1];
            
             //Reached destination
            if(i == destination[0] && j == destination[1])
                return true;
            
             for(int[] dir : dirs){
                 //To explore all possible directions from (i,j)
                 int r = i , c = j;
                 
                 while(r>=0 && r<m && c >=0 && c < n && maze[r][c]!=1){
                     r =r +dir[0];c = c+dir[1];
                 }
                 
                 r = r - dir[0]; c= c -dir[1];
                 
                 //If not already visited, add it to the queue to be processed next
                 if(maze[r][c]!=2){
                     q.add(new int[]{r,c});
                     maze[r][c] =2;
                 }
             }
            
        }
        return false;
        
    }
}