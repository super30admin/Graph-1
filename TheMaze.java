import java.util.LinkedList;
import java.util.Queue;

public class TheMaze {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;

        Queue<int []> q = new LinkedList<>();
        int [][] dirs = {{0,1},{1,0}, {0, -1}, {-1, 0}};
        q.offer(start);
        maze[start[0]][start[1]] = 2;

        while(!q.isEmpty()){
            int[] current = q.poll();
            int row = current[0];
            int col = current[1];
            if(row == destination[0] && col == destination[1]) return true;

            for (int[] dir : dirs) {
                int i = row;
                int j = col;
                while (i >= 0 && j >= 0 && i < m && j < n && (maze[i][j] == 0 || maze[i][j] == 2)) {
                    i += dir[0];
                    j += dir[1];
                }

                i -= dir[0];
                j -= dir[1];
                if (maze[i][j] != 2) {
                    q.offer(new int[]{i, j});
                    maze[i][j] = 2;
                }
            }
        }
        return false;
    }
}
