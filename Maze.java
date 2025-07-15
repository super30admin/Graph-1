public class Solution {
     // BFS
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        int[][] dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0;i < size; i++){
                int[] curr = q.poll();
                maze[curr[0]][curr[1]] = 2;
                for(int[] dir : dirs){
                    int r = curr[0];
                    int c = curr[1];
                    while(r < m && r >= 0 && c < n && c >= 0 && maze[r][c] != 1){
                        r+= dir[0];
                        c+= dir[1];
                    }
                    r = r - dir[0];
                    c = c - dir[1];
                    if(r == destination[0] && c == destination[1]) return true;
                    if (maze[r][c] == 0) {
                        q.add(new int[]{r, c});
                        maze[r][c] = 2;
                    }
                }
            }
        }
        return false;
    }
}
