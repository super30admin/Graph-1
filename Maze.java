import java.util.LinkedList;
import java.util.Queue;

public class Maze {
    // BFS approach
    // TC : O(m * n)
    // SC : O(m * n)
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze == null || maze.length == 0) return false;

        int m = maze.length;
        int n = maze[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start[0], start[1]});
        maze[start[0]][start[1]] = 2;  //marking it as visited

        int[][] dirs = new int[][]{
                {-1,0}, // Up
                {1,0}, // Down
                {0, -1}, // Left
                {0,1}    // Right
        };

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            for(int[] dir : dirs) {
                int r = curr[0];
                int c = curr[1];

                while(r >= 0 && r < m && c >=0 && c < n && maze[r][c] != 1) {
                    r = r + dir[0];
                    c = c + dir[1];
                }
                // we came out of the while loop that mean we were at the invalid position
                // So, come back one position
                r = r - dir[0];
                c = c - dir[1];

                if(maze[r][c] != 2){
                    if(r == destination[0] && c == destination[1]) {
                        return true;
                    }
                    maze[r][c] = 2;
                    queue.add(new int[]{r,c});
                }
            }
        }

        return false;
    }
}
