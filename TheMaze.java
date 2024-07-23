import java.util.LinkedList;
import java.util.Queue;

//Time - O(m*n) * (m+n) - the m*n is because we are traversing entire matrix, and for each element in the matrix we are traversing all rows and all columns (inner while loop). example of this is consider an element in any one of the corners, we will traverse all rows and all columns.
//space - O(m*n)
class TheMaze {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze == null || maze.length == 0) {
            return false;
        }

        int m = maze.length;
        int n = maze[0].length;
        int[][] dirs = new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start[0], start[1]});
        maze[start[0]][start[1]] = 2;

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            if(curr[0] == destination[0] && curr[1] == destination[1]) {
                return true;
            }
            for(int[] dir : dirs) {
                int nr = curr[0];
                int nc = curr[1];
                while(nr < m && nr >= 0 && nc < n && nc >= 0 && maze[nr][nc] != 1) {
                    nr = nr + dir[0];
                    nc = nc + dir[1];
                }
                nr = nr - dir[0];
                nc = nc - dir[1];
                if(maze[nr][nc] != 2) {
                    q.add(new int[]{nr, nc});
                    maze[nr][nc] = 2;
                }
            }
        }

        return false;
    }
}
