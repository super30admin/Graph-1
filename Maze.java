/*
 * tc - 0(mm)
 * sc - o(mn)
 */
public class Maze {
     //o(mn)
     int dirs[][] = {{-1,0},{1,0}, {0,1}, {0,-1}};
     //dfs approach - mn
     public boolean hasPath(int[][] maze, int[] start, int[] destination) {
         int m = maze.length, n = maze[0].length;
         return dfs(maze,start[0], start[1],destination);
     }
 
     public boolean dfs(int[][] maze, int r, int c, int[] dest){
         int m = maze.length, n = maze[0].length;
         //base case 
         if(dest[0] == r && dest[1] == c) return true;
         if(maze[r][c] == -1) return false;
         //logic 
         maze[r][c] = -1;
         for(int d[]: dirs){
             int i = d[0] + r;
             int j = d[1] + c;
              while(i >= 0 && j >= 0 && i < m && j < n && maze[i][j] != 1){
     //                 //to keep rolling this we find the wall to stop ...in the same direction!
                 i = i + d[0];
                 j = j + d[1];
             }
             i -= d[0];
             j -= d[1];
             if(dfs(maze, i, j, dest)) return true;
         }
         return false;
     }
 
 
 
     //mn - bfs
     // public boolean hasPath(int[][] maze, int[] start, int[] destination) {
     //     int m = maze.length, n = maze[0].length;
 
     //     Queue<int[]> q = new LinkedList<>();
     //     q.offer(new int[]{start[0], start[1]});
     //     maze[start[0]][start[1]] = -1; //for visited 
     //     while(!q.isEmpty()){
     //         int curr[] = q.poll();
     //         for(int d[]: dirs){
     //             int r = curr[0] + d[0];
     //             int c = curr[1] + d[1];
     //             while(r >= 0 && c >= 0 && r < m && c < n && maze[r][c] != 1){
     //                 //to keep rolling this we find the wall to stop ...in the same direction!
     //                 r = r + d[0];
     //                 c = c + d[1];
     //             }
 
     //             //one step back cause we hit the wall
     //             r = r - d[0];
     //             c = c - d[1];
 
     //             if(r == destination[0] && c ==destination[1]){
     //                 return true;
     //             }
 
     //             if(maze[r][c] != -1){
     //                 q.offer(new int[]{r,c});
     //                 maze[r][c] = -1;
     //             }
     //         }
     //     }
     //     return false; 
     // }
}
