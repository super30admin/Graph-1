//time complexity - o(m*n)
//space complexity- O(m*n)
import java.util.*;
public class TheMaze {
    static boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int[][]dirs = {{-1,0},{1,0},{0,1},{0,-1}};
        int m = maze.length;
        int n = maze[0].length;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start[0], start[1]});
        maze[start[0]][start[1]] = -1;
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int[] dir: dirs){
                int nr = dir[0] + curr[0];
                int nc = dir[1] + curr[1];
                while(nr>=0 && nc>=0 && nr<m && nc<n && maze[nr][nc] != 1){
                    nr += dir[0];
                    nc += dir[1];
                }
                nr -= dir[0];
                nc -= dir[1];
                if(nr == destination[0] && nc == destination[1]) return true;
                if(maze[nr][nc] != -1){
                    q.add(new int[]{nr,nc});
                    maze[nr][nc] = -1;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] maze = {{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
        int[] start = {0,4};
        int[]destination = {4,4};

        System.out.println("Can ball reach the destination?: " + hasPath(maze, start, destination));

    }
}
