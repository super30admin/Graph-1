
// In BFS add every possibility of dir and proceed to that direction till it hits the wall  and also visited cells update the value to -1 
// O(mxn) (m+n) , removing constants O(mxn) time complexity in the worst case
// O(mxn) space complexity in worst case
class Solution {
    int[][] dirs = new int[][]{{0,-1}, {0, 1}, {1,0}, {-1,0}};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {

    int m = maze.length;
    int n = maze[0].length;

   Queue<int[]> q = new LinkedList<>();

   q.add(new int[]{start[0], start[1});
   maze[start[0]][start[1] = -1;

   

   while(!q.isEmpty()){

   int[] curr = q.poll()

   for(int[] dir : dirs){
       int r = dir[0] + curr[0];
       int c = dir[1] + curr[1];
   }

   while(r>= 0 && c>= 0 && r <m && c< n && && maze[r][c] != 1){
       r = r+ dir[0];
       c = c+ dir[1];
   }

   r = r- dir[0];
   c= c-dir[1];
   if( r == desitination[0] && c == destination[1]){
       return true;
   }
   if(maze[r][c] != -1){
       q.add(new int[] {r,c});
       maze[r][c] = -1;
   }


   }
   return false;



}
