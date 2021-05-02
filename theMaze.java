//TC: O(mn)
//SC: O(mn) or number of stops


public class Solution {
    /**
     * @param maze: the maze
     * @param start: the start
     * @param destination: the destination
     * @return: whether the ball could stop at the destination
     */
     private int[][] dirs = {{-1,0},{0,1},{1,0},{0,-1}};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        // write your code here

        return dfs(maze, destination, start[0], start[1]);
      
        
    }

    private boolean dfs(int[][] maze,int[] dest,  int i, int j){
          
        if(maze[i][j] == 3){
            return false;
        }

        if(i == dest[0] && j == dest[1]){
            return true;
        }
        maze[i][j] = 3;
        for(int[] dir : dirs){
            int r = i;
            int c = j;

            while(r>=0 && r<maze.length && c>=0 && c<maze[0].length && maze[r][c]!=1){
                r = r +dir[0];
                c=c+dir[1];
            }

            //moving one place back in order to get the visited place
            r = r - dir[0];
            c = c - dir[1];

            if(dfs(maze,dest,r,c)){
                return true;
            }
        }
        return false;


    }
}