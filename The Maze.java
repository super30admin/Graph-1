//DFS:The main idea is to not call dfs on all the 4 neighbours , but instead go in one direction until the wall is hit and then add the previous cell just before the wall and then move to next direction similarly
//Time Complexity : O(m*n). m is number of col's and n is number of rows
//Space Complexity : O(m*n)
class Solution {
     boolean result;
    int dir[][] = {{1,0},{-1,0},{0,-1},{0,1}};
    int row,col;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze==null||maze.length==0){
            return false;
        }
        result = false;
        row = maze.length;
        col = maze[0].length;
        //visited = new boolean[row][col];
         return dfs(maze,start,destination);
       
    }
    public boolean dfs(int[][] maze, int[] start, int[] destination){
        if(start[0]==destination[0] && start[1]==destination[1]){
            return true;
        }
        maze[start[0]][start[1]] = 2;//mark visited
        for(int[] d : dir){
            int r = d[0] + start[0];
            int c = d[1] + start[1];
            while(r>=0 && c >=0 && r <row && c<col && maze[r][c]!=1){
                r = d[0] + r;
                c = d[1] + c;
            }
            //inorder to get the correct position of r and c,sub 
                r = r - d[0];
                c = c - d[1];
                //if not visited , thenvisit
            if(maze[r][c]!=2 && dfs(maze,new int[]{r,c},destination))
            {
                return true;
            }
        }
        return false;
    }
}
//BFS
//Time Complexity : O(m*n). m is number of col's and n is number of rows
//Space Complexity : O(m*n)
class Solution {
   // boolean[][] visited;
    boolean result;
    int dir[][] = {{1,0},{-1,0},{0,-1},{0,1}};
    int row,col;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze==null||maze.length==0){
            return false;
        }
        result = false;
        row = maze.length;
        col = maze[0].length;
        //visited = new boolean[row][col];
        bfs(maze,start,destination);
        return result;
    }
    public void bfs(int[][] maze, int[] start, int[] destination){
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()){
            //pop the parent cell
            int[] cur = q.poll();
            //mark it as visited
            //visited[cur[0]][cur[1]] = true;
            //check the current cell is thye destination
            if(cur[0]==destination[0] && cur[1]==destination[1]){
                result = true;
                return;
            }
            for(int[] d : dir){
                //check in the four directions
                int r = d[0] + cur[0];
                int c = d[1] + cur[1];
                while(r>=0 && c >=0 && r <row && c<col && maze[r][c]!=1){
                    //go in either of the direction until 1/ wall is reached
                    r = d[0] + r;
                    c = d[1] + c;
                }
                //inorder to get the correct position of r and c,sub 
                r = r - d[0];
                c = c - d[1];
                //if not visited , then add it to the queue
               //if(!visited[r][c]){
                if(maze[r][c]!=2){
                    maze[r][c] = 2;//mark visited
                    q.add(new int[]{r,c});
                }
            }
        }
    }
}