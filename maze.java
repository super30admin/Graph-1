public class Solution {
    private int[][] dirs;
    private int m ;private int n;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        // do bfs from start position and if we reach at any pint the destination,return true 
        if(start[0]==destination[0] && start[1]==destination[1]) return true;
        m = maze.length;
        n = maze[0].length;

        dirs =new int[][] {{-1,0},{1,0},{0,-1},{0,1}};
        Queue<Integer> q = new LinkedList<>();
        q.add(start[0]);
        q.add(start[1]);
        //visited
        maze[start[0]][start[1]]=2;
        while(!q.isEmpty()){
            int r = q.poll();
            int c = q.poll();
            for(int[] dir:dirs){
                int i =r;int j=c;
                while(i>=0 && i<m && j>=0 && j<n && maze[i][j]!=1){
                    i+=dir[0];
                    j+=dir[1];
                }
                i-=dir[0];
                j-=dir[1];
                if(i==destination[0] && j==destination[1]){
                    return true;
                }
                if(maze[i][j]!=2){
                    q.add(i);
                    q.add(j);
                    maze[i][j]=2;
                }
                
            }

        }
        return false;
    }
} {
    
}
