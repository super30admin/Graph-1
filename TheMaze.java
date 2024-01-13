//T.C : O(m*n)
//S.C : O(m*n)
//Solution: Use BFS Queue to explore all possible solutions and check edge conditions

import java.util.LinkedList;
import java.util.Queue;

//Problem Stmt: Give a ball and its destination positions in a nxn matrix, surrounded by wall and obstacles represented by
//1, empty places rep as 0,need to find if there is path from source to dest.
public class TheMaze {
    int m, n;
    int[][] dirs;
    public boolean findPath(int[][] maze, int[] start, int[] dest){
        m = maze.length;
        n = maze[0].length;
        dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

        if(start[0]==dest[0] && start[1] == dest[1])
            return true;
        //maintain a queue for possible moves from start. if we reach the dest, that's a path
        Queue<int[]> q = new LinkedList<>();

        q.add(start);
        maze[start[0]][start[1]] = 2;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int[] dir: dirs){
                int r = dir[0] + curr[0];
                int c = dir[1] + curr[1];

                while(r >= 0 && c >= 0 && r < m && c < n && maze[r][c] == 0){
                    r += dir[0];
                    c += dir[1];
                }
                r -= dir[0];
                c -= dir[1];

                if(r == dest[0] && c == dest[1])
                        return true;
                if(maze[r][c] != 2) {
                    q.add(new int[]{r, c});
                    maze[r][c] = 2;
                }

            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] maze = new int[][]{{0,0,1,0,0},{0,0,0,0,0},
                {0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
        int[] start = new int[]{0,4};
        int[] dest = new int[]{4,4};
        boolean res = new TheMaze().findPath(maze, start, dest);
        System.out.println("Result is : " + res);
    }
}
