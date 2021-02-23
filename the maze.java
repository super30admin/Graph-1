// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution{
    public boolean hasPath(int[][] maze, int[] start, int[] destination){
        //edge
        if(maze == null || maze.length == 0){
            return false;
        }
        //set the dirs array
        int[][] dirs {{0,1}, {1,0}, {0,-1}, {-1.0}};
        //set a queue 
        Queue<int[]> que = new LinkedList<>();
        //add the start to the queue
        que.add(new int [] {start[0], start[1]});
        maze[star[0]][start[1]];
        //start the while loop on the queue
        while(!que.isEmpty()){
            //get the cur array
            int [] cur = que.poll();
            //if destination is found return true
            if(cur[0] == destination[0] && cur[1] == destination[1]){
                return true;
            }
            for(int [] direc: dirs){
                int [] i = cur[0];
                int [] j = cur[1];
                //start a while loop to go through the neibors
                while(i >= 0 && j >= 0 && i < m && j < n && maze[i][j] == 1){
                    i += dir[0];
                    j += dir[1];
                }
                //take back the direction you went in
                i += dir[0];
                j += dir[1];
                //chec if it is visited or not if not then make it visited
                if(maze[i][j] != 2){
                    //add to the queue
                    que.add(new int [] {i,j});
                    //set to visited
                    maze[i][j] = 2;
                }
            }
        }
        return false;
    }
}