import java.util.LinkedList;
import java.util.Queue;
/*
The-Maze
approach: use dfs or bfs and mark cells visited
time: O(mxn)
space: O(mxn)
 */
public class Problem2 {
    int m, n;
    int[][] dirs;
    public boolean hasPath(int[][] maze, int[] start, int[] dest) {
        if (maze==null || maze.length==0) return false;
        m = maze.length;
        n = maze[0].length;
        dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};


        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        maze[start[0]][start[1]] = 2;
        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for (int[] dir: dirs) {
                int nr, nc;
                do {
                    nr = curr[0]+dir[0];
                    nc = curr[1]+dir[1];

                }
                while (nr>=0 && nc>=0 && nr<m && nc<n && maze[nr][nc]!=1);
                nr = dir[0]-1;
                nc = dir[1]-1;

                if ( maze[nr][nc]!=2) {
                    if (nr==dest[0] && nc==dest[1]) return true;
                    q.add(new int[]{nr, nc});
                    maze[nr][nc] = 2;
                }
            }
        }
        return false;
    }
}
