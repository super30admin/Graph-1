//Time Complexity - O((m*n)(m+n)) - O(m*n)
//Space Complexity - O(m*n)

class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze == null) return false;
        int m = maze.length; int n = maze[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        //mark the starting point is visited
        maze[start[0]][start[1]] = 2;
        int[][]dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            //traverse untill the ball border wall or obstacle that is element 1
            for(int[] dir:dirs) {
                int i = curr[0];
                int j = curr[1];
                while(i<m && i>=0 && j<n && j>=0 && maze[i][j]!=1){
                    i += dir[0];
                    j += dir[1];
                }
                //reached at obsacle. We need to step back 
                i -= dir[0];
                j -= dir[1];
                if(i == destination[0] && j == destination[1]){
                    return true;
                }
                if(maze[i][j] != 2) {
                    //if the cell is not visited then add the row and column index   inside queue 
                    q.add(new int[]{i,j});
                    maze[i][j] = 2;
                }
            }
        }
        return false;
    }
}