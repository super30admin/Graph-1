//DFS
//Start from the starting position till it reaches the wall by exploring in all 4 directions
//Once found proceed taking this as the start and perform dfs again
//Continue till start reaches the destination
class Solution {
    int m; int n ;
     int[][]dirs = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
         //edge
        if(maze == null || maze.length == 0) return false;
         m = maze.length;  n = maze[0].length;
        maze[start[0]][start[1]] = 2;
        return dfs(maze,start,destination);
    }
   
    private boolean dfs(int[][] maze, int[] start, int[] destination) {
    //base
    if(start[0] == destination[0] && start[1] == destination[1]) return true;
   
    //logic
        for(int[] dir: dirs){
            int r = start[0]; int c = start[1];
            while(r>=0 && r<m && c>=0 && c<n && maze[r][c] != 1){
                r+= dir[0]; c+= dir[1];
            }
            r-=dir[0]; c-=dir[1];
            if(maze[r][c] != 2){
                maze[r][c] = 2;
                //start exploring from visited
                if(dfs(maze,new int[]{r,c}, destination)){
                    return true;
                }
             }
        }
        return false;
    }
}

/*
Time complexity:O(mn)
Space complexity : O(mn) size of recursive stack
*/


// Approach -
// In BFS, Add starting point into queue and we traverse from that cell and select next children when we
// reach either out of bound or wall. When we reach the wall, we move to previous cell and enter the new children into queue.
// We mark the place as 2 to indicate that it is already visited. If we reach destination, return true - otherwise false.

class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
       if(maze == null  || maze.length == 0) return false;
       Queue<int[]> q = new LinkedList<>();
       int[][] dirs = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        int m = maze.length;
        int n = maze[0].length;
        //start point mark visited and then proceed by putting in queue
        maze[start[0]][start[1]] = 2;
        q.add(start);
       
        while(!q.isEmpty()){
            int[] curr = q.poll();
           
            // explore directions for curr
            for (int[] dir : dirs){
                int r = curr[0];
                int c = curr[1];
                if(r == destination[0] && c == destination[1]) return true;
                while(r>=0 && r<m && c>=0 && c<n && maze[r][c] != 1){
                    r+=dir[0]; c+=dir[1];
                }
                //once found take step back
                 r-= dir[0]; c-=dir[1];
                if(maze[r][c] != 2){
                    maze[r][c] = 2; //mark it as visited and add to queue
                    q.add(new int[]{r,c});
                }
            }
        }
        return false;
 }
}

/*
Time complexity: O(mn)* 4 directions asymtotically O(mn)
Space complexity : No of elements in the queue O(mn) worst case
*/
