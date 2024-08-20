/*
TC -->O(n*m)
SC --> O(n*m)

*/
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {

        Queue<int[]> q = new LinkedList<>();
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        q.add(new int[] {start[0], start[1]});
        maze[start[0]][start[1]] = 2;
        int n = maze.length;
        int m = maze[0].length;
        while(!q.isEmpty()){
            int[] curr = q.poll();
            
            for(int[] dir: directions){
                
                int r = curr[0];
                int c = curr[1];

                while(r>=0 && r<n && c>=0 && c<m && maze[r][c]!=1){
                    r+=dir[0];
                    c+=dir[1];
                }
                r-=dir[0];
                c-=dir[1];

                if(r==destination[0] && c==destination[1]){
                    return true;
                }
                if(maze[r][c]!=2){
                    maze[r][c]=2;
                    q.add(new int[] {r,c});
                }

            }
        }//while


        return false;






        
    }
}