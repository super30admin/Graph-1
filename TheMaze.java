//Time complexity:O(mn);
//Space complexity:O(mn);

import java.util.LinkedList;
import java.util.Queue;
public class TheMaze {
    public boolean hasPath(int [][]maze,int start[], int destination[]){
        if(maze==null || maze.length==0) return false;
        Queue<int []>queue=new LinkedList<>();
          int m=maze.length;
          int n=maze[0].length;
          maze[start[0]][start[1]]=2;
          int dirs[][]={{-1,0},{1,0},{0,-1},{0,1}};
          queue.add(new int[]{start[0],start[1]});
          while(!queue.isEmpty()){
              int curr[]=queue.poll();
              for(int []dir:dirs){
                  int i=curr[0];
                  int j=curr[1];
                  while(i<m && i>=0&& j<n&&j>=0 && maze[i][j]!=1){
                      i+=dir[0];
                      j+=dir[1];
                  }
                  i=i-dir[0];
                  j-=dir[1];
                  if(i==destination[0] && j==destination[1]){
                      return true;
                  }
                  if(maze[i][j]==0){
                      maze[i][j]=2;
                      queue.add(new int[]{i,j});
                  }
              }
          }

          
        return false;
    }
}
