import java.util.LinkedList;
import java.util.Queue;

public class TheMaze {
    //Time complexity: O(MN)
    //Space complexity: O(1)
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        //explore all paths till we reach a wall
        //BFS

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start[0]);
        queue.offer(start[1]);
        maze[start[0]][start[1]] = 2;


        while (!queue.isEmpty()) {
            int r = queue.poll();
            int c = queue.poll();
            if (r == destination[0] && c == destination[1]) return true;
            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                while (nr >= 0 && nr < maze.length && nc >= 0 && nc < maze[0].length && maze[nr][nc] != 1) {
                    nr = nr + dir[0];
                    nc = nc + dir[1];
                }
                nr = nr - dir[0];
                nc = nc - dir[1];
                if (maze[nr][nc] != 2) {
                    queue.offer(nr);
                    queue.offer(nc);
                    maze[nr][nc] = 2;
                }


            }
        }

        return false;
    }
}
