//Time Complexity:O(mn)
//Space Complexity:O(mn)
class Solution {
    int m;int n;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze.length==0 || maze==null) return false;
         m=maze.length;
         n=maze[0].length;
        return helper(maze,start,destination);

    }
    private boolean helper(int[][] maze, int[] start, int[] destination)
    {
        if(maze[start[0]][start[1]]==2) return false;
        if(start[0]==destination[0] && start[1]==destination[1]) return true;

        int [][] dirs={{0,-1},{0,1},{1,0},{-1,0}};
        maze[start[0]][start[1]]=2;
        for(int dir[]:dirs)
        {
           int i=start[0];
           int j= start[1];
            while(i<m &&i>=0 &&j<n&&j>=0 &&maze[i][j]!=1)
            {
                i=i+dir[0];
                j=j+dir[1];
            }
            i=i-dir[0];
            j=j-dir[1];
           if( helper(maze,new int[]{i,j},destination)) return true;
        }
        return false;
    }
}