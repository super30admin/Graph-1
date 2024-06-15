// TC: O(mn(m+n))
// S: O(mn)

class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;

        if(start[0] == destination[0] && start[1] == destination[1]) return true;

        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

        Queue<int[]> q = new LinkedList<>();
        q.add(start);

        maze[start[0]][start[1]]= 2;

        while(!q.isEmpty()){
            int[] curr = q.poll();

            for( int[] dir : dirs){
                int nr = curr[0]+ dir[0];
                int nc = curr[1]+ dir[1];

                while(nr >= 0 && nc >= 0 && nr < m && nc <n && maze[nr][nc] != 1){
                    nr += dir[0];
                    nc += dir[1];
                }
                nr -= dir[0];
                nc -= dir[1];

                if(nr == destination[0] && nc == destination[1]) return true;
                if(maze[nr][nc] != 2){
                    q.add(new int[]{nr,nc});
                    maze[nr][nc] = 2;
                }
            }
        }
        return false;
    }
}