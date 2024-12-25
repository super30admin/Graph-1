// Approach : connected components - can apply DFS or BFS
// Time : 
// O(m*n) // inside maze + O(m+n) // All the nodes went processing into the queue if we have more obstacles
// O(m*n) // inside maze + O(m+n) // value would be less if we have less obstacles
// Time complexity : O(m*n)
// Space : O(m*n)
class Solution {
    int[][] dirs ;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        this.dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        int m = maze.length;
        int n = maze[0].length;
        Queue<int[]> q = new LinkedList<>(); // store index of the cells
        q.add(new int[]{start[0],start[1]}); // Add starting indexes into queue
        maze[start[0]][start[1]] = -1 ; // mark position as visited

        while(!q.isEmpty()){ // O(m*n)
            int[] curr = q.poll();
            // traverse through all dirs from standing position
            for(int[] dir : dirs){
                int r = dir[0]+curr[0];
                int c = dir[1]+ curr[1];
                // keep rolling over until you hit the wall
                while(r>=0 && c>=0 && r<m && c<n && maze[r][c]!=1){//O(m+n)
                    r+=dir[0];
                    c+=dir[1];
                }
                // After we hit the wall - come one step back
                r-=dir[0];
                c-=dir[1];
                // check if you have landed at destination or not
                if(r==destination[0] && c== destination[1]){
                    return true;
                }
                // before adding the children to the queue check of they are visited
                if(maze[r][c] !=-1){
                    q.add(new int[]{r,c});
                    // after adding mark them visited
                    maze[r][c] = -1;
                }
                
            }
        }

        return false;
    }
}


// Approach : connected components - can apply DFS or BFS
// Time : 
// O(m*n) // inside maze + O(m+n) // All the nodes went processing into the queue if we have more obstacles
// O(m*n) // inside maze + O(m+n) // value would be less if we have less obstacles
// Time complexity : O(m*n) // worst case
// Space : O(m*n)
class Solution {
    int[][] dirs ;
    int m,n;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        this.dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        this.m = maze.length;
        this.n = maze[0].length;
        return helper(maze,start[0],start[1],destination);
    }

    private boolean helper(int[][] maze, int i , int j , int[] destination){
        // base case
        if(i == destination[0] && j == destination[1]){
            return true;
        }

        // if landed on already visited then do not explore the path
        if(maze[i][j]==-1){
            return false;
        }

        // logic
        maze[i][j] = -1 ; // mark visited
        for(int[] dir:dirs){
            int r = dir[0] + i;
            int c = dir[1] +j;
            // keep rolling until you hit the wall
            while(r>=0 && c>=0 && r<m && c<n && maze[r][c]!=1){
                r+=dir[0];
                c+=dir[1];
            }
            // come one step back
            r-=dir[0];
            c-=dir[1];

            if(helper(maze, r,c,destination)) return true;
        }

        return false;

    }
}