// TC : O(M*N)
// SC : O(M*N)
// BFS
class Solution {
    
    private boolean check(int m, int n, int i, int j) {
        if(i >= 0 && i < m && j >=0 && j < n)
            return true;
        return false;
    }
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        
        if(maze == null || maze.length == 0)
            return false;
        
        int m = maze.length;
        int n = maze[0].length;
        int[][] dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        
        Queue<int[]> q = new LinkedList<>();
        
        q.add(new int[]{start[0],start[1]});
        maze[start[0]][start[1]] = -1;
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            
            for(int[] dir : dirs) {
                int i = curr[0];
                int j = curr[1];
                while(check(m,n,i,j) && maze[i][j] != 1) {
                    i = i + dir[0];
                    j = j + dir[1];
                }
                i = i - dir[0];
                j = j - dir[1];
                if(maze[i][j] == 0) {
                    if(i == destination[0] && j == destination[1])
                        return true;
                    q.add(new int[]{i,j});
                    maze[i][j] = -1;
                }
                
            }
        }
        return false;
    }
}
