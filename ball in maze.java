//Timecomplexity:-0(nm);
//spacecomplexity:-O(nm) for reccursion stack.



public class Solution {
   private int[][]dirs={{1,0},{-1,0},{0,1},{0,-1}};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        return helper(maze,destination,start[0],start[1]);
        
    }
    // reccursive bfs approach.
    private boolean helper(int[][] maze,int[] dest,int i, int j){
        if(maze[i][j]==2){
            return false; // If answer is already there then it is already found no need to visit again.
        }
        if(i==dest[0]&&j==dest[1]){
            return true; 
        }
        maze[i][j]=2;//encoding visited part.
        for(int[] dir:dirs){
            int r=i;
            int c=j;
            while(r>=0 && r<maze.length && c>=0 && c<maze[0].length && maze[r][c]!=1 ){
                r=r+dir[0];   //Moving of ball untill it reaches out of bounds and wall.
                c=c+dir[1];
            }
            r=r- dir[0];
            c=c-dir[1];
             if(helper(maze,dest,r,c)){
                 return true;
             }
        }
        return false;

    }