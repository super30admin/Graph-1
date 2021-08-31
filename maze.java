

//BFS approach
//TC: O(mn max(n,m))
//SC: O(mn)
//where m,n are rows and coloumns

class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze==null || destination==null)
            return false;
        if(start[0]==destination[0] && start[1]==destination[1])
            return true;
        int m=maze.length,n=maze[0].length;
        int[][] dirs=new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
        Queue<int[]> q=new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()){
            int cur[]=q.poll();
            for(int[] dir:dirs){
                int i=cur[0];
                int j=cur[1];
                
                while(i<m && j<n && i>=0 && j>=0 && maze[i][j]!=1){
                    i+=dir[0];
                    j+=dir[1];
                }
                i-=dir[0];
                j-=dir[1];
                
                if(destination[0]==i&&destination[1]==j)
                    return true;
                if(maze[i][j]!=2){
                    q.add(new int[]{i,j});
                    maze[i][j]=2;
                }
            }
        }
        return false;
    }
}



//DFS approach

class Solution {
    int[][] dirs;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze==null || destination==null)
            return false;
        if(start[0]==destination[0] && start[1]==destination[1])
            return true;
        int m=maze.length,n=maze[0].length;
        dirs=new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
        
        return dfs(maze,start,destination,m,n);
       
    }
    
    private boolean dfs(int[][] maze, int[] start, int[] destination,int m,int n){
        //base
        if(start[0]==destination[0] && start[1]==destination[1])
            return true;
        
        //logic
        maze[start[0]][start[1]]=2;
        for(int[] dir:dirs){
            int i=start[0];
            int j=start[1];
            while(i<m && j<n && i>=0 && j>=0 && maze[i][j]!=1){
                i+=dir[0];
                j+=dir[1];
            }
            i-=dir[0];
            j-=dir[1];
            if(maze[i][j]!=2 && dfs(maze,new int[]{i,j},destination,m,n))
                return true;
        }
        return false;
    }
    
}