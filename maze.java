//time complexit:O(m*n)(m+n)
//space complexity:O(m*n)
import java.util.*;
class Solution {

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
int m = maze.length;

        int n = maze[0].length;

        // boolean [][] visited = new boolean [m][n];

        Queue <int []> q = new LinkedList <>();

        int [][] dirs = {{0,1},{1,0}, {0, -1}, {-1, 0}};

        q.offer(start);

        maze[start[0]][start[1]] = 2;

        while(!q.isEmpty()){

            int [] top = q.poll();

            int r = top[0];

            int c = top[1];

            if(r == destination[0] && c == destination[1]) return true;

            for(int k = 0; k < dirs.length; k++){

                int i = r;

                int j = c;

                // Keep the ball rolling

                while(i >= 0 && j >= 0 && i < m && j < n && (maze[i][j] == 0 || maze[i][j] == 2)){

                    i += dirs[k][0];

                    j += dirs[k][1];

                }

                // bring back to stop point

                i -= dirs[k][0];

                j -= dirs[k][1];

                if(maze[i][j] != 2){

                    q.offer(new int [] {i,j});

                    maze[i][j] = 2; 

                }            }

        }

        return false;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] maze = {
            { 0, 0, 1, 0, 0 },
            { 0, 0, 0, 0, 0 },
            { 0, 0, 0, 1, 0 },
            { 1, 1, 0, 1, 1 },
            { 0, 0, 0, 0, 0 }
        };

        int[] start = { 0, 4 };
        int[] destination = { 4, 4 };

        boolean result = solution.hasPath(maze, start, destination);
        System.out.println("Path exists: " + result); // Expected output: true or false
    }
}