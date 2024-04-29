//Time O(NM) and space O(NM)
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {

        int m = maze.length;
        int n = maze[0].length;

        int[][] dirs = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};

        Queue<int[]> queue = new LinkedList<>();

        queue.add(start);
        maze[start[0]][start[1]] = 2;
        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            
            for(int[] dir:dirs){
                int r = pos[0] + dir[0];
                int c = pos[1] + dir[1];

                while(r>=0 && r<m && c>=0 && c<n && maze[r][c]!=1){
                    r = r+ dir[0];
                    c = c+ dir[1];
                }

                
                r=r-dir[0];
                c=c-dir[1];
                
                if(r==destination[0] && c==destination[1]){
                    return true;
                }
               
                if(maze[r][c]!=2){
                    queue.add(new int[]{r,c});
                }
                maze[r][c]=2;

            }

        }   

        return false;     
    }
}

//Time O(N) and space O(N)
class Solution {
    public int findJudge(int n, int[][] trust) {
        

        int[] trusts = new int[n+1];

        for(int[] t:trust){
            int a = t[0];
            int b = t[1];
            trusts[b]+=1;
            trusts[a]-=1;
        }

        for(int i=1;i<trusts.length;i++){
            if(trusts[i]==n-1) return i;
        }

        return -1;
    }
}
