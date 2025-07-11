//TC : O(m*n)
//SC : O(m*n)
class Solution {
    int[][] dirs;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        Queue<int []> q = new LinkedList<>();
        q.add(start);
        maze[start[0]] [start[1]] = 2;
        dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        while(!q.isEmpty()){
            int [] curr = q.poll();
            for(int [] dir : dirs){
                int r = curr[0];
                int c = curr[1];
                while(r >=0  && r < m && c>=0 && c<n && maze[r][c] != 1){
                    r += dir[0];
                    c += dir[1];
                }
                r -= dir[0];
                c -= dir[1];
                if(r == destination[0] && c == destination[1]) return true;
                if(maze[r][c] !=2){
                    q.add(new int[]{r,c});
                    maze[r][c] =2;
                }
            }
        }
        return false;
    }
}
