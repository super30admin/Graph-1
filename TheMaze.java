//TC : O(mxn)
//SC : O(mxn)
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze==null||maze.length==0) return false;

        Queue<int[]> q = new LinkedList<>();
        int m = maze.length;
        int n = maze[0].length;
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

        q.add(new int[]{start[0],start[1]});
        maze[start[0]][start[1]] = 2;

        while(!q.isEmpty())
        {
            int[] curr = q.poll();
            for(int[] dir : dirs)
            {
                int r = curr[0];
                int c = curr[1];
                while(r>=0 && r<m && c>=0 && c<n && maze[r][c]!=1)
                {
                    r=r+dir[0];
                    c=c+dir[1];
                }
                r=r-dir[0];
                c=c-dir[1];
                if(maze[r][c]!=2)
                {
                    maze[r][c] = 2;
                    q.add(new int[]{r,c});
                    if(r==destination[0] && c==destination[1]){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}