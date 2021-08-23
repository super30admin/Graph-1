//*****************************************************BFS Approach**************************************************
//T.C:O(m.n. max(m,n))
//S.C:O(m.n)
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        maze[start[0]][start[1]] = 2;
        int m= maze.length;
        int n= maze[0].length;

        while(!queue.isEmpty()){
            int[] curr = queue.poll();

            for(int k=0;k<dir.length;k++){
                int i = curr[0];
                int j = curr[1];

                while(i>=0 && i<m && j>=0 && j<n && maze[i][j]!=1){
                    i+=dir[k][0];
                    j+=dir[k][1];
                }
                i-=dir[k][0];
                j-=dir[k][1];

                if(i == destination[0] && j == destination[1]){
                    return true;
                }
                if(maze[i][j] != 2)
                {
                    queue.add(new int[]{i,j});
                    maze[i][j]=2;
                }
            }
        }
        return false;

    }
}

//*****************************************************DFS Approach**************************************************
//T.C:O(m.n. max(m,n))
//S.C:O(m.n)
class Solution {
    int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        return helper(maze,start,destination,m,n);
    }
    public boolean helper(int[][] maze, int[] start, int[] destination,int m,int n){
        //base
        if(start[0]==destination[0] && start[1]==destination[1]){
            return true;
        }
        //logic
        maze[start[0]][start[1]] = 2;
        for(int k=0;k<dir.length;k++){
            int i = start[0];
            int j = start[1];

            while(i>=0 && j>=0 && i<m && j<n && maze[i][j]!=1) {
                i=i+dir[k][0];
                j=j+dir[k][1];
            }
            i-=dir[k][0];
            j-=dir[k][1];

            if(maze[i][j]!=2 && helper(maze,new int[]{i,j},destination,m,n)) {
                return true;
            }
        }
        return false;
    }

}
