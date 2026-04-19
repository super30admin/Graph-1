// TC: O(m * n)
// SC: O(m * n)
class Solution {
    int[][] dirs;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze.length == 0 || maze[0].length == 0) return false;
        dirs = new int[][]{{1,0},{0,1},{-1, 0}, {0, -1}};
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        maze[start[0]][start[1]]=2;
        while(!q.isEmpty()){
            int[] cordinate = q.poll();
            for(int[] dir: dirs){
                int nr = dir[0] + cordinate[0];
                int nc = dir[1] + cordinate[1];
                while(nr >= 0 && nc >= 0 && nr < maze.length && nc < maze[0].length && maze[nr][nc] != 1){
                    nr = nr + dir[0];
                    nc = nc + dir[1];
                }
                nr = nr - dir[0];
                nc = nc - dir[1];
                if(nr == destination[0] && nc == destination[1])
                    return true;
                if(maze[nr][nc] != 2){
                    maze[nr][nc] = 2;
                    q.add(new int[]{nr,nc});
                }
            }
        }
        return false;
    }
}