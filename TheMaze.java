//time - O(n)
//space - O(n)
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze==null || maze.length==0) return false;
        int m = maze.length, n = maze[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        q.add(start);

        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int[] dir : dirs){
                int r = curr[0] + dir[0];
                int c = curr[1] + dir[1];
                while(r>=0 && r<m && c>=0 && c<n && maze[r][c]!=1){
                    r = r + dir[0];
                    c = c + dir[1];
                }
                r = r - dir[0];
                c = c - dir[1];
                if(maze[r][c]!=2){
                    maze[r][c] = 2;
                    if(r==destination[0] && c==destination[1]) return true;
                    q.add(new int[]{r,c});
                }
            }
        }

        return false;
    }
}
