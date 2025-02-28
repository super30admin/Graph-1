//Time Complexity: O(m*n)
//Space Complexity:O(1)

public class TheMaze {
        int m =0; int n=0;
        int [][] dirs = {{0,1}, {0,-1}, {1,0}, {-1, 0}};
        public boolean hasPath(int[][] maze, int[] start, int[] destination) {

            if(maze == null || maze.length ==0){
                return false;
            }
            m = maze.length;
            n = maze[0].length;
            return dfs(maze, start, destination);
        }

        private boolean dfs(int[][] maze, int[] start, int[] destination){

            int i = start[0];
            int j = start[1];
            if(i == destination[0] && j == destination[1]) return true;
            if(maze[i][j] == 2) return false;
            maze[i][j] = 2;

            for(int[] dir: dirs){
                int nr = start[0];
                int nc = start[1];
                while(nr >= 0 && nr < m && nc>= 0 && nc<n && (maze[nr][nc] == 0 || maze[nr][nc] == 2)){
                    nr += dir[0];
                    nc += dir[1];
                }
                System.out.println("nr "+nr+" nc "+nc);
                nr = nr - dir[0];
                nc = nc - dir[1];
                System.out.println("nr "+nr+" nc "+nc);
                if(maze[nr][nc] != 2 && dfs(maze, new int[]{nr, nc} , destination)){
                    return true;
                }
            }
            return false;
        }
}
