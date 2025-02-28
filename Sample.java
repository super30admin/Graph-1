class Sample{
    /***********************PROBLEM-1************/
//TC:0(M+N) m=length of trust matrix, n=no of people
//SC:0(N)
    class Solution {
        public int findJudge(int n, int[][] trust) {
            if(n==1){
                return n;
            }
            int[] scores=new int[n];
            for(int[] each:trust){
                scores[each[0]-1]--;
                scores[each[1]-1]++;
            }
            for(int i=0;i<scores.length;i++){
                if(scores[i]==n-1){
                    return i+1;
                }
            }
            return -1;
        }
    }
/************************PROBLEM-2********************/

//DFS
//TC:0((m*n)(m+n))
//SC:0(m+n)
class Solution {
    int m,n;
    int[][] dirs;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze==null || maze.length==0){
            return false;
        }
        m=maze.length;
        n=maze[0].length;
        dirs=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        return dfs(maze,start,destination);
    }

    private boolean dfs(int[][] maze,int[] start,int[] destination){
        //base
        if(start[0]==destination[0]&& start[1]==destination[1]){
            return true;
        }

        //logic
        maze[start[0]][start[1]]=2;
        for(int[] dir:dirs){
            int nr=start[0];
            int nc=start[1];
            while(nr>=0 && nr<m && nc>=0 && nc<n && maze[nr][nc]!=1){
                nr=nr+dir[0];
                nc=nc+dir[1];
            }
            nr=nr-dir[0];
            nc=nc-dir[1];
            if(maze[nr][nc]!=2){
                if(dfs(maze,new int[]{nr,nc},destination)){
                    return true;
                }
            }
        }
        return false;
    }
}

    //bfs
//TC:0(m+n)(m*n)
//SC:0(m+n)
    class Solution {
        int[][] dirs;
        int m,n;
        public boolean hasPath(int[][] maze, int[] start, int[] destination) {
            if(maze==null || maze.length==0){
                return false;
            }
            m=maze.length;
            n=maze[0].length;
            dirs=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
            Queue<int[]> queue=new LinkedList<>();
            queue.add(new int[]{start[0],start[1]});
            maze[start[0]][start[1]]=2;
            while(!queue.isEmpty()){
                int[] curr=queue.poll();
                if(curr[0]==destination[0] && curr[1]==destination[1]){
                    return true;
                }
                for(int[] dir:dirs){
                    int nr=dir[0]+curr[0];
                    int nc=dir[1]+curr[1];
                    while(nr>=0 && nr<m &&nc>=0 && nc<n && maze[nr][nc]!=1){
                        nr=nr+dir[0];
                        nc=nc+dir[1];
                    }
                    nr=nr-dir[0];
                    nc=nc-dir[1];
                    if(maze[nr][nc]!=2){
                        queue.add(new int[]{nr,nc});
                        maze[nr][nc]=2;
                    }
                }
            }
            return false;
        }
    }

}
