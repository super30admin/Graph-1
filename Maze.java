
//BFS Solution
//Time Complexity : O(m*n)
//Space Complexity :O(m*n)
//Did it run on leet code : yes
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
     
        if(maze == null || maze.length == 0)
            return false;
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        int m = maze.length;
        int n = maze[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        maze[start[0]][start[1]] =2;
        while(!queue.isEmpty()){
            int[] arr = queue.poll();
            if(arr[0] == destination[0] && arr[1] == destination[1])
                return true;
            for(int[] dir : dirs){
                 int row = arr[0];
                  int col = arr[1];
                while(row < m && col < n && row >=0 && col>=0 && maze[row][col]!=1 ){
                    row+=dir[0];
                    col+=dir[1];
                }
                row -= dir[0];
                col -= dir[1];
               if(maze[row][col] !=2 ){
                   maze[row][col] = 2;
                   queue.add(new int[]{row,col});
               } 
            }
        }
        
        
        return false;
    }
}
























//DFS solution

//Time Complexity : O(m*n)
//Space Complexity :O(m*n)
//Did it run on leet code : yes
// the main idea here is to perfom dfs from the starting until you dont get 1
//after getting 1 start dfs from there.

class Solution {
    int[][] dirs;
    int m;
    int n;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
     
        if(maze == null || maze.length == 0)
            return false;
        dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        m = maze.length;
        n = maze[0].length;

        return dfs(maze,start,destination);   
     }
    
    private boolean dfs(int[][] maze, int[] start , int[] destination){
        
        //base
        if(start[0] == destination[0] && start[1] == destination[1])
            return true;
        //logic
        for(int[] dir : dirs){
            int r = start[0];
            int c = start[1];
            
            while(r>= 0 && r < m && c>=0 && c <n && maze[r][c]!=1){
                r+=dir[0];
                c+=dir[1];
            }
            r-=dir[0];
            c-=dir[1];
            if(maze[r][c]!= 2){
                maze[r][c]=2;
                if(dfs(maze,new int[]{r,c},destination)) return true;
            }
            
        }
        
        return false;
        
        
    }
}