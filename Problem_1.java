// Time Complexity :O(n)
// Space Complexity :o(1)
// Did this code successfully run on Leetcode :
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach


class Solution {
    int [][] dirs;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        //[[0,0,1,0,0],
        // [0,0,0,0,0],
        // [0,0,0,1,0],
        // [1,1,0,1,1]
        if(maze==null || maze.length==0){
            return false;
        }
        dirs=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        return dfs(maze,start,destination);
    }
    
    public boolean dfs(int[][] maze, int[] start, int[] destination){
        if(maze[start[0]][start[1]]==2){
            return false;
        }
        if(start[0]==destination[0] && start[1]==destination[1]){
            return true;
        }
        
        maze[start[0]][start[1]]=2;
        for(int[] dir:dirs){
            int i=start[0]+dir[0];
            int j=start[1]+dir[1];
            while(i>=0 && j>=0 && i<maze.length && j<maze[0].length && maze[i][j]!=1){
                i=i+dir[0];
                j=j+dir[1];
            }
            i=i-dir[0];
            j=j-dir[1];
            if(dfs(maze,new int[]{i,j},destination)){
                return true;
            }
        }
        return false;
    }
}

////
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        //[[0,0,1,0,0],
        // [0,0,0,0,0],
        // [0,0,0,1,0],
        // [1,1,0,1,1]
        if(maze==null || maze.length==0){
            return false;
        }
        int [][] dirs={{0,1},{1,0},{0,-1},{-1,0}};
        Queue<int[]> qu=new LinkedList<>();
        qu.add(new int[]{start[0],start[1]});
        maze[start[0]][start[1]]=2;
        while(!qu.isEmpty()){
            int[] arr=qu.remove();
            if(arr[0]==destination[0] && arr[1]==destination[1]){
                return true;
            }
            for(int[] dir:dirs){
                int i=arr[0]+dir[0];
                int j=arr[1]+dir[1];
                while(i>=0 && j>=0 && i<maze.length && j<maze[0].length && maze[i][j]!=1){
                    i=i+dir[0];
                    j=j+dir[1];
                }
                i=i-dir[0];
                j=j-dir[1];
                if(maze[i][j]!=2){
                    maze[i][j]=2;
                    qu.add(new int[]{i,j});
                }
            }
        }
        return false;
    }
}