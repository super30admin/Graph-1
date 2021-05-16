///The maze
//bfs traversal. 
//tc -  O(m*n)*O(m+n)
//sc -O(m*n) for queue
import java.util.*;
public class Problem2 {
    public static void main(String args[]){
        int[][] maze = {{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
        int[] start = {0,4};
        int[]destination = {4,4};
        Problem2 p = new Problem2();
        System.out.println(p.hasPath(maze, start, destination));

    }
    int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    int m;
    int n;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze == null || maze.length ==0){
            return false;
        }
        m = maze.length;
        n = maze[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start[0], start[1]});
        while(!q.isEmpty()){
            //base

            int[] curr = q.poll();
            // if(curr[0] == destination[0] && curr[1] == destination[1]){
            //     return true;
            // }
            for(int[] dir : dirs){
                int r = dir[0] + curr[0];
                int c = dir[1] + curr[1];
                while(r >=0 && r<m && c >= 0 && c < n && maze[r][c] != 1){
                    r += dir[0];
                    c += dir[1];
                }
                r = r-dir[0];
                c = c- dir[1];
                if(r == destination[0] && c == destination[1]){
                    return true;
                }
                if(maze[r][c] !=2){
                    maze[r][c] = 2;
                    q.add(new int[]{r, c});
                }
               
                
            }


        }
        return false;

    }
    
}
