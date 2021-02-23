/*time complexity O(mn) space complexity O(mn) if the recursive stack is considered
approach: from the start element we go towards all its children until a wall is encountered if its already visited then come out of that recursive loop and continue with others 
after a child is found we mark it visited and finally if start reaches destination the return true else false*/


class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze==null || maze.length==0) return false;
        int m=maze.length; int n=maze[0].length;
        return dfs(m,n,start,destination,maze);
    }
    private boolean dfs(int m,int n,int[] start, int[] destination,int[][] maze){
        //base
        if(start[0]==destination[0] && start[1]==destination[1]) return true;
        int[][] dirs=new int[][] {{0,1},{1,0},{-1,0},{0,-1}};
        if(maze[start[0]][start[1]]==2)return false;
        maze[start[0]][start[1]]=2;
        for(int[] dir: dirs){
            int i=start[0];
            int j=start[1];
            while(i<m &&j<n && i>=0 && j>=0 && maze[i][j]!=1){
                i=i+dir[0];
                j=j+dir[1];
            }
            i=i-dir[0];
            j=j-dir[1];
            if(dfs(m,n,new int[] {i,j},destination,maze)) return true;
        }
        return false;
    }
}