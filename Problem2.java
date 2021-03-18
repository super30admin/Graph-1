//Time complexity-O(mn)
//Space complexity-O(m+n)
//Ran on leetcode-Yes
//Solution with comments-
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        return dfs(maze,start[0],start[1],destination);
    }
    
    int[][] dirs= new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    
    public boolean dfs(int[][]maze, int i, int j,int[] dest){
        if(i==dest[0] && j==dest[1])
            return true;
        
        maze[i][j]=2;
        
        
            for(int[] dir : dirs){
                int r = i;
                int c = j;
                while(r>=0 && r<maze.length && c>=0 && c<maze[0].length && maze[r][c]!=1){//checking only till we hit wall or visited node
                    r+=dir[0];
                    c+=dir[1];
                }
                r-=dir[0];
                c-=dir[1];
                if(maze[r][c]!=2 && dfs(maze,r,c,dest))
                   return true;
        }
        
        return false;
        
    }
}