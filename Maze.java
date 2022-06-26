//Space - O(m*n)
//Time - O(m*n*k)
class Solution {
    

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] v = new boolean[m][n];
       int[][] dirs = {{0,-1}, {0,1},{1,0},{-1,0}};
        Queue<int[]> q = new LinkedList<>();
        if(Arrays.equals(start, destination)) return true;
        q.add(start);
        v[start[0]][start[1]] = true;
        while(!q.isEmpty()){
            int[] rc = q.poll();
            for(int[] dir : dirs){
                int i = rc[0];
                int j = rc[1];
                while(i>=0 && i<m &&j>=0 && j<n && maze[i][j]!=1){
                    i+=dir[0];
                    j+=dir[1];
                }
                 i-=dir[0];
                 j-=dir[1];
                if(Arrays.equals(rc, destination))  return true;
                if(v[i][j] == false){
                    q.add(new int[]{i,j});
                    v[i][j]= true;
                }
            }
        }
        return false;
        
    }
    
  
}