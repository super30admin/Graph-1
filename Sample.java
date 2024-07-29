//Problem1
//TC O(n)
//SC O(n)
class Solution {
    public int findJudge(int n, int[][] trust) {
        if(n==0) return -1;
        int indegree[]=new int[n];
        for(int t[]:trust)
        {
            indegree[t[0]-1]--;
            indegree[t[1]-1]++;
        }
        for(int i=0;i<n;i++)
        {
            if(indegree[i]==n-1){
                return i+1;
            }
        }
        return -1;
    }
}

//Problem2
//TC O(n*m)
//SC O(n*m)

class Solution {
    int m,n;
    int dirs[][];
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
      if(maze==null || maze.length==0)
      {
        return false;
      }  
      m=maze.length;
      n=maze[0].length;
      dirs= new int[][]{{-1,0},{1,0},{0,-1},{0,1}};// U D L R
      return dfs(maze,start,destination);
    }
    private boolean dfs(int maze[][],int start[], int destination[])
    {
        // base
        if(start[0]==destination[0]&& start[1]==destination[1])
        {
            return true;
        }
        //lofic
        maze[start[0]][start[1]]=2;// visited
        for(int dir[]:dirs)
        {
            int nr=start[0];
            int nc=start[1];
            while(nr>=0 && nr<m &&nc>=0 && nc<n && maze[nr][nc]!=1)
            {
                nr=nr+dir[0];
                nc=nc+dir[1];
            }
            nr=nr-dir[0];
            nc=nc-dir[1];
                if(maze[nr][nc]!=2)
                {
                    if(dfs(maze,new int[]{nr,nc}, destination))
                    {
                        return true;
                    }
                }
            
        }

        return false;
    }
}