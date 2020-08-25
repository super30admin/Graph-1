//Time Complexity : O(n*m)
//Space Complexity : O(n)
// Leetcode : worked

class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze == null || maze.length == 0) return false;
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        int m = maze.length; int n = maze[0].length;
        maze[start[0]][start[1]] = 2;
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        while(!q.isEmpty()){
            int[] curr = q.poll();
            if(curr[0] == destination[0] && curr[1] == destination[1]) return true;
            for(int[] dir : dirs){
                int r = curr[0]; int c = curr[1];
                while(r>=0 && r<m && c>=0 && c<n && maze[r][c] !=1){
                    r += dir[0]; c += dir[1];
                }
                r-= dir[0]; c-= dir[1];
                if( maze[r][c] != 2){
                    maze[r][c] = 2;
                    q.add(new int[] {r,c});
                }
                
            }
        }
        
        return false;
    }
}