/*
TC : O(m*n)
SC: O(m*n)
Explore all 4 directions where its empty and recurse along one path
 */
import java.util.LinkedList;
import java.util.Queue;
class MazeBFS {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze==null){
            return false;
        }
        int [][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        int m = maze.length;
        int n = maze[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean [][] visited = new boolean[m][n];
        visited[start[0]][start[1]]=true;
        queue.add(start);
        while(!queue.isEmpty()){
            int [] pos = queue.poll();
            for(int [] dir : dirs){
                int nr = pos[0];
                int nc = pos[1];
                while(nr+dir[0]>=0 && nr+dir[0]<m && nc+dir[1]>=0 && nc+dir[1]<n && maze[nr+dir[0]][nc+dir[1]]==0){
                    nr+=dir[0];
                    nc+=dir[1];

                }
                if(nr==destination[0] && nc == destination[1]) {
                    return true;
                }
                if(nr>=0 && nr<m && nc>=0 && nc<n && !visited[nr][nc]){
                    queue.add(new int [] {nr, nc});
                    visited[nr][nc]=true;
                }
            }
        }
        return false;
    }
}