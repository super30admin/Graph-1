// TimeComplexity : O(m*n) 
// space complexity : O(m*n)



class maze{
    int m,n;
    int[][] dirs;
boolean hasPath(int[][] maze,int[] s,int[] d){
    if(maze==null || maze.length==0) return false;
    if(s==d) return true;
    m = maze.length;
    n = maze[0].length;
    dirs= new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    return dfs(maze,s,d);
}

boolean dfs(int[][] maze,int[] s,int[] d){
    //base
    if(s[0]==d[0] && s[1] == d[1]) return true;
    
    //logic

    int i=s[0],j=s[1];
    maze[i][j] = 2;
     for(int[] dir:dirs){

         while(i<m && i>=0 && j<n && j>=0 && maze[i][j]!=1){
            i +=dir[0];
            j +=dir[1];
         } 

         i -=dir[0];
         j -=dir[1];
         if(maze[i][j]!=2 && dfs(maze,new int[]{i,j},d)) return true;
 
     }
     return false;

}

boolean bfs(int[][] maze,int[] s,int[] d){
    maze[s[0]][s[1]]=2;
    Queue<int[]> q = new LinkedList<>();
    q.add(s);
    int i,j;
    while(!q.isEmpty()){
       int[] pos = q.poll();
       i = pos[0];
       j = pos[1];
       for(int[] dir:dirs){        
        while(i<m && i>=0 && j<n && j>=0 && maze[i][j]!=1){
            i +=dir[0];
            j +=dir[1];
         } 
         i -=dir[0];
         j -=dir[1];         
         if(maze[i][j]!=2){
            if(i==d[0] && j==d[1]) return true;
            maze[i][j]=2;
            q.add(new int[]{i,j});
         }
         
       }

    }
    return false;
    
}

}