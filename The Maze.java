// 490. The Maze
// There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.

// Given the ball's start position, the destination and the maze, determine whether the ball could stop at the destination.

// The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You may assume that the borders of the maze are all walls. The start and destination coordinates are represented by row and column indexes.

// //bfs solution tc- m*n incr m+n decrease sc- m*n

//will use bfs for shortest path
// public class Solution{
//     int[][] dirs;
//     int m,n;
//     public boolean hasPath(int[][] maze, int[] start, int[] destination){
//         if(start[0] == destination[0] && start[1] == destination[1]) return true;
//         this.dirs = new int[][]{{-1, 0}, {1,0}, {0,-1}, {0,1}};
//         this.m = maze.length;
//         this.n = maze[0].length;
//         Queue<int[]> q = new LinkedList<>();
        
//         q.add(new int[]{start[0], start[1]});
        
//         maze[start[0]][start[1]] = 2;//visited
        
//         while(!q.isEmpty()){//tc- O(m*n)
//             int[] curr = q.poll();
            
//             for(int[] dir: dirs){
//                 int r = dir[0] + curr[0];
//                 int c = dir[1] + curr[1];
                
//                 while(r >= 0 && c >= 0 && r < m && c < n && maze[r][c] != 1){//tc-O(m+n)
//                     r += dir[0];//keep rolling until ball hit the wall
//                     c += dir[1];
//                 }
//                 r -= dir[0];//going back one place from wall to last position where it should stop
//                 c -= dir[1];
                
//                 if(destination[0] == r && destination[1] == c) return true;
                
//                 if(maze[r][c] != 2){
//                     q.add(new int[]{r,c});
//                     maze[r][c] = 2;
//                 }
//             }
//         }
//         return false;
        
        
//     }
// }


//dfs solution tc- m*n incr m+n decrease stack space sc- m*n
public class Solution{
    int[][] dirs;
    int m,n;
    public boolean hasPath(int[][] maze, int[] start, int[] destination){
        if(start[0] == destination[0] && start[1] == destination[1]) return true;
        this.dirs = new int[][]{{-1, 0}, {1,0}, {0,-1}, {0,1}};
        this.m = maze.length;
        this.n = maze[0].length;
        return dfs(maze, start[0], start[1], destination);
   
    }
    
    public boolean dfs(int[][] maze, int i, int j, int[] destination){
        //base
        if(i == destination[0] && j == destination[1]) return true;
        
        if(maze[i][j] == 2) return false;
        
        maze[i][j] = 2;
        //logic
        
        for(int[] dir: dirs){
                int r = dir[0] + i;
                int c = dir[1] + j;
                
                while(r >= 0 && c >= 0 && r < m && c < n && maze[r][c] != 1){
                    r += dir[0];//keep rolling until ball hit the wall
                    c += dir[1];
                }
                r -= dir[0];//going back one place from wall to last position where it should stop
                c -= dir[1];
                
                if(dfs(maze, r, c, destination)) return true;
               
            }
        
        return false;
        
        
    }
}