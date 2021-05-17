//Time Complexity:O((mn)(m+n))
//Space Complexity:O(mn)
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m =maze.length, n=maze[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        int[][] dirs= {{0,1},{1,0},{-1,0},{0,-1}};
        while(!q.isEmpty()){
                int[] pos = q.poll();
                for(int[] dir: dirs){
                    int r =pos[0]+dir[0];
                    int c =pos[1]+dir[1];
                    while(r>=0 && c>=0 && r<m && c<n && maze[r][c]!=1){
                        r=r+dir[0];
                        c=c+dir[1];
                    }
                    r=r-dir[0];
                    c=c-dir[1];
                    if(r==destination[0] && c==destination[1])return true;
                    if(maze[r][c]!=2){
                        q.add(new int[]{r,c}); 
                        maze[r][c]=2;
                    }
            }
        }
        return false;
    }
}