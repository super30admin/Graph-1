//TC: O(4*m*n)
//SC: O(m*n)
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length; 
        if(m == 0) return true;
        int n = maze[0].length;
        Queue<int[]> q = new LinkedList();
        q.add(new int[]{start[0], start[1]});
        maze[start[0]][start[1]] = 2;
        while(!q.isEmpty()){
            int[] curr = q.poll();
            if(curr[0] == destination[0] && curr[1] == destination[1]) return true;
            
            int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
            for(int[] dir : dirs){
                int r = curr[0]; int c = curr[1];
                while(r >= 0 && r < m && c >= 0 && c < n && maze[r][c] != 1){
                    r = r + dir[0];
                    c = c + dir[1];
                }
                // bring ball back to the actual position, one behind the obstacle
                r = r - dir[0]; c = c - dir[1];
                if(maze[r][c] != 2) {
                    q.add(new int[]{r,c});
                    maze[r][c] = 2;
                }
            }
        }
        return false;
    }
}
