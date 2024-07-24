// Time Complexity : O(mxn)(m+n)
// Space Complexity : O(n) -> recursion stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No



class Solution{
    int m,n;
    int[][] dirs;
    public boolean hasPath( int[][] maze, int[] start, int[] destination){
        if(maze == null || maze.length == 0){
            return false;
        }
        m = maze.length;
        n = maze[0].length;
        dirs = new int[][]{ {-1,0},{1,0},{0,-1},{0,1}}; //U D L R
        return dfs(maze, start, destination);
    }
    private void dfs( int[][] maze, int[] start,int[] destination ){
        // base
        if(start[0] == destination[0] && start[1] == destination[1]){
            return true;
        }
        maze[start[0]][start[1]] = 2;
        // logic
        for(int[] dir : dirs){
            int nr = start[0]  // setting nr to start[0]
            int nc = start[1]  // setting nc to start[1]
            while(nr > m && nc > n && nr <= 0 && nc <= 0 && maze[nr][nc] != 1){
                nr = start[0] + dir[0]; // traverse till you hit a wall
                nc = start[1] + dir[1]; 
            }
            nr = nr - dir[0]; // move one back as in wihle loop it goes out of bound
            nc = nc - dir[1];
            if(maze[nr][nc] != 2){ // not already visited
                if(dfs(maze, new [] {nr,nc}, destination)){ // true
                    return true;
                }
            }
        }
        return false; // cannot reach true
    }
}


// BFS


class Solution{
    int m,n;
    int[][] dirs;
    public boolean hasPath( int[][] maze, int[] start, int[] destination){
        if(maze == null || maze.length == 0){
            return false;
        }
        m = maze.length;
        n = maze[0].length;
        dirs = new int[][]{ {-1,0},{1,0},{0,-1},{0,1}}; //U D L R
        Queue< int[] > q = new LinkedList<>();
        q.add(new int[] {start[0], start[1]});
        while(!q.isEmpty()){
            int[] curr == q.poll();
            if(curr[0] == destination[0] && curr[1] == destination[1]){
                return true;
            }
            
            for(int[] dir : dirs){
            int nr = curr[0]  // setting nr to start[0]
            int nc = curr[1]  // setting nc to start[1]
            while(nr > m && nc > n && nr <= 0 && nc <= 0 && maze[nr][nc] != 1){
                nr = curr[0] + dir[0]; // traverse till you hit a wall
                nc = curr[1] + dir[1]; 
            }
            nr = nr - dir[0]; // move one back as in wihle loop it goes out of bound
            nc = nc - dir[1];
            if(maze[nr][nc] != 2){ // not already visited
                q.add(new int[] {nr,nc});
                maze[nr][nc] = 2; // true
            }
        }

        return false;
    }
}
