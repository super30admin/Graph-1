// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        Queue<Integer> row=new LinkedList<>();
        Queue<Integer> col=new LinkedList<>();
        
        row.add(start[0]);
        col.add(start[1]);
        int[][] dirs={{0,1},{1,0},{-1,0},{0,-1}};
        maze[start[0]][start[1]]=2;
        while(!row.isEmpty()){
            int currRow=row.poll();
            int currCol=col.poll();
          
            for(int[] dir: dirs){
                int newRow=currRow;
                int newCol=currCol;
                while(newRow>=0 && newCol>=0 && newRow<maze.length && newCol<maze[0].length && maze[newRow][newCol]!=1){
                    newRow+=dir[0];
                    newCol+=dir[1];
                }
                newRow-=dir[0];
                newCol-=dir[1];
                 if(newRow==destination[0] && newCol==destination[1]){
                    return true;
                 }
                if(maze[newRow][newCol]!=2){
                    maze[newRow][newCol]=2;
                    row.add(newRow);
                    col.add(newCol);
                }
            
            }
          
        }
        
        return false;
    }
}