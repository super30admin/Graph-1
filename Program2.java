//Time Complexity : O(m*n) -->maze dimensions
//Space Complexity : O(m *n )--> for bfs queue

public class Solution {
    /**
     * @param maze: the maze
     * @param start: the start
     * @param destination: the destination
     * @return: whether the ball could stop at the destination
     */
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {

        // write your code here
        int[][] dir= {{-1,0},{0,-1},{1,0},{0,1}};
        
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        maze[start[0]][start[1]] =2;
        
        while(!q.isEmpty()){
            
            int[] temp = q.poll();
            if(temp[0]==destination[0] && temp[1]==destination[1]){
                return true;
            }
            
            for(int[] d : dir){
                int x = temp[0];
                int y = temp[1];
               // System.out.println(x+":"+y);
                while(x >=0 && y>=0 && x<maze.length && y<maze[0].length && maze[x][y]!=1){
                     x=x+d[0];
                     y=y+d[1];
                }
                x-=d[0];
                y-=d[1];
                
                if(maze[x][y]!=2){
                    q.add(new int[]{x,y});
                    maze[x][y]=2;
                }
               
                
                
            }
        }
        
        return false;
        
        
    }
}