//TC:O(m*n) m= no. of rows , n= no. of columns in maze matrix ,each node can be processed only once
//SC:O(m*n)


//bfs
class solution{
    int[][] dirs;
    int m,n;
    public boolean hasPath(int[][] maze , int[] start , int[] destination){
        //null
        if(maze== null ||maze.length==0) return false;
        dirs= new int[][] {{-1,0},{1,0},{0,-1},{0,1}};  //taking dirs array
        m=maze.length;
        n=maze[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.add(start); //adding start to queue
        maze[start[0]][start[1]] =2;
        while(!q.isEmpty()){
            int[] curr = q.poll();   //popping out from queue
            if(curr[0]==destination[0] && curr[1]==destination[1]) return true;  //if node coming out of queue is destination , return true
            for(int[] dir : dirs){
                int i= curr[0];
                int j= curr[1];
                while(i>=0 && j>=0 && i<m && j<n && maze[i][j]!=1){
                    i+=dir[0];    //increasing i and j till we do reach out of bounds or till hurdle is not found
                    j+=dir[1];
                }
                i-=dir[0];    //to find the position of actual stoppage , go one step back in the same direction
                j-=dir[1];

                if(maze[i][j]!=2){
                    q.add(new int[] {i,j});   //adding neighbours of curr in queue
                    maze[i][j]=2;   //marking it as 2 i.e markinh it as visited
                }
            }
        }
        return false;
    }
}

//dfs

class solution{
    int[][] dirs;
    int m,n;
    public boolean hasPath(int[][] maze , int[] start , int[] destination){
        //null
        if(maze== null ||maze.length==0) return false;
        dirs= new int[][] {{-1,0},{1,0},{0,-1},{0,1}};  //taking dirs array
        m=maze.length;
        n=maze[0].length;
        return dfs(maze,start,destination);
    }
    private boolean dfs(int[][] maze , int[] curr , int[] destination){
        //base
        if(maze[curr[0]][curr[1]]==2) return false;
        if(curr[0]==destination[0] && curr[1]==destination[1]) return true;

        //logic
        maze[curr[0]][curr[1]]=2; //making start position as visited
        for(int[] dir : dirs){
            int i= curr[0];
            int j= curr[1];
            while(i>=0 && j>=0 && i<m && j<n && maze[i][j]!=1){
                i+=dir[0];    //increasing i and j till we do reach out of bounds or till hurdle is not found
                j+=dir[1];
            }
            i-=dir[0];    //to find the position of actual stoppage , go one step back in the same direction
            j-=dir[1];
            if(dfs(maze,new int[] {i,j},destination)) return true;
        }
        return false;
    }
}