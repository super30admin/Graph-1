/*Running Time Complexity: O(mxnxk) where k -> constant at every node we're traversing all direction
Space Complexity: Constant
Run and Compiled on online compiler.
*/
import java.util.*;
public class HelloWorld{

     public static void main(String []args){
        int[][] maze = {{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
        int[] start={0,4};
        int m = maze.length; int n = maze[0].length;
        int[] destination={4,4};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start[0],start[1]});
        maze[start[0]][start[1]]=2;
        int[][] dirs ={{0,1},{1,0},{-1,0},{0,-1}};
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int[] dir:dirs){
                int i = curr[0];
                int j = curr[1];
                while(i<m && i>=0 && j<n && j>=0 && maze[i][j] != 1){
                    i = i + dir[0];
                    j = j + dir[1];
                }
                i = i - dir[0];
                j = j - dir[1];
                if(i==destination[0] && j == destination[1]){
                    System.out.println("found");
                    break;
                }
                if(maze[i][j] != 2){
                    q.add(new int[]{i,j});
                    maze[i][j] = 2;
                } 
            }
        }
        System.out.println("Hello World");
     }
}