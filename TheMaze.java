//Problem 115 : The Maze
//TC:O(mn)
//SC:O(mn)

/*
Eg: maze = [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]], start = [0,4], destination = [3,2]
OP Matrix: [
            [2, 2, 1, 2, 2], 
            [2, 0, 2, 2, 2], 
            [2, 2, 2, 1, 2], 
            [1, 1, 0, 1, 1], 
            [2, 0, 2, 0, 2]
            ] 
*/

import java.util.*;
    //BFS Solution
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        
        Queue<int[]> q = new LinkedList<>();
        maze[start[0]][start[1]] = 2;
        q.offer(new int[]{start[0],start[1]});
        
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        int m=maze.length;
        int n=maze[0].length;
        while(!q.isEmpty()){
            
            int[] curr = q.poll();
            
            if(curr[0]==destination[0] && curr[1]==destination[1]) return true;
            
            for(int[] dir:dirs){
                
                int r = curr[0] + dir[0];
                int c = curr[1] + dir[1];
                
                //for going to next valid coordinate, where ball can stop either it can be a coordinate which contains 1 pr boundary of the maze
                while(r>=0 && c>=0 && r<m && c<n && maze[r][c]!=1){
                    r += dir[0];
                    c += dir[1];
                }
                

                //bring it back to stop point 

                //because for 1st case if current r n c are at 1 then then ball will be stopping at above that corrd, we have to push those corrdinates into the queue, otherwise if ball hitted the boundary, then above r n c will become out of bounds i.e decrementing r n c
                 r -= dir[0];
                 c -= dir[1];
                
                if(maze[r][c]!=2){
                    maze[r][c] = 2;
                    q.offer(new int[]{r,c});
                }
                
            }
            
        }
        //System.out.println(Arrays.deepToString(maze));
        return false;
    }
}

//DFS
/*
class Solution {
    int[][] dirs;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
         dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
          
        int m = maze.length;
        int n = maze[0].length;
        
         return helper(maze,start,destination,m,n);
        
    }
    
    private boolean helper(int[][] maze, int[] start, int[] destination, int m, int n){
        
        //base
        
        if(start[0]==destination[0] && start[1]==destination[1]) return true;
        
        //logic
        maze[start[0]][start[1]] = 2;
        for(int[] dir: dirs){
            
            int r = start[0] + dir[0];
            int c = start[1] + dir[1];
            
            while(r>=0 && c>=0 && r<m && c<n && maze[r][c]!=1){
                r += dir[0];
                c += dir[1];
            }
            
            r -= dir[0];
            c -= dir[1];
            
            if(maze[r][c]!=2){
                if(helper(maze,new int[]{r,c},destination,m,n)) return true;
            }
        }
        
        return false;
    }
    
}

*/