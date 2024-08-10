import java.util.LinkedList;
import java.util.Queue;

/***
 Using bfs
 TC - O((m*n) * (m+n))
 SC - O(m*n)
 */

class TheMaze {

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze == null || maze.length == 0) {
            return false;
        }

        int m = maze.length;
        int n = maze[0].length;

        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; //UDLR

        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        maze[start[0]][start[1]] = 2;

        while(!queue.isEmpty()) {

            int[] curr = queue.poll();

            if(curr[0] == destination[0] && curr[1] == destination[1]) {
                return true;
            }

            for(int[] dir : dirs) {
                int nr = curr[0];
                int nc = curr[1];

                while(nr >=0 && nr < m && nc >=0 && nc < n && maze[nr][nc] != 1) {
                    nr = nr + dir[0];
                    nc = nc + dir[1];
                }

                nr = nr - dir[0];
                nc = nc - dir[1];

                if(maze[nr][nc] != 2) {
                    queue.add(new int[]{nr, nc});
                    maze[nr][nc] = 2;
                }
            }

        }

        return false;
    }
}