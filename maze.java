
//BFS
//TC: O(m*n)
//SC: O(m*n)
class Solution {
    int[][] dirs;
    int m;
    int n;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        m = maze.length;
        n = maze[0].length;
        
        //null
        if(maze == null || m == 0) return false;
        dirs = new int[][] {{-1,0},{0,1},{1,0},{0,-1}};
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        maze[start[0]][start[1]] = 2;
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int[] dir:dirs){
                int i = curr[0];
                int j = curr[1];
                
                while(i>=0 && j >= 0 && i < m && j < n &&maze[i][j] != 1){
                    i+=dir[0];
                    j+=dir[1];
                }
                i-=dir[0];
                j-=dir[1];
                if(maze[i][j] != 2){
                    q.add(new int[]{i,j});
                    if(i == destination[0] && j == destination[1]) return true;
                    maze[i][j] = 2;
                }
                
            }
        }
        return false;
    }
}
